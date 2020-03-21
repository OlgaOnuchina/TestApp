package com.example.testapp.domain;

import com.example.testapp.domain.print.InfoForkliftPrint;
import com.example.testapp.domain.print.LastDowntimePrint;
import com.example.testapp.domain.print.ResultLoginPrint;

import java.util.List;

import io.reactivex.Observable;

public interface InformingUseCase {
    Observable<ResultLoginPrint> login(String userName, String password);
    Observable<InfoForkliftPrint> getInfoForklift(String idForklift);
    Observable<List<String>> getReasons();
    Observable<Boolean> addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName);
}
