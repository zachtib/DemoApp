package com.zachtib.demoapp.books;

import android.util.Log;

import com.zachtib.demoapp.books.model.Author;
import com.zachtib.demoapp.books.model.Book;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class BooksPresenter implements IBooksPresenter {
    private final String TAG = "BooksPresenter";

    private IBooksView view;
    private IBooksService service;

    private CompositeSubscription subscription;

    public BooksPresenter(IBooksService service) {
        this.service = service;
    }

    @Override
    public void onResume() {
        subscription = new CompositeSubscription();
        getAuthors();
        getBooks();
        getSingleBook(1);
    }

    @Override
    public void onPause() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void attachView(IBooksView view) {
        this.view = view;
    }

    private void getAuthors() {
        subscription.add(
            service.getAuthors()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<Author>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                           Log.e(TAG, "Error getting authors", e);
                        }

                        @Override
                        public void onNext(List<Author> authors) {
                            view.showAuthors(authors);
                        }
                    }));
    }

    private void getBooks() {
        subscription.add(
            service.getBooks()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<Book>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "Error getting books", e);
                        }

                        @Override
                        public void onNext(List<Book> books) {
                            view.showBooks(books);
                        }
                    }));
    }

    private void getSingleBook(int id) {
        subscription.add(
                service.getBook(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Book>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "Error getting book", e);
                        }

                        @Override
                        public void onNext(Book book) {
                            view.showBook(book);
                        }
                    })
        );
    }
}
