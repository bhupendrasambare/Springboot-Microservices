package com.service.department.controller;

import com.service.department.entity.Department;
import com.service.department.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("find")
    public List<Department> findALL(){
        log.info("finding all departments");
        return departmentService.findAll();
    }

    @GetMapping("find-by-id")
    public Department findById(@RequestParam Integer id){
        log.info("finding department by id");
        return departmentService.findById(id);
    }

    @PostMapping("save")
    public Department saveDepartment(@RequestBody Department department) throws Exception  {
        log.info("Saving department " + department.toString());
        return departmentService.createDepartment(department);
    }


    @DeleteMapping("delete")
    public String deleteDepartment(@RequestParam Integer id){
        log.info("deleting department "+id.toString());
        return departmentService.deleteById(id);
    }
}
