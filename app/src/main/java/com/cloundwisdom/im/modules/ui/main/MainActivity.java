package com.cloundwisdom.im.modules.ui.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.constant.ActivityConstant;

@Route(path = ActivityConstant.MAIN)
public class MainActivity extends MyActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
