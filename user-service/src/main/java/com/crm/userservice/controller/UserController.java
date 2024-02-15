package com.crm.userservice.controller;


import com.crm.userservice.VO.ResponseTemplateVO;
import com.crm.userservice.entity.User;
import com.crm.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO retrieveUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside retrieveUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
