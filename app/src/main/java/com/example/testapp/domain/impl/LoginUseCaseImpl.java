package com.example.testapp.domain.impl;

import com.example.testapp.domain.LoginUseCase;
import com.example.testapp.domain.mapper.ResultLoginMapper;
import com.example.testapp.domain.print.ResultLoginPrint;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.LoginRepository;
import com.sample.core.repository.impl.LoginRepositoryImpl;

import io.reactivex.Observable;

public class LoginUseCaseImpl implements LoginUseCase {

    private static LoginUseCaseImpl loginUseCaseImpl;
    private final LoginRepository loginRepository;
    private final ResultLoginMapper resultLoginMapper;

    public LoginUseCaseImpl(String textAccessInit){
        this.loginRepository = LoginRepositoryImpl.instance(textAccessInit);
        this.resultLoginMapper = new ResultLoginMapper();

    }

    public static LoginUseCaseImpl instance(String textAccessInit) {
        if(loginUseCaseImpl == null) {
            loginUseCaseImpl = new LoginUseCaseImpl(textAccessInit);
        }
        return loginUseCaseImpl;
    }

    @Override
    public Observable<ResultLoginPrint> login() {
        return loginRepository.login().map(this::mapResultLogin);
    }

    private ResultLoginPrint mapResultLogin(ResultLogin item){
        return resultLoginMapper.map(item);
    }
}
