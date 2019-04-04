package com.cloundwisdom.im.modules.ui.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.BasePresenter;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.constant.ActivityConstant;
import com.hjq.bar.TitleBar;

import butterknife.BindView;

@Route(path = ActivityConstant.LOGIN)
public class LoginActivity extends MyActivity {
    @BindView(R.id.view_title)
    TitleBar viewTitle;

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

    }
    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
