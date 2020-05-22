package com.wd.health.healthys.MVP.base;

import android.os.Bundle;
import android.text.Layout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wd.health.healthys.MVP.contract.Contract;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:44
 * activity的基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LayoutId() != 0) {
            setContentView(LayoutId());
            mPresenter = initPresenter();
            if (mPresenter != null) {
                mPresenter.onAttch(this);
            }
            initView();
            initDate();
        }
    }

    protected abstract int LayoutId();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initDate();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDeAttch();
    }
}
