package com.zachtib.demoapp.books;

import com.zachtib.demoapp.mvp.BaseView;

import java.util.List;

public interface IBooksView extends BaseView {
    void showBooks(List<Book> books);
    void showAuthors(List<Author> authors);
}
