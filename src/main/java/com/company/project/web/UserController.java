package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
@Resource
private UserTagsService userTagsService;
    //NEW！
    @PostMapping("/loginWeChat")
    public Result loginWeChat(@RequestBody User u) {
        userService.getOpenId(u);
        User user = userService.findByUsername(u.getUsername());
        if (user!=null)
            return ResultGenerator.genSuccessResult(user);
        else {
            userService.addUser(u);
            return ResultGenerator.genSuccessResult(u);
        }

    }

    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update( @RequestBody User user) {

        userService.update(user);
        user=userService.findByUsername(user.getUsername());

        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody MyRequestBody myRequestBody) {
        User user = userService.findByUsername(myRequestBody.username);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
