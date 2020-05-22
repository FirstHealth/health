package com.wd.health.healthys.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.healthys.MVP.base.BaseActivity;
import com.wd.health.healthys.MVP.base.BasePresenter;
import com.wd.health.healthys.MVP.presenter.Presenter;
import com.wd.health.healthys.MVP.url.MyUrls;
import com.wd.health.healthys.R;
import com.wd.health.healthys.adapter.SouAdapter;
import com.wd.health.healthys.bean.SearchSickCircleBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SouActivity extends BaseActivity {


    @BindView(R.id.Edit_Sou)
    EditText EditSou;
    @BindView(R.id.Btn_Sou)
    Button BtnSou;
    @BindView(R.id.Sou_Recy)
    RecyclerView SouRecy;
    private Unbinder bind;
    private List<SearchSickCircleBean.ResultBean> list = new ArrayList<>();
    private SouAdapter souAdapter;

    @Override
    protected int LayoutId() {
        return R.layout.activity_sou;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
        String sou = EditSou.getText().toString().trim();
        souAdapter = new SouAdapter(list);
        SouRecy.setLayoutManager(new LinearLayoutManager(this));
        SouRecy.setAdapter(souAdapter);
        BtnSou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("keyWord", sou);
                mPresenter.GetParamsInfo(MyUrls.searchSickCircle_URL, SearchSickCircleBean.class, map);
                souAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initDate() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyWord", "头");
        mPresenter.GetParamsInfo(MyUrls.searchSickCircle_URL, SearchSickCircleBean.class, map);
        souAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSccuess(Object o) {
        if (o instanceof SearchSickCircleBean) {
            Log.e("TAG", "onSccuess: "+o.toString() );
            list.clear();
            list.addAll(((SearchSickCircleBean) o).getResult());
            souAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
