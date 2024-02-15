package com.crm.departmentservice.controller;


import com.crm.departmentservice.entity.Department;
import com.crm.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("save department method Department controller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("inside find Department Method Department Controller");
        return departmentService.findDepartmentById(departmentId);
    }

}
