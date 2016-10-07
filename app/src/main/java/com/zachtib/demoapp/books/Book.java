package com.zachtib.demoapp.books;

import com.zachtib.demoapp.mvp.BaseModel;

import java.util.Date;


public class Book implements BaseModel {
    private String title;
    private Author author;
    private Date pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
