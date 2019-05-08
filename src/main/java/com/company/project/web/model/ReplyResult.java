package com.company.project.web.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ReplyResult {
    public BigDecimal replyid;

    public BigDecimal postid;

    public String posterid;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Timestamp postingtime;


    public String replybody;


    public String nickname;

    public String headshot;

}
