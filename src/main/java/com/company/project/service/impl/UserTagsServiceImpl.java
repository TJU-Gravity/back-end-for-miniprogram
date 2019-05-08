package com.company.project.service.impl;

import com.company.project.dao.UserMapper;
import com.company.project.dao.UserTagsMapper;
import com.company.project.model.User;
import com.company.project.model.UserTags;
import com.company.project.service.UserTagsService;
import com.company.project.core.AbstractService;
import com.company.project.service.model.CountTag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class UserTagsServiceImpl extends AbstractService<UserTags> implements UserTagsService {
    @Resource
    private UserTagsMapper usertagsMapper;
    @Resource
    private UserMapper userMapper;
    public void changeTags(List<String> tags, String username)
    {
        List<UserTags> userTags=usertagsMapper.findAllTags(username);
        List<UserTags> oldTags=new ArrayList<>();

        for(UserTags userTag: userTags) {
            if(!tags.contains(userTag.getTag()))
            {
                oldTags.add(userTag);
            }
            else
            {
                tags.remove(tags.indexOf(userTag.getTag()));
            }
        }

        List<UserTags> newTags=new ArrayList<>();
        for (String tag:tags)
        {
            UserTags newTag=new UserTags();
            newTag.setTag(tag);
            newTag.setUsername(username);
            newTags.add(newTag);
        }
        for (UserTags userTag:oldTags)
            usertagsMapper.delete(userTag);

        for (UserTags userTag:newTags)
            this.save(userTag);



    }

    @Override
    public List<User> findUsersByTags(List<String> tags) {

        List<CountTag> countTags=usertagsMapper.findUsersByTags(tags);
        StringBuffer usernames=new StringBuffer();
        usernames.append("(");
        for(CountTag c :countTags)
        {
            if(c.count==tags.size())
            {
                usernames.append(c.username);
                usernames.append(",");
            }
        }
        usernames.deleteCharAt(usernames.length()-1);
        usernames.append(")");

        return  userMapper.selectByIds(usernames.toString());
    }

}
