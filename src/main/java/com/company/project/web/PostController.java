package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Reply;
import com.company.project.model.Team;
import com.company.project.model.UserTeam;
import com.company.project.service.*;

import com.company.project.service.impl.ReplyServiceImpl;


import com.company.project.web.model.MyRequestBody;
import com.company.project.model.Post;
import com.company.project.web.model.PostDetail;
import com.company.project.web.model.PostResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
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
    @Resource
    private TeamService teamService;
    @Resource
    private UserTeamService userTeamService;
    //update

    @PostMapping("/add")
    public Result add(@RequestBody Post post) {
        post.setPostingtime(new Timestamp(new Date().getTime()));
        post.setLastpost(post.getPostingtime());
        postService.save(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/team/add")
    public Result addWithTeam(@RequestBody Post post) {
        logger.warn(post.team.getTeam_name());
        post.team.setMember_Num(1);
        post.team.setCreate_date(new Date());
        teamService.add(post.team);

        UserTeam userTeam=new UserTeam();
        userTeam.setTeamid(post.team.getTeamid());
        userTeam.setUsername(post.team.getCaptainid());
        userTeamService.save(userTeam);


        post.setPostingtime(new Timestamp(new Date().getTime()));
        post.setLastpost(post.getPostingtime());
        post.setTeamid(post.team.getTeamid());
        postService.save(post);

        postService.addMember(post.team.getTeamid(),1);
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
        postDetail.replies=replyService.getReplys(body.ID);
        postDetail.user=uService.findByUsername(postDetail.post.getPosterid());

        return ResultGenerator.genSuccessResult(postDetail);
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
