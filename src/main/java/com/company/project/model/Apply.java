package com.company.project.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "apply")
public class Apply {
    private BigDecimal state;

    private String username;
    @Column(name = "captainID")
    private String captainid;
    @Id
    @Column(name = "teamID")
    private BigDecimal teamid;

    public BigDecimal getTeamid() {
        return teamid;
    }

    public void setTeamid(BigDecimal teamid) {
        this.teamid = teamid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCaptainid(String captainid) {
        this.captainid = captainid;
    }

    public String getCaptainid() {
        return captainid;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }
}