package com.example.administrator.kejibeidou.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Activity.NewFriendActivity;
import com.example.administrator.kejibeidou.View.Fragment.TongXunLu_Fragment.Fragment_SJTX;
import com.example.administrator.kejibeidou.View.Fragment.TongXunLu_Fragment.Fragment_WDHY;
import com.example.administrator.kejibeidou.View.Fragment.TongXunLu_Fragment.Fragment_WDQZ;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class  TongXunLong_Fragment extends Fragment {

    private FrameLayout tongxunlu_FrameLayout;
    private RadioButton tongxunlu_text1;
    private RadioButton tongxunlu_text2;
    private RadioButton tongxunlu_text3;
    private RadioGroup tongxunlu_rg;
    private ImageView tongxunlu_img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tongxunlu_fragment_layout, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getChildFragmentManager().beginTransaction().replace(R.id.tongxunlu_FrameLayout, new Fragment_SJTX()).commit();

    }

    private void initView(View view) {
        tongxunlu_text1 = (RadioButton) view.findViewById(R.id.tongxunlu_text1);
        tongxunlu_text2 = (RadioButton) view.findViewById(R.id.tongxunlu_text2);
        tongxunlu_text3 = (RadioButton) view.findViewById(R.id.tongxunlu_text3);
        tongxunlu_rg = (RadioGroup) view.findViewById(R.id.tongxunlu_rg);
        tongxunlu_FrameLayout = (FrameLayout) view.findViewById(R.id.tongxunlu_FrameLayout);

        tongxunlu_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //选中切换页面
                switch (i) {
                    case R.id.tongxunlu_text1:
                        getChildFragmentManager().beginTransaction().replace(R.id.tongxunlu_FrameLayout, new Fragment_SJTX()).commit();
                        break;
                    case R.id.tongxunlu_text2:
                        getChildFragmentManager().beginTransaction().replace(R.id.tongxunlu_FrameLayout, new Fragment_WDHY()).commit();
                        break;
                    case R.id.tongxunlu_text3:
                        getChildFragmentManager().beginTransaction().replace(R.id.tongxunlu_FrameLayout, new Fragment_WDQZ()).commit();
                        break;
                }
            }
        });

        //通讯录添加新朋友
        tongxunlu_img = (ImageView) view.findViewById(R.id.tongxunlu_img);
        tongxunlu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),NewFriendActivity.class));
            }
        });
    }

}
