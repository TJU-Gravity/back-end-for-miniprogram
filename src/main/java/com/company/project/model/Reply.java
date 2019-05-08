package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "replyID")
    private BigDecimal replyid;

    @Column(name = "postID")
    private BigDecimal postid;

    @Column(name = "posterID")
    private String posterid;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "postingTime")
    private Timestamp postingtime;

    @Column(name = "replyBody")
    private String replybody;


    /**
     * @return replyID
     */
    public BigDecimal getReplyid() {
        return replyid;
    }

    /**
     * @param replyid
     */
    public void setReplyid(BigDecimal replyid) {
        this.replyid = replyid;
    }

    /**
     * @return postID
     */
    public BigDecimal getPostid() {
        return postid;
    }

    /**
     * @param postid
     */
    public void setPostid(BigDecimal postid) {
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