package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.PagerDataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.NewsPrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class Pager_Model {

   NewsPrester pager_p;

    public Pager_Model(NewsPrester pager_p) {
        this.pager_p = pager_p;
    }

    public void getDataUrl() {
        RetrofitHelper.getApiService(Api.ZiXun_Base_Url1).get(Api.ZiXun_Base_Url2)
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
                        PagerDataBean pagerDataBean = gson.fromJson(s, PagerDataBean.class);
                        pager_p.success(pagerDataBean);

                    }
                });
    }
}
