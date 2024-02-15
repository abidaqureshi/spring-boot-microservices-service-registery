package com.crm.userservice.service;


import com.crm.userservice.VO.Department;
import com.crm.userservice.VO.ResponseTemplateVO;
import com.crm.userservice.entity.User;
import com.crm.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return usersRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = usersRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
                ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
