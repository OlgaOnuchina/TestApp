package com.example.testapp.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.domain.InformingUseCase;

@InjectViewState
public class ScanActivityPresenter extends MvpPresenter<ScanView> {
    private InformingUseCase informingUseCase;

    public ScanActivityPresenter(InformingUseCase informingUseCase){
        this.informingUseCase = informingUseCase;
    }

}
