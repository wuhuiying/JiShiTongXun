package com.example.administrator.kejibeidou.Model;

import android.util.Log;
import android.widget.EditText;

import com.example.administrator.kejibeidou.Presenter.YanZhengMa_Presenter;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class YanZhengMa_Model {

    public YanZhengMa_Model(YanZhengMa_Presenter yanZhengMa_presenter) {
    }

    public void getDataUrl(EditText zhuce_EditText_name) {
        RetrofitHelper.getApiService("http://www.bwstudent.com/").get("kjbd/user/sms?phone="+zhuce_EditText_name+"&type="+zhuce_EditText_name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }
}
