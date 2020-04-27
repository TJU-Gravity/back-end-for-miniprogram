package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.sql.Timestamp;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "replyID")
    private Integer replyid;

    @Column(name = "postID")
    private Integer postid;

    @Column(name = "posterID")
    private String posterid;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "postingTime")
    private Timestamp postingtime;

    @Column(name = "replyBody")
    private String replybody;

    @Column(name = "quote")
    private Integer quote;


    /**
     * @return replyID
     */
    public Integer getReplyid() {
        return replyid;
    }

    /**
     * @param replyid
     */
    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    /**
     * @return postID
     */
    public Integer getPostid() {
        return postid;
    }

    /**
     * @param postid
     */
    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    /**
     * @return posterID
     */
    public String getPosterid() {
        return posterid;
    }

    /**
     * @param posterid
     */
    public void setPosterid(String posterid) {
        this.posterid = posterid;
    }

    /**
     * @return postingTime
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    public Timestamp getPostingtime() {
        return postingtime;
    }

    /**
     * @param postingtime
     */
    public void setPostingtime(Timestamp postingtime) {
        this.postingtime = postingtime;
    }

    /**
     * @return replyBody
     */
    public String getReplybody() {
        return replybody;
    }

    public void setReplybody(String replybody) {
        this.replybody = replybody;
    }
}