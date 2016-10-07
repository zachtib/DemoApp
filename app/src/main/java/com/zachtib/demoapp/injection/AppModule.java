package com.zachtib.demoapp.injection;

import android.app.Application;

import com.zachtib.demoapp.books.BooksPresenter;
import com.zachtib.demoapp.books.IBooksPresenter;
import com.zachtib.demoapp.books.IBooksService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    IBooksPresenter providesBooksPresenter(IBooksService service) {
        return new BooksPresenter(service);
    }
}
