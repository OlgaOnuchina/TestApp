package com.example.testapp.domain.impl;

import android.util.Log;

import com.example.testapp.domain.InformingUseCase;
import com.example.testapp.domain.mapper.InfoForkliftMapper;
import com.example.testapp.domain.mapper.ReasonDowntimeAdapterMapper;
import com.example.testapp.domain.mapper.ReasonDowntimeMapper;
import com.example.testapp.domain.mapper.ResultLoginMapper;
import com.example.testapp.domain.print.InfoForkliftPrint;
import com.example.testapp.domain.print.ReasonDowntimePrint;
import com.example.testapp.domain.print.ResultLoginPrint;
import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.InformingRepository;
import com.sample.core.repository.impl.InformingRepositoryImpl;
import com.sample.core.repository.impl.MockInformingRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class InformingUseCaseImpl implements InformingUseCase {

    private static InformingUseCaseImpl informingUseCaseImpl;
    private final InformingRepository informingRepository;
    private final ResultLoginMapper resultLoginMapper;
    private final InfoForkliftMapper infoForkliftMapper;
    private final ReasonDowntimeMapper reasonDowntimeMapper;
    private final ReasonDowntimeAdapterMapper reasonDowntimeAdapterMapper;

    public InformingUseCaseImpl(String textAccess) {
        this.informingRepository = InformingRepositoryImpl.instance(textAccess);
        //this.informingRepository = MockInformingRepositoryImpl.instance(textAccess);
        this.resultLoginMapper = new ResultLoginMapper();
        this.infoForkliftMapper = new InfoForkliftMapper();
        this.reasonDowntimeMapper = new ReasonDowntimeMapper();
        this.reasonDowntimeAdapterMapper = new ReasonDowntimeAdapterMapper();
    }

    public static InformingUseCaseImpl instance(String textAccess) {
        if(informingUseCaseImpl == null) {
            informingUseCaseImpl = new InformingUseCaseImpl(textAccess);
        }
        return informingUseCaseImpl;
    }

    @Override
    public Observable<ResultLoginPrint> login(String userName, String password) {
        return informingRepository.login(userName, password).map(this::mapResultLogin);
    }

    private ResultLoginPrint mapResultLogin(ResultLogin item){
        return resultLoginMapper.map(item);
    }

    @Override
    public Observable<InfoForkliftPrint> getInfoForklift(String idForklift) {
        return informingRepository.getInfoForklift(idForklift).map(this::mapInfoForklift);
    }

    private InfoForkliftPrint mapInfoForklift(InfoForklift infoForklift){
        return infoForkliftMapper.map(infoForklift);
    }

    @Override
    public Observable<List<String>> getReasons() {
        return informingRepository.getReasons()
                .map(this::mapReasonDowntime)
                .map(this::mapReasonAdapter);
    }

    private List<ReasonDowntimePrint> mapReasonDowntime(List<ReasonDowntime> list){
        List<ReasonDowntimePrint> listPrint = new ArrayList<>();
        for(ReasonDowntime element : list){
            ReasonDowntimePrint elementPrint = reasonDowntimeMapper.map(element);
            listPrint.add(elementPrint);
        }
        return listPrint;
    }

    private List<String> mapReasonAdapter(List<ReasonDowntimePrint> list){
        List<String> listSt = new ArrayList<>();
        for(ReasonDowntimePrint element : list){
            String elementSt = reasonDowntimeAdapterMapper.map(element);
            listSt.add(elementSt);
        }
        return listSt;
    }


    @Override
    public Observable<Boolean> addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName) {
        return informingRepository.addDowntime(idForklift, reason, startDowntime, finishDowntime, userName);
    }


}
