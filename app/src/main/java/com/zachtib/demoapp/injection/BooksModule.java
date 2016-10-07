package com.zachtib.demoapp.injection;

import com.zachtib.demoapp.books.BooksPresenter;
import com.zachtib.demoapp.books.IBooksPresenter;
import com.zachtib.demoapp.books.IBooksService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class BooksModule {

    @Provides
    @Singleton
    IBooksService provideBooksService(Retrofit retrofit) {
        return retrofit.create(IBooksService.class);
    }

    @Provides
    IBooksPresenter providesBooksPresenter(IBooksService service) {
        return new BooksPresenter(service);
    }
}
