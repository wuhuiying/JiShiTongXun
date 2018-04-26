package com.example.administrator.kejibeidou.Presenter;

import android.widget.EditText;

import com.example.administrator.kejibeidou.Model.YanZhengMa_Model;
import com.example.administrator.kejibeidou.View.Activity.RegActivity;

/**
 * Created by Administrator on 2018/2/27.
 */

public class YanZhengMa_Presenter {

    private final YanZhengMa_Model yanZhengMa_model;

    public YanZhengMa_Presenter(RegActivity zhuCeActivity) {
        yanZhengMa_model = new YanZhengMa_Model(this);
    }

    public void getDataUrl(EditText zhuce_EditText_name) {
        yanZhengMa_model.getDataUrl(zhuce_EditText_name);
    }
}
