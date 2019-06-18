package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Apply;
import com.company.project.model.UserTeam;
import com.company.project.service.ApplyService;
import com.company.project.service.PostService;
import com.company.project.service.TeamService;
import com.company.project.service.UserTeamService;
import com.company.project.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2019/05/25.
*/
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;
    @Resource
    private TeamService teamService;
    @Resource
    private UserTeamService userTeamService;
    private final Logger logger = LoggerFactory.getLogger(ApplyController.class);

    //!
    @PostMapping("/add")
    public Result add(@RequestBody Apply apply) {

        logger.warn(new Integer(apply.getType()).toString());
        if(userTeamService.check(apply.getTeamid(),apply.getUsername())==null) {
            List<String> usernames = new ArrayList<>();

            usernames.add(apply.getUsername());
            usernames.add(apply.getCaptainid());

            Apply hasApply = applyService.check(usernames);
            if (hasApply != null)
                return ResultGenerator.genFailResult("双方有申请正在进行中");
            applyService.save(apply);
            return ResultGenerator.genSuccessResult();
        }
        else
            return ResultGenerator.genFailResult("已经在队伍中");
    }


    @PostMapping("/delete")
    public Result delete(@RequestBody List<String> usernames) {

        applyService.delete(usernames);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Apply apply) {
        applyService.update(apply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/check")
    public Result detail(@RequestBody List<String> usernames) {
        Apply apply=applyService.check(usernames);
        if(apply!=null)
        {
            apply.setTeamname(teamService.findById(apply.getTeamid()).getTeam_name());
        }
        return ResultGenerator.genSuccessResult(apply);
    }


}
