package com.zachtib.demoapp.books;

import com.zachtib.demoapp.books.model.Author;
import com.zachtib.demoapp.books.model.Book;
import com.zachtib.demoapp.mvp.BaseView;

import java.util.List;

public interface IBooksView extends BaseView {
    void showBook(Book book);
    void showBooks(List<Book> books);
    void showAuthors(List<Author> authors);
}
