package com.zachtib.demoapp.books;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.zachtib.demoapp.DemoApp;
import com.zachtib.demoapp.R;
import com.zachtib.demoapp.books.model.Author;
import com.zachtib.demoapp.books.model.Book;

import java.util.List;

import javax.inject.Inject;

public class BooksActivity extends AppCompatActivity implements IBooksView {
    final private String TAG = "BooksActivity";

    @Inject
    IBooksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ((DemoApp) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showBook(Book book) {
        Log.d(TAG, "Got a single book: " + book.getTitle());
    }

    @Override
    public void showBooks(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Log.d(TAG, books.get(i).getTitle());
        }
    }

    @Override
    public void showAuthors(List<Author> authors) {
        for (int i = 0; i < authors.size(); i++) {
            Log.d(TAG, authors.get(i).getFirstName());
        }
    }
}
