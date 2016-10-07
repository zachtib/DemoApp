package com.zachtib.demoapp.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zachtib.demoapp.DemoApp;

import javax.inject.Inject;

public class BooksView extends AppCompatActivity implements IBooksView {
    @Inject
    IBooksPresenter presenter;

    public BooksView() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApp) getApplication()).getAppComponent().inject(this);
    }
}