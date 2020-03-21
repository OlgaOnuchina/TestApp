package com.sample.core;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login {

    private static String BASE_URL;
    private static Retrofit apiRetrofit;
    private static Login login;
    private static LoginService loginService;

    public static Login instance(String textAccessInit){
        if (login == null){
            BASE_URL = "http://админ запретил публиковать/";
            Log.d("myLogs", "Login BASE_URL: "+BASE_URL);
            login = new Login();
        }
        return login;
    }

    private Login(){
        try {
            apiRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            loginService = apiRetrofit.create(LoginService.class);
        } catch (Exception e) {
            Log.d("myLogs", "Login apiRetrofit create "+e.getMessage());
        }
    }

    public LoginService getLoginService(){
        return loginService;
    }




}



