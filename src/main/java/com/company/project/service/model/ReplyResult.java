package com.company.project.service.model;

import com.alibaba.fastjson.annotation.JSONField;


import java.sql.Timestamp;

public class ReplyResult {
    public Integer replyid;

    public Integer postid;

    public String posterid;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Timestamp postingtime;


    public String replybody;


    public String nickname;

    public String headshot;

    public Integer quote;

    public ReplyResult quotebody;

}
