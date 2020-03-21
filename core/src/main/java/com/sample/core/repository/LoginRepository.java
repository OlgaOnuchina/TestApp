package com.sample.core.repository;

import com.sample.core.dto.ResultLogin;

import io.reactivex.Observable;

public interface LoginRepository {
    Observable<ResultLogin> login();
}
