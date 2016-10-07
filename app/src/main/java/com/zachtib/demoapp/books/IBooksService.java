package com.zachtib.demoapp.books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBooksService {
    @GET("/books")
    Call<List<Book>> getBooks();

    @GET("/authors/")
    Call<List<Author>> getAuthors();
}
