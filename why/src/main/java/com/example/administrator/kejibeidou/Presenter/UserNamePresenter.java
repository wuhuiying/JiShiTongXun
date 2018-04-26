package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.UserNameDataBean;
import com.example.administrator.kejibeidou.Model.UserNameModel;
import com.example.administrator.kejibeidou.Presenter.Interface.UsesNamePrester;
import com.example.administrator.kejibeidou.View.Interface.UserNameView;

/**
 * Created by Administrator on 2018/3/20.
 */

public class UserNamePresenter implements UsesNamePrester {

    private  UserNameModel userNameModel;
    UserNameView userNameView;

    public UserNamePresenter(UserNameView userNameView) {
        this.userNameView = userNameView;
        userNameModel = new UserNameModel(this);

    }

    public void getDataUrl(String userid) {
        userNameModel.getDataUrl(userid);

    }

    @Override
    public void success(UserNameDataBean userNameDataBean) {
        userNameView.success(userNameDataBean);
    }
}
