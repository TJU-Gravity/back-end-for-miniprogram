package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Post {
    @Id
    @Column(name = "postID")
    private BigDecimal postid;

    private String posttype;

    @Column(name = "posterID")
    private String posterid;

    private BigDecimal state;

    @Column(name = "postingTime")
    private Date postingtime;

    private String title;

    private BigDecimal hits;

    @Column(name = "lastPost")
    private Date lastpost;

    @Column(name = "postBody")
    private byte[] postbody;

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
     * @return posttype
     */
    public String getPosttype() {
        return posttype;
    }

    /**
     * @param posttype
     */
    public void setPosttype(String posttype) {
        this.posttype = posttype;
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
     * @return state
     */
    public BigDecimal getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(BigDecimal state) {
        this.state = state;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return hits
     */
    public BigDecimal getHits() {
        return hits;
    }

    /**
     * @param hits
     */
    public void setHits(BigDecimal hits) {
        this.hits = hits;
    }

    /**
     * @return lastPost
     */
    public Date getLastpost() {
        return lastpost;
    }

    /**
     * @param lastpost
     */
    public void setLastpost(Date lastpost) {
        this.lastpost = lastpost;
    }

    /**
     * @return postBody
     */
    public byte[] getPostbody() {
        return postbody;
    }

    /**
     * @param postbody
     */
    public void setPostbody(byte[] postbody) {
        this.postbody = postbody;
    }
}