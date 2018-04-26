package com.example.administrator.kejibeidou.Model;

import com.example.administrator.kejibeidou.Model.Bean.UserNameDataBean;
import com.example.administrator.kejibeidou.Presenter.Interface.UsesNamePrester;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/3/20.
 */

public class UserNameModel {
   UsesNamePrester userNameP;

    public UserNameModel(UsesNamePrester userNameP) {
        this.userNameP = userNameP;
    }

    public void getDataUrl(String userid) {
        Map<String, String> map=new HashMap<>();
        map.put("friendId",userid);
        RetrofitHelper.getApiService(Api.ZiXun_Base_Url1).get(Api.HXUSER_BASE,map)
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
                        UserNameDataBean userNameDataBean = gson.fromJson(s, UserNameDataBean.class);
                        userNameP.success(userNameDataBean);
                    }
                });
    }
}
