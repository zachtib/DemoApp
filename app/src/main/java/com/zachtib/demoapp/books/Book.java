package com.zachtib.demoapp.books;

import com.zachtib.demoapp.mvp.BaseModel;

import java.util.Date;


public class Book implements BaseModel {
    private String title;
    private Author author;
    private Date pubDate;
}
