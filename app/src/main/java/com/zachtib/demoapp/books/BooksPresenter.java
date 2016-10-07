package com.zachtib.demoapp.books;

import android.util.Log;

import com.zachtib.demoapp.books.model.Author;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksPresenter implements IBooksPresenter {
    private final String TAG = "BooksPresenter";

    private IBooksView view;
    private IBooksService service;

    public BooksPresenter(IBooksService service) {
        this.service = service;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(IBooksView view) {
        this.view = view;
        getBooks();
    }

    private void getBooks() {
        service.getAuthors().enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                view.showAuthors(response.body());
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }
}
