package com.example.testapp.presentation;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void onLoginSuccessfully();
    void showResultLogin(String reason);
}
