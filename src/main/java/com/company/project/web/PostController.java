package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ServiceException;
import com.company.project.service.*;


import com.company.project.service.model.MyRequestBody;
import com.company.project.model.Post;
import com.company.project.service.model.PostDetail;
import com.company.project.service.model.PostResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/post")
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(PostController.class);
    @Resource
    private PostService postService;

    @Resource
    private ReplyService replyService;
    @Resource
    private UserService uService;


    @PostMapping("/add")
    public Result add(@RequestBody Post post) {
        try{
            assert(post.getPosttype().equals("1")||post.getPosttype().equals("2"));
            assert (post.getPostbody()!=null);
            assert(post.getTitle()!=null&&post.getTitle().length()<=50);
        }
        catch (Exception e)
        {
            throw new ServiceException("参数不符合要求");
        }

        post.setPostingtime(new Timestamp(new Date().getTime()));
        post.setLastpost(post.getPostingtime());
        postService.save(post);
        return ResultGenerator.genSuccessResult();

    }


    //new ID
    @PostMapping("/delete")
    public Result delete(@RequestBody MyRequestBody body) {
        postService.deleteById(body.ID);
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
        postDetail.post=postService.findById(body.ID);
        if(postDetail.post !=null) {
            postDetail.replies = replyService.getReplys(body.ID);
            logger.warn(postDetail.post.getPosterid());
            postDetail.user=uService.findByUsername(postDetail.post.getPosterid());
            return ResultGenerator.genSuccessResult(postDetail);
        }
        else{
            return ResultGenerator.genFailResult("帖子不存在");
        }
    }

//new
    @PostMapping("/list")
    public Result list(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {
        PageHelper.startPage(myRequestBody.page, myRequestBody.size);
        List<PostResult> list =postService.getList(myRequestBody);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    //new 传username
    @PostMapping("/myList")
    public Result myList(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {
        PageHelper.startPage(myRequestBody.page, myRequestBody.size);
       //here
        List<PostResult> list =postService.getMyList(myRequestBody);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    //new ID state
    @PostMapping("/changeState")
    public Result changeState(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {
        Post post=postService.findById(myRequestBody.ID);
        post.setState(myRequestBody.state);
        postService.update(post);
        return ResultGenerator.genSuccessResult();
    }
}
