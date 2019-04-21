package com.company.project.model;

import javax.persistence.*;

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
    private Integer userprivileges;

    private String email;

    private Integer status;

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
}