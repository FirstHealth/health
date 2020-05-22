package com.wd.health.healthys.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wd.health.healthys.MVP.base.BaseFragment;
import com.wd.health.healthys.MVP.base.BasePresenter;
import com.wd.health.healthys.MVP.presenter.Presenter;
import com.wd.health.healthys.MVP.url.MyUrls;
import com.wd.health.healthys.R;
import com.wd.health.healthys.adapter.GuAdapter;
import com.wd.health.healthys.bean.FindSickCircleBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErFragment extends BaseFragment {

    @BindView(R.id.Gu_Recy)
    RecyclerView GuRecy;
    private Unbinder bind;
    private GuAdapter guAdapter;
    private List<FindSickCircleBean.ResultBean> list = new ArrayList<>();
    @Override
    protected int LayoutId() {
        return R.layout.fragment_er;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View v) {
        bind = ButterKnife.bind(this, v);
        GuRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        guAdapter = new GuAdapter(list);
        GuRecy.setAdapter(guAdapter);
    }

    @Override
    protected void initDate() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("departmentId","4");
        map.put("page","1");
        map.put("count","5");
        mPresenter.GetParamsInfo(MyUrls.findSickCircleList_URL, FindSickCircleBean.class,map);
    }

    @Override
    public void onSccuess(Object o) {
        if (o instanceof FindSickCircleBean){
            list.clear();
            list.addAll(((FindSickCircleBean) o).getResult());
            guAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
