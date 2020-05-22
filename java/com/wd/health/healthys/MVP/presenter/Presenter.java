package com.wd.health.healthys.MVP.presenter;

import com.wd.health.healthys.MVP.base.BasePresenter;
import com.wd.health.healthys.MVP.contract.Contract;
import com.wd.health.healthys.MVP.model.IModels;

import java.util.Map;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:39
 */
public class Presenter extends BasePresenter {

    private IModels iModels;

    @Override
    protected void initModels() {
        //获取到imodel
        iModels = new IModels();
    }

    @Override
    public void GetParamsInfo(String url, Class cls, Map<String, Object> map) {
        iModels.GetParamsInfo(url, cls, map, new Contract.Model.MyCallBack() {
            @Override
            public void onSccuess(Object o) {
                getView().onSccuess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
