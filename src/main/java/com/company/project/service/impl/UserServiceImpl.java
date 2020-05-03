package com.company.project.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;

import com.company.project.service.model.AuthObject;
import com.company.project.service.model.WxMappingJackson2HttpMessageConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
        User user= guserMapper.findByUsername(username);
        if(user!=null)
        {
            //可能要做标签处理
        }

        return user;
    }


    @Override
    public void deleteByUsername (String username) {
        guserMapper.deleteByPrimaryKey(username);
    }

    public void addUser(User u)
    {
        guserMapper.addUser(u);
    }


    @Override
    public void getOpenId(User u) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        ResponseEntity<AuthObject> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid="+"wxd1e48ab0818b69b3"+"&secret="+"f077c43e676923d47e258127e84357a9"+"&js_code="+u.getCode()+"&grant_type=authorization_code", AuthObject.class);
        if(responseEntity.getBody().errcode==0)
        {
            u.setUsername(responseEntity.getBody().openid);

        }
        else {
            throw new ServiceException(responseEntity.getBody().errmsg);

        }
    }

    public User findByOpenid(String openid)
    {

        return null;

    }

    public void updateUsersig(User u){ guserMapper.updateUsersig(u);}
}
