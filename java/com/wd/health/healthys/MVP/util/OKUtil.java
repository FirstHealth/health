package com.wd.health.healthys.MVP.util;

import android.util.Log;
import android.widget.Adapter;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wd.health.healthys.MVP.api.ApiService;
import com.wd.health.healthys.MVP.url.MyUrls;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:17
 * ok网络框架
 */
public class OKUtil {

    private final ApiService apiService;

    //单例封装
    private OKUtil() {
        //添加日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)//添加日志拦截器
                .readTimeout(10, TimeUnit.SECONDS)//读写设置为10秒
                .connectTimeout(10, TimeUnit.SECONDS)//连接超时设置为10秒
                .writeTimeout(10, TimeUnit.SECONDS)//读取设置为10秒
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)//添加ok
                .baseUrl(MyUrls.BASE_URL)//添加url
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加RXjava
                .addConverterFactory(GsonConverterFactory.create())//添加gson解析
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private static class OKHelper {
        private static OKUtil okUtil = new OKUtil();
    }

    public static OKUtil getInstance() {
        return OKHelper.okUtil;
    }

    public interface NetCallBack<T> {
        void onSccuess(T t);

        void onError(String error);
    }
    //GetParams连接
    public void GetParamsInfo(String url, Class cls, Map<String, Object> map, NetCallBack netCallBack) {
        apiService.GetParamsInfo(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResourceObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        if (netCallBack != null) {
                            try {
                                Object o = new Gson().fromJson(responseBody.string(), cls);
                                netCallBack.onSccuess(o);
                                Log.e("TAG", "onNext: " + o);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (netCallBack != null) {
                            netCallBack.onError(e.getMessage());
                            Log.e("TAG", "onError: " + e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
