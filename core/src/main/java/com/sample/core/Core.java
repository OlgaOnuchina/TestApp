package com.sample.core;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Core {

    private static String BASE_URL;
    private static Retrofit apiRetrofit;
    private static Core core;
    private static DowntimeService downtimeService;

    public static Core instance(String textAccess) {
        if(core == null) {
            BASE_URL = "http://админ запретил публиковать/";
            Log.d("myLogs", "Core BASE_URL: "+BASE_URL);
            core = new Core();
        }
        return core;
    }

    private Core(){
        try {
            apiRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            downtimeService = apiRetrofit.create(DowntimeService.class);
        } catch (Exception e) {
            Log.d("myLogs", "Core apiRetrofit create "+e.getMessage());
        }
    }

    public DowntimeService getDowntimeService(){
        return downtimeService;
    }
}
