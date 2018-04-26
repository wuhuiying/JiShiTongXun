package com.example.administrator.kejibeidou.Model;

import android.util.Log;

import com.example.administrator.kejibeidou.Model.Bean.RegBean;
import com.example.administrator.kejibeidou.Presenter.Interface.RegPrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/26.
 */

public class Reg_Model {
    RegPrester zhuCe_p;

    public Reg_Model(RegPrester zhuCe_p) {
        this.zhuCe_p = zhuCe_p;
    }
    public void getDataUrl(String password, String main_editText_check, String main_editText_phone) {

                Map<String, String> map = new HashMap<>();
                map.put("phone",main_editText_phone);
                map.put("nickName","why");
                map.put("password",password);
                map.put("email","1779434766@qq.com");
                map.put("passwordTwo",password);
                map.put("check",main_editText_check);
        RetrofitHelper.getApiService(Api.ZhuCe_BASE_Url1).post(Api.ZhuCe_BASE_Url2,map)
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
                        Log.d("TAG",s.toString());
                        Gson gson = new Gson();
                        RegBean zhuceBean = gson.fromJson(s, RegBean.class);
                        zhuCe_p.success(zhuceBean);
                    }
                });
    }
}
