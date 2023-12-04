package com.service.user.service;

import com.service.user.dto.DepartmentDto;
import com.service.user.dto.UsersDto;
import com.service.user.entity.User;
import com.service.user.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsersService {

    @Autowired
    UsersRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<UsersDto> findAll(){
        List<UsersDto> response = new ArrayList<>();
        for(User user: repository.findAll()){
            UsersDto dto = new UsersDto(user);
            if(dto.getDepartmentId()!=null){
                try{

                    DepartmentDto department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/find-by-id?id="+dto.getDepartmentId(), DepartmentDto.class);
                    dto.setDepartment(department);
                }catch (Exception e){
                    log.error("Error getting department with id "+dto.getDepartmentId()+" "+e.getMessage());
                }
            }
            response.add(dto);
        }
        return response;
    }

    public User createUser(User user) throws Exception {
        if(user.getId()!=null){
            User u = repository.findById(user.getId()).orElse(null);
            if(u==null){
                user.setFirstName("User not found");
                return user;
            }else{
                if(user.getFirstName()==null){
                    user.setFirstName(u.getFirstName());
                }
                if(user.getLastName()==null){
                    user.setLastName(u.getLastName());
                }
                if(user.getEmail()==null){
                    user.setEmail(u.getEmail());
                }
            }
        }
        return  repository.save(user);
    }

    public String deleteById(Integer id) {
        User user = repository.findById(id).orElse(null);
        if(null != user){
            repository.deleteById(id);
        }else{
            return "User not found";
        }
        return "User deleted successfully";
    }
}
