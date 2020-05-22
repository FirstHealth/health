package com.wd.health.healthys.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.health.healthys.MVP.base.BaseFragment;
import com.wd.health.healthys.MVP.base.BasePresenter;
import com.wd.health.healthys.MVP.presenter.Presenter;
import com.wd.health.healthys.R;
import com.wd.health.healthys.activity.SouActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends BaseFragment {


    @BindView(R.id.Tablay)
    TabLayout Tablay;
    @BindView(R.id.Pagers)
    ViewPager Pagers;
    @BindView(R.id.Circle_Sou)
    ImageView CircleSou;
    private Unbinder bind;
    private List<String> list = new ArrayList<>();
    private List<Fragment> mList = new ArrayList<>();
    private GuFragment guFragment = new GuFragment();
    private NieFragment nieFragment = new NieFragment();
    private YanFragment yanFragment = new YanFragment();
    private SonFragment sonFragment = new SonFragment();
    private JiFragment jiFragment = new JiFragment();
    private ErFragment erFragment = new ErFragment();
    private JingFragment jingFragment = new JingFragment();
    private PiFragment piFragment = new PiFragment();

    @Override
    protected int LayoutId() {
        return R.layout.fragment_circle;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View v) {
        bind = ButterKnife.bind(this, v);

        list.add("内科");
        list.add("骨科");
        list.add("眼科");
        list.add("小儿科");
        list.add("急诊科");
        list.add("皮肤性病");
        list.add("耳鼻喉科");
        list.add("精神病科");
        mList.add(nieFragment);
        mList.add(guFragment);
        mList.add(yanFragment);
        mList.add(sonFragment);
        mList.add(jiFragment);
        mList.add(piFragment);
        mList.add(erFragment);
        mList.add(jingFragment);
        Pagers.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }

            @Override
            public int getCount() {
                return mList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        Tablay.setupWithViewPager(Pagers);
    }


    @Override
    protected void initDate() {
        CircleSou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SouActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSccuess(Object o) {

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
