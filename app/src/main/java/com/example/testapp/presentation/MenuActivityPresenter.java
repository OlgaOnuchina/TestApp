package com.example.testapp.presentation;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.InformingUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

@InjectViewState
public class MenuActivityPresenter extends MvpPresenter<MenuView> {

    private InformingUseCase informingUseCase;
    private Disposable disposable;
    private static final String TAG = "MenuActivityPr";

    public MenuActivityPresenter(InformingUseCase informingUseCase){
        this.informingUseCase = informingUseCase;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        clear();
        disposable = informingUseCase.getInfoForklift("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(infoForkliftPrint -> getViewState().setInfo(infoForkliftPrint),
                        throwable -> Log.d(TAG, throwable.getMessage())
                );
    }

    private void clear(){
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
