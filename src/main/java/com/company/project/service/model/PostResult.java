package com.company.project.service.model;

import com.alibaba.fastjson.annotation.JSONField;


import java.sql.Timestamp;

public class PostResult {

        public Integer postid;


        public String posttype;


        public String posterid;



        public String headshot;
        public Integer state;

        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        public Timestamp postingtime;

        public String title;


        public Integer hits;

        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        public Timestamp lastpost;


        public String postbody;


        public String nickname;



}
