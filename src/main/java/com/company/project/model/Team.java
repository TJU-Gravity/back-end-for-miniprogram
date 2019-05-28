package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Team {
    @Id
    @Column(name = "teamID")
    private String teamid;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "captainID")
    private String captainid;

    @Column(name = "member_num")
    private int member_num;

    @Column(name = "create_date")
    private Date create_date;

    private String avatar;

    private String introduction;

    private int member_left;
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
    public String getTeam_name() {
        return team_name;
    }

    /**
     * @param team_name
     */
    public void setTeam_name(String team_name) {
        this.team_name = team_name;
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
    public int getMember_Num() {
        return member_num;
    }

    /**
     * @param member_num
     */
    public void setMember_Num(int member_num) {
        this.member_num = member_num;
    }

    /**
     * @return create_date
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * @param create_date
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
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
     * @param member_left
     */
    public void setMember_left(int member_left) {
        this.member_left = member_left;
    }


    /**
     * @return member_left
     */
    public int getMember_left() {
        return member_left;
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