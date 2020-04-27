package com.company.project.model;

import javax.persistence.*;


@Table(name = "apply")
public class Apply {


    private String applicant;

    private String accepter;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private Integer status;


    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    public String getAccepter() {
        return accepter;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}