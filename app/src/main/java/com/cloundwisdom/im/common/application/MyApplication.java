package com.cloundwisdom.im.common.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cloundwisdom.im.BuildConfig;
import com.cloundwisdom.im.common.base.UIApplication;
import com.hjq.toast.ToastUtils;

/**
 * 程序主入口
 */
public class MyApplication extends UIApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ToastUtils.init(this);
    }
}
