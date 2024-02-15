package com.crm.departmentservice.service;

import com.crm.departmentservice.entity.Department;
import com.crm.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside of saveDepartment method of Department service");
        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long departmentId) {
         log.info("Inside of findDepartmentById method of Department service");
         return departmentRepository.findDepartmentById(departmentId);
    }
}
