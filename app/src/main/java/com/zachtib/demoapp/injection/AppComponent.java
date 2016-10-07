package com.zachtib.demoapp.injection;

import com.zachtib.demoapp.books.BooksView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(BooksView target);
}
