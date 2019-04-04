package com.cloundwisdom.im.modules.ui.presenter;

import com.cloundwisdom.im.common.base.BasePresenter;
import com.cloundwisdom.im.common.base.MyActivity;
import com.cloundwisdom.im.modules.ui.view.ILoginView;
import com.hjq.base.view.BaseActivity;

public class LoginPresenter extends BasePresenter<ILoginView> {

    public LoginPresenter(MyActivity context) {
        super(context);
    }

    //用户登录
    public void userLogin(){
        String userName=getView().getEtPhone().getText().toString().trim();
        String password=getView().getEtPwd().getText().toString().trim();
    }
}
