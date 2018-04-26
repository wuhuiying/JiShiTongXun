package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.ZhuangTaiDataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.TongZhiPrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/3/21.
 */

public class TongZhiModel {
    TongZhiPrester zhuangTai__p;

    public TongZhiModel(TongZhiPrester zhuangTai__p) {
        this.zhuangTai__p = zhuangTai__p;
    }

    public void getDataUrl() {
        RetrofitHelper.getApiService(Api.ZiXun_Base_Url1).get(Api.HYZT_BASE)
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
                        ZhuangTaiDataBean zhuangTaiDataBean = gson.fromJson(s, ZhuangTaiDataBean.class);
                        zhuangTai__p.success(zhuangTaiDataBean);
                    }
                });
    }
}
