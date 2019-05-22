package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public User findByUsername(String username);
    public List<User> findByUsernames(@Param("usernames")List<String> usernames);
    public void addUser(User u);
}