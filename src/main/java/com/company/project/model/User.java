package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Table(name = "guser")
public class User {
    @Id
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
    private BigDecimal userprivileges;

    private String email;

    private BigDecimal status;


    @JSONField(format="yyyy-MM-dd")
    private Date expire_time;
    private String user_sig;

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
    public BigDecimal getUserprivileges() {
        return userprivileges;
    }

    /**
     * @param userprivileges
     */
    public void setUserprivileges(BigDecimal userprivileges) {
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
    public BigDecimal getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(BigDecimal status) {
        this.status = status;
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


}