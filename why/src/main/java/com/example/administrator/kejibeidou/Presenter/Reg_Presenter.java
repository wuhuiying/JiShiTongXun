package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.RegBean;
import com.example.administrator.kejibeidou.Model.Reg_Model;
import com.example.administrator.kejibeidou.Presenter.Interface.RegPrester;
import com.example.administrator.kejibeidou.View.Interface.Reg_View;

/**
 * Created by Administrator on 2018/2/26.
 */

public class Reg_Presenter implements RegPrester {

    private Reg_Model zhuCe_model;
    Reg_View zhuCe_view;

    public Reg_Presenter(Reg_View zhuCe_view) {
        this.zhuCe_view = zhuCe_view;
        zhuCe_model = new Reg_Model(this);
    }

    public void getDataUrl(String mainEditTextName, String main_editText_name, String main_editText_password) {
        zhuCe_model.getDataUrl(main_editText_name,main_editText_password,mainEditTextName);
    }

    @Override
    public void success(RegBean zhuCeDataBean) {
        zhuCe_view.success(zhuCeDataBean);
    }
}
