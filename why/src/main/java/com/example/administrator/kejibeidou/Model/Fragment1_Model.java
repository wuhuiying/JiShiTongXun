package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1DataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.Fragment1Prester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class Fragment1_Model {
   Fragment1Prester fragment1_p;

    public Fragment1_Model(Fragment1Prester fragment1_p) {
        this.fragment1_p = fragment1_p;
    }

    public void getDataUrl() {
        Map<String, String> map=new HashMap<>();
        RetrofitHelper.getApiService(Api.Fragment1_Base_Url1).get(Api.Fragment1_Base_Url2)
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
                        Fragment1DataBean fragment1DataBean = gson.fromJson(s, Fragment1DataBean.class);
                        fragment1_p.success(fragment1DataBean);
                    }
                });
    }
}
