package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.service.impl.TIM;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/")
public class TIMController {
    @Resource
    private TIM tim;

    @PostMapping("/generatedSig")
    public Result genSig(String identifier){
        String Sig=tim.genSig(identifier);
        return ResultGenerator.genSuccessResult(Sig);
    }

    @PostMapping("/addFriend")
    public Result addFriend(String fromAccount, String toAccount, String sourceType){
        return ResultGenerator.genSuccessResult(tim.addFriend(fromAccount,toAccount,sourceType));
    }


    


}
