package com.cloundwisdom.im.modules.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.constant.ActivityConstant;
import com.cloundwisdom.im.modules.adapter.MyViewPageAdapter;
import com.cloundwisdom.im.modules.ui.presenter.MainPresenter;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ActivityConstant.MAIN)
public class MainActivity extends MyActivity {


    public static final int MODE_DEFAULT = 0;

    public static final int MODE_SONIC = 1;

    public static final int MODE_SONIC_WITH_OFFLINE_CACHE = 2;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPage)
    ViewPager viewPage;
    @BindView(R.id.view_title)
    TitleBar viewTitle;

    private MyViewPageAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.view_title;
    }

    @Override
    protected void initView() {
        viewTitle.setLeftIcon(null);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        list.add("动漫");
        list.add("财经");
        list.add("游戏");
        list.add("CBA");
        list.add("区块链");
        list.add("IT资讯");
        list.add("VR科技");
        list.add("奇闻异事");
        list.add("健康知识");



        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(NewsFragment.newInstance("dongman"));
        fragmentList.add(NewsFragment.newInstance("caijing"));
        fragmentList.add(NewsFragment.newInstance("game"));
        fragmentList.add(NewsFragment.newInstance("cba"));
        fragmentList.add(NewsFragment.newInstance("blockchain"));
        fragmentList.add(NewsFragment.newInstance("it"));
        fragmentList.add(NewsFragment.newInstance("vr"));
        fragmentList.add(NewsFragment.newInstance("qiwen"));
        fragmentList.add(NewsFragment.newInstance("health"));

        adapter = new MyViewPageAdapter(getSupportFragmentManager(), this, fragmentList, list);
        viewPage.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPage);
    }


    @Override
    protected MainPresenter createPresenter() {
        return null;
    }



}
