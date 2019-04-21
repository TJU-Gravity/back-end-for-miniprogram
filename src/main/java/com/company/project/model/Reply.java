package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "replyID")
    private Integer replyid;

    @Column(name = "postID")
    private Integer postid;

    @Column(name = "posterID")
    private String posterid;

    @Column(name = "postingTime")
    private Date postingtime;

    @Column(name = "replyBody")
    private byte[] replybody;

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
    public Date getPostingtime() {
        return postingtime;
    }

    /**
     * @param postingtime
     */
    public void setPostingtime(Date postingtime) {
        this.postingtime = postingtime;
    }

    /**
     * @return replyBody
     */
    public byte[] getReplybody() {
        return replybody;
    }

    /**
     * @param replybody
     */
    public void setReplybody(byte[] replybody) {
        this.replybody = replybody;
    }
}