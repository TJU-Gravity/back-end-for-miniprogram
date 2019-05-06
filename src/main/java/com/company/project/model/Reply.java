package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "replyID")
    private BigDecimal replyid;

    @Column(name = "postID")
    private BigDecimal postid;

    @Column(name = "posterID")
    private String posterid;

    @Column(name = "postingTime")
    private Date postingtime;

    @Column(name = "replyBody")
    private byte[] replybody;

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