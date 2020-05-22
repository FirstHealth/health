package com.wd.health.healthys.MVP.base;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wd.health.healthys.MVP.contract.Contract;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:41
 * Fragment基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.IView {
    public P mPresenter;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (LayoutId() != 0){
            v = inflater.inflate(LayoutId(), container, false);
            mPresenter = initPresenter();
            mPresenter.onAttch(this);
            initView(v);
            initDate();
        }
        return v;
    }

    protected abstract int LayoutId();

    protected abstract P initPresenter();

    protected abstract void initView(View v);

    protected abstract void initDate();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDeAttch();
    }
}
