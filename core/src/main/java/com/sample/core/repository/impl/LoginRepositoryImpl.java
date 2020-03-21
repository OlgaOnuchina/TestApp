package com.sample.core.repository.impl;

import android.util.Log;

import com.sample.core.Login;
import com.sample.core.LoginService;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.LoginRepository;

import io.reactivex.Observable;

public class LoginRepositoryImpl implements LoginRepository {

    private static LoginRepositoryImpl loginRepository;
    private LoginService loginService;

    private LoginRepositoryImpl(String textAccessInit) {
        loginService = Login.instance(textAccessInit).getLoginService();
    }

    public static LoginRepository instance(String textAccess) {
        if(loginRepository == null) {
            loginRepository = new LoginRepositoryImpl(textAccess);
        }
        return loginRepository;
    }

    @Override
    public Observable<ResultLogin> login() {
        return loginService.login()
                .doOnNext(data -> Log.d("myLogs", " downtimeService.login "+String.valueOf(data)) )
                .doOnComplete(() -> Log.d("myLogs"," downtimeService.login "+"OK"))
                .doOnError(t -> Log.d("myLogs", " downtimeService.login "+t.getMessage()));
    }
}
