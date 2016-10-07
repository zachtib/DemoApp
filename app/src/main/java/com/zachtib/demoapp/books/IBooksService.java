package com.zachtib.demoapp.books;

import com.zachtib.demoapp.books.model.Author;
import com.zachtib.demoapp.books.model.Book;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface IBooksService {
    @GET("/books")
    Observable<List<Book>> getBooks();

    @GET("/authors/")
    Observable<List<Author>> getAuthors();
}
