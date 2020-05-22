package com.wd.health.healthys.MVP.base;

import com.wd.health.healthys.MVP.contract.Contract;

import java.lang.ref.WeakReference;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:37
 */
public abstract class BasePresenter<V extends Contract.IView> implements Contract.Presenter {

    private WeakReference<V> weakReference;

    public BasePresenter() {
        initModels();
    }

    protected abstract void initModels();

    protected void onAttch(V v) {
        weakReference = new WeakReference<>(v);
    }

    protected void onDeAttch() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected V getView() {
        return weakReference.get();
    }
}
