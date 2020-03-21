package com.example.testapp.presentation;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.InformingUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class DowntimeActivityPresenter extends MvpPresenter<DowntimeView> {

    private InformingUseCase informingUseCase;
    private Disposable disposable;
    private static final String TAG = "DowntimeActivityPr";

    public DowntimeActivityPresenter(InformingUseCase informingUseCase){
        this.informingUseCase = informingUseCase;
    }

    @Override
    protected void onFirstViewAttach(){
        getReasonsList();
    }

    private void getReasonsList(){
        clear();
        disposable = informingUseCase.getReasons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(reasonDowntimePrints -> getViewState().setAdapter(reasonDowntimePrints),
                        throwable -> Log.d(TAG, throwable.getMessage())
                );
    }

    public void addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName){
        clear();
        disposable = informingUseCase.addDowntime(idForklift,reason,startDowntime,finishDowntime,userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> getViewState().showResult(result),
                        throwable -> Log.d(TAG, throwable.getMessage())
                );


    }



    private void clear(){
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
