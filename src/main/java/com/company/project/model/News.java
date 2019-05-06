package com.company.project.model;

import sun.nio.cs.ext.Big5;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class News {
    @Id
    @Column(name = "newsID")
    private BigDecimal newsid;

    private String title;

    @Column(name = "editorID")
    private String editorid;

    private String sponsor;

    @Column(name = "registrationStartDate")
    private Date registrationstartdate;

    @Column(name = "registrationEndDate")
    private Date registrationenddate;

    @Column(name = "contestStartDate")
    private Date conteststartdate;

    @Column(name = "contestEndDate")
    private Date contestenddate;

    private String poster;

    private BigDecimal hits;

    private byte[] newsbody;

    /**
     * @return newsID
     */
    public BigDecimal getNewsid() {
        return newsid;
    }

    /**
     * @param newsid
     */
    public void setNewsid(BigDecimal newsid) {
        this.newsid = newsid;
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
     * @return editorID
     */
    public String getEditorid() {
        return editorid;
    }

    /**
     * @param editorid
     */
    public void setEditorid(String editorid) {
        this.editorid = editorid;
    }

    /**
     * @return sponsor
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return registrationStartDate
     */
    public Date getRegistrationstartdate() {
        return registrationstartdate;
    }

    /**
     * @param registrationstartdate
     */
    public void setRegistrationstartdate(Date registrationstartdate) {
        this.registrationstartdate = registrationstartdate;
    }

    /**
     * @return registrationEndDate
     */
    public Date getRegistrationenddate() {
        return registrationenddate;
    }

    /**
     * @param registrationenddate
     */
    public void setRegistrationenddate(Date registrationenddate) {
        this.registrationenddate = registrationenddate;
    }

    /**
     * @return contestStartDate
     */
    public Date getConteststartdate() {
        return conteststartdate;
    }

    /**
     * @param conteststartdate
     */
    public void setConteststartdate(Date conteststartdate) {
        this.conteststartdate = conteststartdate;
    }

    /**
     * @return contestEndDate
     */
    public Date getContestenddate() {
        return contestenddate;
    }

    /**
     * @param contestenddate
     */
    public void setContestenddate(Date contestenddate) {
        this.contestenddate = contestenddate;
    }

    /**
     * @return poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return hits
     */
    public BigDecimal getHits() {
        return hits;
    }

    /**
     * @param hits
     */
    public void setHits(BigDecimal hits) {
        this.hits = hits;
    }

    /**
     * @return newsbody
     */
    public byte[] getNewsbody() {
        return newsbody;
    }

    /**
     * @param newsbody
     */
    public void setNewsbody(byte[] newsbody) {
        this.newsbody = newsbody;
    }
}