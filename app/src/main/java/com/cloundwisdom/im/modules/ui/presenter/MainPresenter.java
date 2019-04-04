package com.cloundwisdom.im.modules.ui.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.cloundwisdom.im.common.api.ApiRetrofit;
import com.cloundwisdom.im.common.base.BaseObserver;
import com.cloundwisdom.im.common.base.BaseResponse;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.modules.adapter.NewsAdapter;
import com.cloundwisdom.im.modules.entry.NewsEntry;
import com.cloundwisdom.im.common.base.BasePresenter;
import com.cloundwisdom.im.modules.ui.view.IMainView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter extends BasePresenter<IMainView> {

    private List<NewsEntry> lists=new ArrayList<>();
    private NewsAdapter adapter;
    public MainPresenter(MyActivity context) {
        super(context);
    }

    public void initView(){
        getView().getRecyclerView().setLayoutManager(new LinearLayoutManager(prContext));
        adapter=new NewsAdapter(prContext,lists);
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
        prContext.showWaitingDialog("加载中....");
        ApiRetrofit.getInstance().getNewsList(pageSize,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<NewsEntry>>(prContext) {
                    @Override
                    protected void onSuccess(BaseResponse<List<NewsEntry>> t){
                        prContext.hideWaitingDialog();
                        lists.addAll(t.getNewslist());
                        adapter.notifyDataSetChanged();
                        toast("加载完成");
                    }

                    @Override
                    protected void onError(BaseResponse<List<NewsEntry>> t){
                        prContext.hideWaitingDialog();
                        toast("暂无数据");
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError){
                        prContext.hideWaitingDialog();
                        toast("网络连接失败，请联系网络管理员");
                    }
                });

    }
}
