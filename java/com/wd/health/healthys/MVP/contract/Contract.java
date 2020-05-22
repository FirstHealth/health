package com.wd.health.healthys.MVP.contract;

import java.util.Map;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:32
 * 契约类
 */
public interface Contract {
    //M层
    interface Model {
        void GetParamsInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);

        interface MyCallBack<T> {
            void onSccuess(T t);

            void onError(String error);
        }
    }

    //V层
    interface IView<T> {
        void onSccuess(T t);

        void onError(String error);
    }

    //P层
    interface Presenter {
        void GetParamsInfo(String url, Class cls, Map<String, Object> map);
    }
}
