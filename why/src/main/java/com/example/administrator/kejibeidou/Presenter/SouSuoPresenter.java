package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.SouSuoDataBean;
import com.example.administrator.kejibeidou.Model.SouSuoModel;
import com.example.administrator.kejibeidou.Presenter.Interface.SouSuoPrester;
import com.example.administrator.kejibeidou.View.Interface.SouSuoView;

/**
 * Created by Administrator on 2018/3/19.
 */

public class SouSuoPresenter implements SouSuoPrester {

    private  SouSuoModel souSuoModel;
        SouSuoView souSuoView;

    public SouSuoPresenter(SouSuoView souSuoView) {
        this.souSuoView = souSuoView;
        souSuoModel = new SouSuoModel(this);

    }

    public void getDataUrl(String sousuo) {
        souSuoModel.getDatUrl(sousuo);

    }

    @Override
    public void success(SouSuoDataBean souSuoDataBean) {
        souSuoView.success(souSuoDataBean);
    }
}
