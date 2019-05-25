package com.company.project.model;

import javax.persistence.*;

@Table(name = "user_team")
public class UserTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @Column(name = "teamID")
    private Integer teamid;

    private String nickname;

    private String headshot;

    @Column(name = "phoneNumber")
    private String phonenumber;

    @Column(name = "team_name")
    private String team_name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return teamID
     */
    public Integer getTeamid() {
        return teamid;
    }

    /**
     * @param teamid
     */
    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
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
}