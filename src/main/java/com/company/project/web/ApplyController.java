package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Apply;
import com.company.project.service.ApplyService;
import com.company.project.service.model.MyRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2019/05/25.
*/
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    private final Logger logger = LoggerFactory.getLogger(ApplyController.class);

    //!
    @PostMapping("/add")
    public Result add(@RequestBody Apply apply) {
        apply.setStatus(0);
        applyService.save(apply);
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/delete")
    public Result delete(@RequestBody MyRequestBody body) {
        applyService.deleteById(body.ID);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Apply apply) {
        applyService.update(apply);
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/myList")
    public Result myList(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {
        return ResultGenerator.genSuccessResult(applyService.getMyList(myRequestBody.username));
    }

}
