package com.sample.core.repository.impl;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;
import com.sample.core.repository.InformingRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MockInformingRepositoryImpl implements InformingRepository {

    private static MockInformingRepositoryImpl InformingRepository;

    public static InformingRepository instance(String textAccess) {
        if(InformingRepository == null) {
            InformingRepository = new MockInformingRepositoryImpl();
            //InformingRepository.textAccess = textAccess;
        }
        return InformingRepository;
    }

    @Override
    public Observable<ResultLogin> login(String userName, String password) {
        if (userName.equals("test") && password.equals("111")) {
            return Observable.just(new ResultLogin("Worked", ""));
        }
        else return Observable.just(new ResultLogin("UnWorked", "Неверный логин или пароль"));
    }

    @Override
    public Observable<InfoForklift> getInfoForklift(String idForklift) {

        List<LastDowntime> list = new ArrayList<>();
        list.add(new LastDowntime("01", "Простой из-за отсутствия водителя", "16.03.20 14:15 - 16.03.20 15:40"));
        list.add(new LastDowntime("02", "Простой из-за отсутствия работы", "16.03.20 09:01 - 16.03.20 12:53"));
        list.add(new LastDowntime("03", "Простой по причине ремонта", "12.03.20 08:03 - 15.03.20 19:53"));
        list.add(new LastDowntime("04", "Простой из-за нехватки запчастей", "11.03.20 16:19 - 12.03.20 08:03"));
        list.add(new LastDowntime("05", "Простой из-за отсутствия водителя", "05.03.20 11:30 - 05.03.20 14:22"));
        return Observable.just(new InfoForklift("Автопогрузчик №06 TOYOTA", list));
    }

    @Override
    public Observable<List<ReasonDowntime>> getReasons() {
        List<ReasonDowntime> list = new ArrayList<>();
        list.add(new ReasonDowntime("001", "Выберите причину..."));
        list.add(new ReasonDowntime("690", "Простой из-за нехватки запчастей"));
        list.add(new ReasonDowntime("691", "Простой из-за отсутствия водителя"));
        list.add(new ReasonDowntime("692", "Простой из-за отсутствия работы"));
        list.add(new ReasonDowntime("688", "Простой по причине ремонта"));
        return Observable.just(list);
    }

    @Override
    public Observable<Boolean> addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName) {
        return Observable.just(true);
    }

}
