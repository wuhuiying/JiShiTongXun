package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.PagerDataBean;
import com.example.administrator.kejibeidou.Model.Pager_Model;
import com.example.administrator.kejibeidou.Presenter.Interface.NewsPrester;
import com.example.administrator.kejibeidou.View.Interface.News_View;

/**
 * Created by Administrator on 2018/2/27.
 */

public class News_Presenter implements NewsPrester {

    private  Pager_Model pager_model;
    News_View pager_view;

    public News_Presenter(News_View pager_view) {
        this.pager_view = pager_view;
        pager_model = new Pager_Model(this);
    }
    public void getDataUrl() {
      pager_model.getDataUrl();
    }

    @Override
    public void success(PagerDataBean pagerDataBean) {
        pager_view.success(pagerDataBean);
    }
}
