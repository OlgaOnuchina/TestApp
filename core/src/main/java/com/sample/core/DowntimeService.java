package com.sample.core;

import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.ReasonDowntime;
import com.sample.core.dto.ResultLogin;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DowntimeService {

    @GET(value = "/test")
    public Observable<ResultLogin> login(@Query("userName") String userName,
                                         @Query("password") String password);

    @POST(value = "/get/GetInfoForklift")
    public Observable<InfoForklift> getInfoForklift(@Query("idForklift") String idForklift);

    @POST(value = "/get/GetReasonsDowntime")
    public Observable<List<ReasonDowntime>> getReasons();

    @POST(value = "/add/DowntimeForklift")
    public Observable<Boolean> addDowntime(@Query("idForklift") String idForklift,
                                           @Query("reason") String reason,
                                           @Query("startDowntime") String startDowntime,
                                           @Query("finishDowntime") String finishDowntime,
                                           @Query("userName") String userName);


}
