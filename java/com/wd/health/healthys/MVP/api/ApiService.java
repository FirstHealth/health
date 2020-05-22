package com.wd.health.healthys.MVP.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/18
 * Time: 19:37
 */
public interface ApiService {
    //GetParams请求
    @GET
    Observable<ResponseBody> GetParamsInfo(@Url String url, @QueryMap Map<String,Object> map);
}
