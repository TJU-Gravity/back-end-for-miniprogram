package com.company.project.service;
import com.company.project.core.Service;
import com.company.project.model.UserTags;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
public interface UserTagsService extends Service<UserTags> {
    void changeTags(List<String> tags,String username);

}
