package com.sample.core.repository;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;

import java.util.List;

import io.reactivex.Observable;

public interface InformingRepository {
    Observable<ResultLogin> login(String userName, String password);
    Observable<InfoForklift> getInfoForklift(String idForklift);
    Observable<List<ReasonDowntime>> getReasons();
    Observable<Boolean> addDowntime(String idForklift, String reason, String startDowntime, String finishDowntime, String userName);
}
