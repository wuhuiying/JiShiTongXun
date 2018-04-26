package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.SouSuoDataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.SouSuoPrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/19.
 */

public class SouSuoModel {
    SouSuoPrester souSuoP;

    public SouSuoModel(SouSuoPrester souSuoP) {
        this.souSuoP = souSuoP;
    }

    public void getDatUrl(String sousuo) {
        Map<String, String> map=new HashMap<>();
        map.put("phone",sousuo);
        RetrofitHelper.getApiService(Api.Main_Base_Utl).get(Api.SOUSUO_BASE,map)
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
                        SouSuoDataBean souSuoDataBean = gson.fromJson(s, SouSuoDataBean.class);
                        souSuoP.success(souSuoDataBean);
                    }
                });

    }
}
