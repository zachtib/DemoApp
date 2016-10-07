package com.zachtib.demoapp.books;

public class BooksPresenter implements IBooksPresenter {
    private IBooksView view;

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(IBooksView view) {
        this.view = view;
    }
}
