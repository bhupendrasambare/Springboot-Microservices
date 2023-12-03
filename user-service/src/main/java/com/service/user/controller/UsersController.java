package com.service.user.controller;

import com.service.user.dto.UsersDto;
import com.service.user.entity.User;
import com.service.user.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UsersController {

    @Autowired
    UsersService usersService;


    @GetMapping("find")
    public List<UsersDto> findAll(){
        return  usersService.findAll();
    }

    @PostMapping("save")
    public User saveUser(@RequestBody User user) throws Exception  {
        log.info("Saving user " + user.toString());
        return usersService.createUser(user);
    }


    @DeleteMapping("delete")
    public String deleteUser(@RequestParam Integer id){
        log.info("deleting user "+id.toString());
        return usersService.deleteById(id);
    }

}
