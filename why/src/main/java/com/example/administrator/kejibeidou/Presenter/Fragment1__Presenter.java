package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1_DataBean;
import com.example.administrator.kejibeidou.Model.Fragment__Model;
import com.example.administrator.kejibeidou.Presenter.Interface.Fragment2Prester;
import com.example.administrator.kejibeidou.View.Interface.Fragment__View;

/**
 * Created by Administrator on 2018/3/2.
 */

public class Fragment1__Presenter implements Fragment2Prester {

    private  Fragment__Model fragment__model;
    Fragment__View fragment__view;

    public Fragment1__Presenter(Fragment__View fragment__view) {
        this.fragment__view = fragment__view;
        fragment__model = new Fragment__Model(this);

    }
    public void getDataUrl() {
        fragment__model.getDataUrl();
    }

    @Override
    public void success(Fragment1_DataBean fragment1_dataBean) {
        fragment__view.success(fragment1_dataBean);
    }
}
