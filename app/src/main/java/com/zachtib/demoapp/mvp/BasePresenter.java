package com.zachtib.demoapp.mvp;

public interface BasePresenter<T extends BaseView> {
    void onResume();
    void onPause();
    void attachView(T view);
}
