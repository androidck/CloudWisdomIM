package com.cloundwisdom.im.modules.ui.main;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.base.MyLazyFragment;
import com.cloundwisdom.im.modules.ui.presenter.MainPresenter;
import com.cloundwisdom.im.modules.ui.view.IMainView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 新闻fragment
 */
public class NewsFragment extends MyLazyFragment<IMainView, MainPresenter> implements IMainView {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    String newType;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        mPresenter.initView();
        newType = getArguments().getString("type");
    }

    @Override
    protected void initData() {
        mPresenter.setTitle(newType);
        mPresenter.getNewsList();

    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter((MainActivity) getContext());
    }


    public static NewsFragment newInstance(String type){
        NewsFragment fragment=new NewsFragment();
        Bundle bundle=new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

}
