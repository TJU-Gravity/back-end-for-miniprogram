package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;

public interface UserMapper extends Mapper<User> {
    public User findByUsername(String username);
    public void addUser(User u);

    public User findByOpenid(String openid);
    public void updateUsersig(User u);
}