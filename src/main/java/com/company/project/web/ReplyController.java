package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Post;
import com.company.project.model.Reply;
import com.company.project.service.PostService;
import com.company.project.service.ReplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2019/04/21.
*/
@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;
    @Resource
    private PostService postService;

    //update
    @PostMapping("/add")
    public Result add(@RequestBody Reply reply) {
        reply.setPostingtime(new Timestamp(new Date().getTime()));
        replyService.save(reply);
        Post post=postService.findById(reply.getPostid());
        post.setLastpost(reply.getPostingtime());
        postService.update(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        replyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Reply reply) {
        replyService.update(reply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Reply reply = replyService.findById(new BigDecimal(id));
        return ResultGenerator.genSuccessResult(reply);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Reply> list = replyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
