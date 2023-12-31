package com.example.crudOperation.helloSpring.model;

import javax.persistence.*;
import java.io.Serializable;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "UrlDataset")
public class URLs implements Serializable
{
    //Defining book id as primary key
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long urlId;

    @Column
    private String shortenedURL;

    @Column
    private String longURL;

    public URLs() {
    }

    public URLs(String shortURL, String longURL){
        this.shortenedURL = shortURL;
        this.longURL = longURL;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getShortenedURL() {
        return shortenedURL;
    }

    public void setShortenedURL(String shortenedURL) {
        this.shortenedURL = shortenedURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}