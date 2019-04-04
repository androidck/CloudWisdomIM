package com.cloundwisdom.im.modules.ui.main;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.constant.ActivityConstant;
import com.cloundwisdom.im.modules.ui.presenter.MainPresenter;
import com.cloundwisdom.im.modules.ui.view.IMainView;
import com.hjq.bar.TitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

@Route(path = ActivityConstant.MAIN)
public class MainActivity extends MyActivity<IMainView, MainPresenter> implements IMainView {

    @BindView(R.id.view_title)
    TitleBar viewTitle;

    public static final int MODE_DEFAULT = 0;

    public static final int MODE_SONIC = 1;

    public static final int MODE_SONIC_WITH_OFFLINE_CACHE = 2;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

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
        mPresenter.initView();
    }

    @Override
    protected void initData() {
        mPresenter.getNewsList();
    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
