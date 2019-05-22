package com.company.project.service;
import com.company.project.core.Service;
import com.company.project.model.User;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
public interface UserService extends Service<User> {
    User findByUsername(String username);
    void addUser(User u);
    void getOpenId(User u);

    User findByOpenid(String openid);
    void updateUsersig(User u);
}
