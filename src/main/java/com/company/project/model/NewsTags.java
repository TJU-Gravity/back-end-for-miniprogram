package com.company.project.model;

import javax.persistence.*;

public class NewsTags {
    @Id
    @Column(name = "newsID")
    private Integer newsid;


    private String tag;

    /**
     * @return newsID
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * @param newsid
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}