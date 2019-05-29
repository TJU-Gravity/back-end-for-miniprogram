package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ServiceException;
import com.company.project.model.Apply;
import com.company.project.model.Team;
import com.company.project.model.UserTeam;
import com.company.project.service.ApplyService;
import com.company.project.service.PostService;
import com.company.project.service.TeamService;
import com.company.project.service.UserTeamService;
import com.company.project.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2019/05/25.
*/
@RestController
@RequestMapping("/user/team")
public class UserTeamController {
    @Resource
    private UserTeamService userTeamService;
    @Resource
    private TeamService teamService;
    @Resource
    private PostService postService;
    @Resource
    private ApplyService applyService;

    //!
    @PostMapping("/add")
    public Result add(@RequestBody UserTeam userTeam) {
        userTeamService.save(userTeam);
        teamService.addMember(userTeam.getTeamid());

        //招募帖人数
        postService.addMember(userTeam.getTeamid(),1);

        //申请记录
        try {
            Team team = teamService.findById(userTeam.getTeamid());
            List<String> usernames=new ArrayList<>();
            usernames.add(team.getCaptainid());
            usernames.add(userTeam.getUsername());
            applyService.delete(usernames);

        }
        catch (Exception e)
        {
            throw new ServiceException(e.toString());
        }

        return ResultGenerator.genSuccessResult();
    }

    //!
    @PostMapping("/delete")
    public Result delete(@RequestBody UserTeam userTeam) {

        userTeamService.removeUserFromTeam(userTeam);
        teamService.removeMember(userTeam.getTeamid());

        postService.addMember(userTeam.getTeamid(),-1);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserTeam userTeam) {
        userTeamService.update(userTeam);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserTeam userTeam = userTeamService.findById(id);
        return ResultGenerator.genSuccessResult(userTeam);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserTeam> list = userTeamService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
