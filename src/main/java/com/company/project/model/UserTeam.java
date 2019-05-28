package com.company.project.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "user_team")
public class UserTeam {


    private String username;
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
}