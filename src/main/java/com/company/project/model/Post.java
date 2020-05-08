package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;



import java.sql.Timestamp;
import javax.persistence.*;

public class Post {
    @Id
    @Column(name = "postID")
    private Integer postid;

    private String posttype;

    @Column(name = "posterID")
    private String posterid;

    private Integer state;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "postingTime")
    private Timestamp postingtime;

    private String title;

    private Integer hits;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "lastPost")
    private Timestamp lastpost;

    @Column(name = "postBody")
    private String postbody;

    @Column(name = "tags")
    private String tags;






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
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
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
    public Integer getHits() {
        return hits;
    }

    /**
     * @param hits
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * @return lastPost
     */
    public Timestamp getLastpost() {
        return lastpost;
    }

    /**
     * @param lastpost
     */
    public void setLastpost(Timestamp lastpost) {
        this.lastpost = lastpost;
    }

    /**
     * @return postBody
     */
    public String getPostbody() {
        return postbody;
    }

    public void setPostbody(String postbody) {
        this.postbody = postbody;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}