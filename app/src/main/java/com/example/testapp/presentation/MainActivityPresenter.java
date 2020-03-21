package com.example.testapp.presentation;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.InformingUseCase;
import com.example.testapp.domain.print.ResultLoginPrint;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainView> {

    private InformingUseCase informingUseCase;
    private Disposable disposable;
    private static final String TAG = "MainActivityPr";


    public MainActivityPresenter(InformingUseCase informingUseCase){
        this.informingUseCase = informingUseCase;
    }


    private void clear(){
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public void onLogin(String userName, String password) {
        clear();

        disposable = informingUseCase.login(userName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::resultLogin,
                    throwable -> Log.d(TAG, throwable.getMessage())
                );
    }

    private void resultLogin(ResultLoginPrint resultLoginPrint){

        if (resultLoginPrint.getTextResult().equals("Worked")) {
            getViewState().onLoginSuccessfully();
        }
        else getViewState().showResultLogin(resultLoginPrint.getReason());
    }

}
