package com.cloundwisdom.im.modules.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cloundwisdom.im.R;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.common.constant.ActivityConstant;
import com.cloundwisdom.im.common.constant.KeyConstant;
import com.cloundwisdom.im.common.util.PermissionUtils;
import com.hjq.bar.TitleBar;
import com.hjq.base.permission.Permission;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ActivityConstant.MAIN)
public class MainActivity extends MyActivity {

    @BindView(R.id.view_title)
    TitleBar viewTitle;
    @BindView(R.id.btn_get_permission)
    Button btnGetPermission;

    public static final int MODE_DEFAULT = 0;

    public static final int MODE_SONIC = 1;

    public static final int MODE_SONIC_WITH_OFFLINE_CACHE = 2;

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

    @OnClick(R.id.btn_get_permission)
    public void onViewClicked() {
        ARouter
                .getInstance()
                .build(ActivityConstant.BROWSER)
                .withString("url","http://m.baidu.com")
                .withInt("mode",KeyConstant.BROWSER_PARAM_MODE)
                .navigation();
    }


}
