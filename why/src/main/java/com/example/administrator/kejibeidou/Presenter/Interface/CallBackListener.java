package com.example.administrator.kejibeidou.Presenter.Interface;

import com.hyphenate.EMCallBack;
import com.hyphenate.exceptions.HyphenateException;
/**
 * Created by Administrator on 2018/3/12.
 */

public abstract class CallBackListener implements EMCallBack {
    /*成功的回调接口*/
    public  abstract void onMainSuccess();
    /*失败的回调的接口*/
    public abstract void onMainError(int i, String s);

    @Override
    public void onSuccess() {

            onMainSuccess();

    }

    @Override
    public void onError(final int i, final String s) {

                onMainError(i,s);
    }

    @Override
    public void onProgress(int i, String s) {
    }
}
