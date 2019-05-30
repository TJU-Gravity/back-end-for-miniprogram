package com.company.project.service;
import com.company.project.model.Post;
import com.company.project.core.Service;
import com.company.project.web.model.MyRequestBody;
import com.company.project.web.model.PostDetail;
import com.company.project.web.model.PostResult;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface PostService extends Service<Post> {
    List<PostResult> getList(MyRequestBody myRequestBody);
    List<PostResult> getMyList(MyRequestBody myRequestBody);
    boolean addMember(BigDecimal teamID,int member);


}
