package com.example.administrator.kejibeidou.View.Fragment.TongXunLu_Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.UserNameDataBean;
import com.example.administrator.kejibeidou.Model.Bean.WDHYDataBean;
import com.example.administrator.kejibeidou.Presenter.WDHY_Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.example.administrator.kejibeidou.Util.SlideBar;
import com.example.administrator.kejibeidou.View.Activity.HaoYouActivity;
import com.example.administrator.kejibeidou.View.Adapter.WDHY_Adapter;
import com.example.administrator.kejibeidou.View.Interface.WDHY_View;
import com.google.gson.Gson;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.widget.EaseTitleBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/28.
 */

public class Fragment_WDHY extends Fragment implements WDHY_View {

    private WDHY_Presenter wdhy_presenter;
    private ListView WDHY_listview;
    private WDHY_Adapter wdhy_adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView tv_float;
    private SlideBar slideBar;
    private WDHYDataBean wdhyDataBean;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wdhy_fragment_layout, container, false);

        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wdhy_presenter = new WDHY_Presenter(this);
        wdhy_presenter.getDataUrl();

    }

    @Override
    public void success(final WDHYDataBean wdhyDataBean) {
        this.wdhyDataBean=wdhyDataBean;
        wdhy_adapter = new WDHY_Adapter(getActivity(), wdhyDataBean);
        WDHY_listview.setAdapter(wdhy_adapter);
        WDHY_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final Map<String, String> map=new HashMap<>();
                map.put("friendId",wdhyDataBean.getResult().get(i).getId() + "");
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
                                Intent intent = new Intent(getActivity(), HaoYouActivity.class);
                                intent.putExtra(EaseConstant.EXTRA_USER_ID, userNameDataBean.getResult().getUserName());
                                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                                intent.putExtra("name", wdhyDataBean.getResult().get(i).getNickName());
                                startActivity(intent);
                            }
                        });

//                intent.putExtra("userid1", wdhyDataBean.getResult().get(i).getId() + "");

            }
        });
    }

    private void initView(View view) {
        WDHY_listview = (ListView) view.findViewById(R.id.WDHY_listview);
        slideBar = (SlideBar) view.findViewById(R.id.slideBar);
        linearLayoutManager = new LinearLayoutManager(getActivity());

    }


}
