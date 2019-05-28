package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Team;
import com.company.project.service.TeamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/05/09.
*/
@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService teamService;

    @PostMapping(value="/add")
    public Result addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
        //userTeamService.addUser(user);
        return ResultGenerator.genSuccessResult("创建成功");
    }

    @PostMapping("/addMember")
    public Result addMember(int team_id) {
        teamService.addMember(team_id);
        //userTeamService.addUser(user);
        return ResultGenerator.genSuccessResult("添加成员team表操作成功");

    }

    @PostMapping("/removeMember")
    public Result removeMember(int team_id) {
        teamService.removeMember(team_id);
        return ResultGenerator.genSuccessResult("删除成员team表操作成功");

    }


    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Team team = teamService.findById(id);
        return ResultGenerator.genSuccessResult(team);
    }



    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        teamService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Team team) {
        teamService.update(team);
        return ResultGenerator.genSuccessResult();
    }



    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Team> list = teamService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
