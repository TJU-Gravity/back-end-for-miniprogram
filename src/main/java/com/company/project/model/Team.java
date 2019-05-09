package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Team {
    @Id
    @Column(name = "teamID")
    private String teamid;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "captainID")
    private String captainid;

    @Column(name = "member_num")
    private String memberNum;

    @Column(name = "create_date")
    private Date createDate;

    private String avatar;

    private String introduction;

    /**
     * 以 | 分隔 
     */
    private String label;

    /**
     * @return teamID
     */
    public String getTeamid() {
        return teamid;
    }

    /**
     * @param teamid
     */
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    /**
     * @return team_name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return captainID
     */
    public String getCaptainid() {
        return captainid;
    }

    /**
     * @param captainid
     */
    public void setCaptainid(String captainid) {
        this.captainid = captainid;
    }

    /**
     * @return member_num
     */
    public String getMemberNum() {
        return memberNum;
    }

    /**
     * @param memberNum
     */
    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
     * 获取以 | 分隔 
     *
     * @return label - 以 | 分隔 
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置以 | 分隔 
     *
     * @param label 以 | 分隔 
     */
    public void setLabel(String label) {
        this.label = label;
    }
}