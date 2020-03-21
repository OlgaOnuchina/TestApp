package com.sample.core.repository.impl;

import android.util.Log;

import com.sample.core.Core;
import com.sample.core.DowntimeService;
import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.InformingRepository;

import java.util.List;

import io.reactivex.Observable;

public class InformingRepositoryImpl implements InformingRepository {

    private static InformingRepositoryImpl InformingRepository;
    private DowntimeService downtimeService;
    private static String textAccessInit;

    private InformingRepositoryImpl(String textAccess) {
        textAccessInit = textAccess;
        downtimeService = Core.instance(textAccess).getDowntimeService();
    }

    public static InformingRepository instance(String textAccess) {
        if(InformingRepository == null) {
            InformingRepository = new InformingRepositoryImpl(textAccess);
        }
        return InformingRepository;
    }

    @Override
    public Observable<ResultLogin> login(String userName, String password) {
        Log.d("myLogs", "InformingRepositoryImpl textAccessInit: "+textAccessInit);
        return downtimeService.login(userName, password)
                .doOnNext(data -> Log.d("myLogs", " downtimeService.login "+String.valueOf(data)) )
                .doOnComplete(() -> Log.d("myLogs"," downtimeService.login "+"OK"))
                .doOnError(t -> Log.d("myLogs", " downtimeService.login "+t.getMessage()));
    }

    @Override
    public Observable<InfoForklift> getInfoForklift(String idForklift) {
        return downtimeService.getInfoForklift(idForklift)
                .doOnNext(data -> Log.d("myLogs", " downtimeService.getInfoForklift "+String.valueOf(data)) )
                .doOnComplete(() -> Log.d("myLogs"," downtimeService.getInfoForklift "+"OK"))
                .doOnError(t -> Log.d("myLogs", " downtimeService.getInfoForklift "+t.getMessage()));
    }

    @Override
    public Observable<List<ReasonDowntime>> getReasons() {
        return downtimeService.getReasons()
                .doOnNext(data -> Log.d("myLogs", " downtimeService.getReasons "+String.valueOf(data)) )
                .doOnComplete(() -> Log.d("myLogs"," downtimeService.getReasons "+"OK"))
                .doOnError(t -> Log.d("myLogs", " downtimeService.getReasons "+t.getMessage()));
    }

    @Override
    public Observable<Boolean> addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName) {
        return downtimeService.addDowntime(idForklift, reason, startDowntime, finishDowntime, userName)
                .doOnNext(data -> Log.d("myLogs", " downtimeService.addDowntime "+String.valueOf(data)) )
                .doOnComplete(() -> Log.d("myLogs"," downtimeService.addDowntime "+"OK"))
                .doOnError(t -> Log.d("myLogs", " downtimeService.addDowntime "+t.getMessage()));
    }
}
