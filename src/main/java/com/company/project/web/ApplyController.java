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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/05/25.
*/
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    //!
    @PostMapping("/add")
    public Result add(@RequestBody Apply apply) {
        applyService.save(apply);
        return ResultGenerator.genSuccessResult();
    }



    @PostMapping("/update")
    public Result update(@RequestBody Apply apply) {
        applyService.update(apply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/check")
    public Result detail(@RequestBody List<String> usernames) {
        return ResultGenerator.genSuccessResult(applyService.check(usernames));
    }


}
