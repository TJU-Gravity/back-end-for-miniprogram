package com.company.project.service;
import com.company.project.model.Post;
import com.company.project.core.Service;
import com.company.project.service.model.MyRequestBody;
import com.company.project.service.model.PostResult;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface PostService extends Service<Post> {
    List<PostResult> getList(MyRequestBody myRequestBody);
    List<PostResult> getMyList(MyRequestBody myRequestBody);

}
