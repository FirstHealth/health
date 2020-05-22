package com.wd.health.healthys;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wd.health.healthys.fragment.CircleFragment;
import com.wd.health.healthys.fragment.HomeFragment;
import com.wd.health.healthys.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Pager)
    ViewPager Pager;
    @BindView(R.id.Rbtn_1)
    RadioButton Rbtn1;
    @BindView(R.id.Rbtn_2)
    RadioButton Rbtn2;
    @BindView(R.id.Rbtn_3)
    RadioButton Rbtn3;
    @BindView(R.id.Radio)
    RadioGroup Radio;
    private HomeFragment homeFragment = new HomeFragment();
    private CircleFragment circleFragment = new CircleFragment();
    private VideoFragment videoFragment = new VideoFragment();
    private List<Fragment> list = new ArrayList<>();
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        list.add(homeFragment);
        list.add(circleFragment);
        list.add(videoFragment);
        initview();
    }

    private void initview() {
        Pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        Pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Radio.check(Radio.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Rbtn_1:
                        Pager.setCurrentItem(0);
                        break;
                    case R.id.Rbtn_2:
                        Pager.setCurrentItem(1);
                        break;
                    case R.id.Rbtn_3:
                        Pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
