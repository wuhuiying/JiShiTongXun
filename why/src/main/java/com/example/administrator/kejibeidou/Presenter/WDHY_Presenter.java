package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.WDHYDataBean;
import com.example.administrator.kejibeidou.Model.WDHY_Model;
import com.example.administrator.kejibeidou.Presenter.Interface.WDHYPrester;
import com.example.administrator.kejibeidou.View.Interface.WDHY_View;

/**
 * Created by Administrator on 2018/3/8.
 */

public class WDHY_Presenter implements WDHYPrester {

    private  WDHY_Model wdhy_model;
    WDHY_View wdhy_view;

    public WDHY_Presenter(WDHY_View wdhy_view) {
        this.wdhy_view = wdhy_view;
        wdhy_model = new WDHY_Model(this);
    }

    public void getDataUrl() {
        wdhy_model.getDataUrl();
    }

    @Override
    public void success(WDHYDataBean wdhyDataBean) {
        wdhy_view.success(wdhyDataBean);
    }
}
