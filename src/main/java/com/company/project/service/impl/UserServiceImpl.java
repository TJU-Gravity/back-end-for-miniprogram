package com.company.project.service.impl;

import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper guserMapper;

    public User findByUsername(String username)
    {
        return guserMapper.findByUsername(username);
    }
    public void addUser(User u)
    {
        guserMapper.addUser(u);
    }

}
