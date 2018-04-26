package com.example.administrator.kejibeidou.View.Fragment.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1DataBean;
import com.example.administrator.kejibeidou.Model.Bean.Fragment1_DataBean;
import com.example.administrator.kejibeidou.Presenter.Fragment2_Presenter;
import com.example.administrator.kejibeidou.Presenter.Fragment1__Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.Fragment1_Adapter;
import com.example.administrator.kejibeidou.View.Interface.Fragment_View;
import com.example.administrator.kejibeidou.View.Interface.Fragment__View;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27.
 */

public class Fragment1 extends Fragment implements Fragment_View,Fragment__View{

    private Banner banner;
    private RecyclerView Fragment_RecyclerView;
    private Fragment2_Presenter fragment1_presenter;
    List<String> list = new ArrayList<String>();
    private Fragment1__Presenter fragment1__presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment1_layout, container, false);
            initView(view);
            return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        Fragment_RecyclerView = (RecyclerView) view.findViewById(R.id.Fragment_RecyclerView);

        fragment1_presenter = new Fragment2_Presenter(this);
        fragment1_presenter.getDataUrl();

        fragment1__presenter = new Fragment1__Presenter(this);
        fragment1__presenter.getDataUrl();

    }

    @Override
    public void success(final Fragment1DataBean fragment1DataBean) {
        getActivity().runOnUiThread(
                new Runnable() {
            @Override
            public void run() {
                list.clear();
                List<Fragment1DataBean.ResultBean> result = fragment1DataBean.getResult();
                for (Fragment1DataBean.ResultBean d:result){
                    list.add(d.getImg());
                }
                //轮播下面样式属性
                banner.setBannerStyle(Banner.NUM_INDICATOR_TITLE);//设置圆形指示器与标题
                banner.setIndicatorGravity(Banner.CENTER);//设置指示器位置
                banner.setDelayTime(2000);//设置轮播时间
                banner.isAutoPlay(true);
                //设置图片集合
                banner.setImages(list);//设置图片源
            }
        });

    }

    @Override
    public void success(final Fragment1_DataBean fragment1_dataBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                Fragment_RecyclerView.setLayoutManager(linearLayoutManager);
                Fragment1_Adapter fragment1_adapter = new Fragment1_Adapter(getActivity(),fragment1_dataBean);
                Fragment_RecyclerView.setAdapter(fragment1_adapter);
            }
        });
    }
}
