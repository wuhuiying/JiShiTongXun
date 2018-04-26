package com.example.administrator.kejibeidou.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.kejibeidou.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 小慧莹 on 2017/12/17.
 */
public class FragmentNews extends Fragment {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Banner banner;
    private View view;
    private ArrayList<String> list_path;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_layout, container, false);
         initView();
        Bundle bundle = getArguments();


//        //获取到fragment的管理对象
////        mFragmentManager = getActivity().getSupportFragmentManager();
//        TextView textView = view.findViewById(R.id.text_content);
//        //把获取的文字设置上去
//        textView.setText(bundle.getString("title"));
//       /* if(bundle.getString("title")=="推荐"){
//              //加载新的布局   开启事务
////            mFragmentTransaction = mFragmentManager.beginTransaction();
//        }*
//
           return view;
    }

    private void initView() {

//        list_path.clear();
        banner = view.findViewById(R.id.shouye_banner);
        //放图片地址的集合
        list_path = new ArrayList<>();
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");




    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner.setBannerStyle(Banner.NUM_INDICATOR_TITLE);//设置圆形指示器与标题
        banner.setIndicatorGravity(Banner.CENTER);//设置指示器位置
        banner.setDelayTime(2000);//设置轮播时间
        banner.isAutoPlay(true);
        //设置图片集合
        banner.setImages(list_path);//设置图片源



    }


}
