package com.example.administrator.kejibeidou.Model;

import android.content.Context;
import android.util.Log;

import com.example.administrator.kejibeidou.Model.Bean.LoginBean;
import com.example.administrator.kejibeidou.Presenter.Login_Presenter;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class Login_Model {
    Login_Presenter main_presenter;
    Context context;
    private RetrofitHelper retrofitHelper;

    public Login_Model(Context context, Login_Presenter main_presenter) {
        this.context=context;
        this.main_presenter=main_presenter;
        retrofitHelper = new RetrofitHelper(context);
    }

    public void getDataUrl(String password, String YZM, String name) {
        retrofitHelper.getApiService(Api.Main_Base_Utl).get("kjbd/user/login?phone="+name+"&password="+password+"&vaildate="+YZM+"&ak=12345678")
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
                        Gson gson = new Gson();
                        LoginBean dengLuDataBean = gson.fromJson(s, LoginBean.class);
                        Log.i("caonimna", "onNext: "+dengLuDataBean.getMessage());
                        main_presenter.success(dengLuDataBean);
                    }
                });
    }
}
