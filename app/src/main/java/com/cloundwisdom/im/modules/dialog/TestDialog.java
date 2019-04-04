package com.cloundwisdom.im.modules.dialog;

import android.content.Context;
import android.view.Gravity;

import com.cloundwisdom.im.R;
import com.hjq.base.view.BaseCustomDialog;

public class TestDialog extends BaseCustomDialog {

    public TestDialog(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int showType() {
        return Gravity.CENTER;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
