package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.UserTags;
import com.company.project.service.UserTagsService;
import com.company.project.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/04/21.
*/
@RestController
@RequestMapping("/user/tags")
public class UserTagsController {
    @Resource
    private UserTagsService userTagsService;

    //NEW！
    @PostMapping("/ChangeUserTags")
    public Result changeTags(@RequestBody MyRequestBody userTags) {
        userTagsService.changeTags(userTags.tags,userTags.username);
        return ResultGenerator.genSuccessResult();
    }

    //NEW 没写完
    @PostMapping("/findUsersByTags")
    public Result findUsers(@RequestBody MyRequestBody userTags) {

       //here
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/add")
    public Result add(UserTags userTags) {
        userTagsService.save(userTags);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userTagsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserTags userTags) {
        userTagsService.update(userTags);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserTags userTags = userTagsService.findById(id);
        return ResultGenerator.genSuccessResult(userTags);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserTags> list = userTagsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
