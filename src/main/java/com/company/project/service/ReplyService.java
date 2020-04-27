package com.company.project.service;
import com.company.project.model.Reply;
import com.company.project.core.Service;
import com.company.project.service.model.ReplyResult;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface ReplyService extends Service<Reply> {
    List<ReplyResult> getReplys(Integer postid);


}
