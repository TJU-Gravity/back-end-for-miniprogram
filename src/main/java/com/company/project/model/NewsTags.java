package com.company.project.model;

import javax.persistence.*;
import java.math.BigDecimal;

public class NewsTags {
    @Id
    @Column(name = "newsID")
    private BigDecimal newsid;


    private String tag;

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