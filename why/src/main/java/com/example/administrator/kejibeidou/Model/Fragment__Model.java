package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1_DataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.Fragment2Prester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/3/2.
 */

public class Fragment__Model {
    Fragment2Prester fragment1__p;

    public Fragment__Model(Fragment2Prester fragment1__p) {
        this.fragment1__p = fragment1__p;
    }

    public void getDataUrl() {
        Map<String, String> map=new HashMap<>();
        RetrofitHelper.getApiService(Api.XINWEN_Base_Url1).get(Api.XINWEN_Base_Url2)
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
                        Fragment1_DataBean fragment1_dataBean = gson.fromJson(s, Fragment1_DataBean.class);
                        fragment1__p.success(fragment1_dataBean);
                    }
                });
    }
}
