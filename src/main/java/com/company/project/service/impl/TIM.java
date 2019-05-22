package com.company.project.service.impl;

import com.company.project.core.ProjectConstant;
import com.company.project.dao.UserMapper;
import com.company.project.model.Team;
import com.company.project.model.User;
import com.tls.tls_sigature.tls_sigature;
import com.tls.tls_sigature.tls_sigature.GenTLSSignatureResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


@Service
public class TIM {

    String priKeyContent = ProjectConstant.PRIVATE_KEY;
    long sdkAppId= ProjectConstant.SDK_APP_ID;
    String adminIdentifier= ProjectConstant.ADMIN_IDENTIFIER;
    String adminUserSig= ProjectConstant.ADMIN_USERSIG;

    private RestTemplate restTemplate=new RestTemplate();

    @Resource
    private UserMapper guserMapper;

    @Resource
    private TeamServiceImpl teamService;



    /**
     *
     * 登陆鉴权。
     * 访问数据库User表，如果expire_time字段存在，且不超期，直接返回user_sig字段
     * 否则，请求TIM，获取(user_sig，expire_time)，存ho，
     * @param identifier
     * @return
     */
    public String genSig(String identifier){

        User u= guserMapper.findByUsername(identifier);

        //报错信息，用户不存在
        if(u==null){
            return "";
        }

        Date currentDate = new Date(System.currentTimeMillis());

        Date exDate = u.getExpire_time();

        String userSig="";


        boolean hh=exDate.after(currentDate);

        if(exDate==null||exDate.before(currentDate) || exDate.equals(currentDate)){
            GenTLSSignatureResult result = tls_sigature.genSig(sdkAppId, identifier, priKeyContent);
            userSig=result.urlSig;

            //更新数据库
            u.setUser_sig(userSig);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH,6);
            exDate = new Date(c.getTimeInMillis());
            u.setExpire_time(exDate);
            guserMapper.updateUsersig(u);

        }else{
            userSig=u.getUser_sig();
        }
        return  userSig;
    }

    /**
     * 双向加好友。
     * 查找好友关系表，如果存在关系则返回，
     * 否则，TIM加好友
     * @param teamId
     * @return
     */
    public String contactTeamCaptain(String teamId,String openid){
        Team t=teamService.findById(teamId);

        //查找所属队伍关系??

        //如果不所属？
        //加队长
        String toAccount=t.getCaptainid();
        return addFriend(openid,toAccount,"weixin");
    }

    /**
     * 双向加好友。
     * 查找好友关系表，如果存在关系则返回，
     * 否则，TIM加好友
     * @param fromAccount
     * @param toAccount
     * @param sourceType
     * @return TIM RestAPI 请求响应结果
     */
   public String addFriend(String fromAccount, String toAccount, String sourceType){


        //TIM 加好友
        String url="https://console.tim.qq.com/v4/sns/friend_add?sdkappid="+sdkAppId+"&&identifier="+adminIdentifier+"&usersig="+adminUserSig+"&random=99999999&contenttype=json";

        //参数
        Map<String, Object> map0 = new HashMap<>();
        map0.put("To_Account",toAccount);
        map0.put("AddSource","AddSource_Type_"+sourceType);
        ArrayList<Map<String,Object>> item= new ArrayList();
        item.add(map0);
        Map<String, Object> map = new HashMap<>();
        map.put("From_Account", fromAccount);
        map.put("AddFriendItem", item);

        String res = restTemplate.postForObject(url, map,String.class);
        res = res.replace("\"","");


        //数据库添加好友关系？

        return res;
   }

}
