package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "guser")
public class User {
    @Id
    private Integer id;

    private String username;

    private String nickname;

    private String pwd;

    private String gender;

    private String headshot;

    private String loc;

    @Column(name = "phoneNumber")
    private String phonenumber;

    private String introduction;

    @Column(name = "userPrivileges")
    private Integer userprivileges;

    private String email;

    private Integer status;

    private String tags;

    @Column(name = "unread_apply")
    private Integer unreadApply;

    private String wechat;
    private String qq;
    private String privacy;

    @Transient
    private String code;

    @Transient
    private int relationship;

    @JSONField(format="yyyy-MM-dd")
    private Date expire_time;
    private String user_sig;


    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public void setUser_sig(String user_sig) {
        this.user_sig = user_sig;
    }

    public String getUser_sig() {
        return user_sig;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private String openid;


    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return headshot
     */
    public String getHeadshot() {
        return headshot;
    }

    /**
     * @param headshot
     */
    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    /**
     * @return loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return phoneNumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return userPrivileges
     */
    public Integer getUserprivileges() {
        return userprivileges;
    }

    /**
     * @param userprivileges
     */
    public void setUserprivileges(Integer userprivileges) {
        this.userprivileges = userprivileges;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}