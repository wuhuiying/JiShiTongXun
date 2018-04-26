package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.WDHYDataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.WDHYPrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/3/8.
 */

public class WDHY_Model {
   WDHYPrester wdhy_p;

    public WDHY_Model(WDHYPrester wdhy_p) {
        this.wdhy_p = wdhy_p;
    }

    public void getDataUrl() {
        RetrofitHelper.getApiService(Api.WDHY_BASE1).get(Api.WDHY_BASE2)
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
                        WDHYDataBean wdhyDataBean = gson.fromJson(s, WDHYDataBean.class);
                        wdhy_p.success(wdhyDataBean);
                    }
                });
    }
}
