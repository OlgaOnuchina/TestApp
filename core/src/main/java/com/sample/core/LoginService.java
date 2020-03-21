package com.sample.core;

import com.sample.core.dto.ResultLogin;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LoginService {

    @GET(value = "/test")
    public Observable<ResultLogin> login();

}
