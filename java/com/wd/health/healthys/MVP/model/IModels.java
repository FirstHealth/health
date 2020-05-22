package com.wd.health.healthys.MVP.model;

import com.wd.health.healthys.MVP.contract.Contract;
import com.wd.health.healthys.MVP.util.OKUtil;

import java.util.Map;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:35
 * M层获取网络数据
 */
public class IModels implements Contract.Model {
    //GetParamsInfo
    @Override
    public void GetParamsInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack) {
        OKUtil.getInstance().GetParamsInfo(url, cls, map, new OKUtil.NetCallBack() {
            @Override
            public void onSccuess(Object o) {
                myCallBack.onSccuess(o);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
