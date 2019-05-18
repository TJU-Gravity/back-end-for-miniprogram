package com.company.project.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.dao.UserMapper;
import com.company.project.dao.UserTagsMapper;
import com.company.project.model.User;
import com.company.project.model.UserTags;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private UserTagsMapper userTagsMapper;

    public User findByUsername(String username)
    {
        User user= guserMapper.findByUsername(username);
        if(user!=null)
        {
            List<UserTags> userTags=userTagsMapper.findAllTags(username);
            List<String> tags=new ArrayList<>();
            for(UserTags userTag:userTags)
            {
                tags.add(userTag.getTag());
            }
            user.setTags(tags);

        }

        return user;
    }
    public void addUser(User u)
    {
        guserMapper.addUser(u);
    }

    @Override
    public void getOpenId(User u) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        ResponseEntity<AuthObject> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid="+"wxd1e48ab0818b69b3"+"&secret="+"8e92ab857c70a02011228414ba61d3b0"+"&js_code="+u.getCode()+"&grant_type=authorization_code", AuthObject.class);
        if(responseEntity.getBody().errcode==0)
        {
            u.setUsername(responseEntity.getBody().openid);

        }
        else {
            throw new ServiceException(responseEntity.getBody().errmsg);

        }
    }

}
