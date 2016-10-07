package com.zachtib.demoapp.injection;

import com.zachtib.demoapp.books.BooksActivity;
import com.zachtib.demoapp.books.IBooksView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(BooksActivity target);
}
