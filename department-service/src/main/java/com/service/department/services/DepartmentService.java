package com.service.department.services;

import com.service.department.entity.Department;
import com.service.department.repository.DepartmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }


    public Department createDepartment(Department department) throws Exception {
        if(department.getId()!=null){
            Department dep = departmentRepository.findById(department.getId()).orElse(null);
            if(dep==null){
                department.setName("Department not found");
                return department;
            }else{
                if(department.getName()==null){
                    department.setName(dep.getName());
                }
                if(department.getAddress()==null){
                    department.setAddress(dep.getAddress());
                }
                if(department.getPinCode()==null){
                    department.setPinCode(dep.getPinCode());
                }
            }
        }
        return  departmentRepository.save(department);
    }

    public String deleteById(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if(null != department){
            departmentRepository.deleteById(id);
        }else{
            return "Department not found";
        }
        return "Department deleted successfully";
    }

    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
