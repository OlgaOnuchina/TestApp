package com.example.testapp.domain;

import com.example.testapp.domain.print.ResultLoginPrint;

import io.reactivex.Observable;

public interface LoginUseCase{
    Observable<ResultLoginPrint> login();
}
