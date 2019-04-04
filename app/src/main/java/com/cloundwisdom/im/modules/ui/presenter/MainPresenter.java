package com.cloundwisdom.im.modules.ui.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.cloundwisdom.im.common.api.ApiRetrofit;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.modules.adapter.NewsAdapter;
import com.cloundwisdom.im.modules.entry.NewsEntry;
import com.cloundwisdom.im.common.base.BasePresenter;
import com.cloundwisdom.im.modules.ui.view.IMainView;
import com.hjq.base.view.BaseActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<IMainView> {

    private List<NewsEntry> lists=new ArrayList<>();
    private NewsAdapter adapter;
    public MainPresenter(MyActivity context) {
        super(context);
    }

    public void initView(){
        getView().getRecyclerView().setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new NewsAdapter(mContext,lists);
        getView().getRecyclerView().setAdapter(adapter);
        getView().getRefreshLayout().setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        getNewsList();;
                        refreshLayout.finishLoadMore();
                    }
                },150);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lists.clear();
                        page=1;
                        getNewsList();;
                        refreshLayout.finishRefresh();
                    }
                },150);
            }
        });
    }

    //获取列表数据
    public void getNewsList(){
        mContext.showWaitingDialog("加载中....");
        ApiRetrofit.getInstance().getNewsList(pageSize,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBaseResponse -> {
                    mContext.hideWaitingDialog();
                   if (listBaseResponse.getCode()==200){
                       lists.addAll(listBaseResponse.getNewslist());
                       adapter.notifyDataSetChanged();
                   }else {
                       toast("暂无数据");
                   }
                });
    }
}
