package com.company.project.web.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PostResult {

        public BigDecimal postid;


        public String posttype;


        public String posterid;


        public BigDecimal teamid;

        public String headshot;

        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        public Timestamp postingtime;

        public String title;


        public BigDecimal hits;

        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        public Timestamp lastpost;


        public String postbody;


        public String nickname;


}
