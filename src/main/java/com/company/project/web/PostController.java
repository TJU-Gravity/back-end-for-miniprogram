package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Reply;
import com.company.project.service.ReplyService;

import com.company.project.service.UserService;
import com.company.project.service.impl.ReplyServiceImpl;


import com.company.project.web.model.MyRequestBody;
import com.company.project.model.Post;
import com.company.project.web.model.PostDetail;
import com.company.project.web.model.PostResult;
import com.company.project.service.PostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @Resource
    private ReplyService replyService;
    @Resource
    private UserService uService;


    @PostMapping("/add")
    public Result add(@RequestBody Post post) {
        postService.save(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        postService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Post post) {
        postService.update(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody MyRequestBody body) {
        PostDetail postDetail=new PostDetail();
        postDetail.post=postService.findById(BigDecimal.valueOf(body.ID));
        postDetail.replies=replyService.getReplys(body.ID);
        postDetail.user=uService.findByUsername(postDetail.post.getPosterid());

        return ResultGenerator.genSuccessResult(postDetail);
    }


    @PostMapping("/list")
    public Result list(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {
        PageHelper.startPage(myRequestBody.page, myRequestBody.size);
        List<PostResult> list =postService.getList(myRequestBody);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
