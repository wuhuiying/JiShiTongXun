package com.example.administrator.kejibeidou.Presenter;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1DataBean;
import com.example.administrator.kejibeidou.Model.Fragment1_Model;
import com.example.administrator.kejibeidou.Presenter.Interface.Fragment1Prester;
import com.example.administrator.kejibeidou.View.Interface.Fragment_View;

/**
 * Created by Administrator on 2018/2/27.
 */

public class Fragment2_Presenter implements Fragment1Prester {

    private  Fragment1_Model fragment1_model;
    Fragment_View fragment_view;

    public Fragment2_Presenter(Fragment_View fragment_view) {
        this.fragment_view = fragment_view;
        fragment1_model = new Fragment1_Model(this);
    }

    public void getDataUrl() {
        fragment1_model.getDataUrl();
    }

    @Override
    public void success(Fragment1DataBean fragment1DataBean) {
        fragment_view.success(fragment1DataBean);
    }
}
