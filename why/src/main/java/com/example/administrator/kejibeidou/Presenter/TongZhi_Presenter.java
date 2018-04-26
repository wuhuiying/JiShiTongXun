package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.ZhuangTaiDataBean;
import com.example.administrator.kejibeidou.Model.TongZhiModel;
import com.example.administrator.kejibeidou.Presenter.Interface.TongZhiPrester;
import com.example.administrator.kejibeidou.View.Interface.TongZhi_View;

/**
 * Created by Administrator on 2018/3/21.
 */

public class TongZhi_Presenter implements TongZhiPrester {

    private TongZhiModel zhuangTaiModel;
    TongZhi_View zhuangTai__view;

    public TongZhi_Presenter(TongZhi_View zhuangTai__view) {
        this.zhuangTai__view = zhuangTai__view;
        zhuangTaiModel = new TongZhiModel(this);
    }

    public void getDataUrl() {
        zhuangTaiModel.getDataUrl();
    }

    @Override
    public void success(ZhuangTaiDataBean zhuangTaiDataBean) {
        zhuangTai__view.success(zhuangTaiDataBean);
    }
}
