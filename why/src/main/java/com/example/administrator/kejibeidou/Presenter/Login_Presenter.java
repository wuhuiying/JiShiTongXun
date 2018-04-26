package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.LoginBean;
import com.example.administrator.kejibeidou.Model.Login_Model;
import com.example.administrator.kejibeidou.Presenter.Interface.LoginPrester;
import com.example.administrator.kejibeidou.View.Activity.LoginActivity;

/**
 * Created by Administrator on 2018/2/27.
 */

public class Login_Presenter implements LoginPrester {

    private Login_Model main_model;
    LoginActivity mainActivity;

    public Login_Presenter(LoginActivity mainActivity) {
        this.mainActivity=mainActivity;
        main_model = new Login_Model(mainActivity,this);
    }

    public void getDataUrl(String YZM, String s, String s1) {
        main_model.getDataUrl(s,s1,YZM);
    }
    @Override
    public void success(LoginBean dengLuDataBean) {
        mainActivity.getModelData(dengLuDataBean);
}
}
