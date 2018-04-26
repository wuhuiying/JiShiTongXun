package com.example.administrator.kejibeidou.View.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Fragment.KeJiYuan_Fragment;
import com.example.administrator.kejibeidou.View.Fragment.TongXunLong_Fragment;
import com.example.administrator.kejibeidou.View.Fragment.WoDe_Fragment;
import com.example.administrator.kejibeidou.View.Fragment.ZiXun_Fragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShouYeActivity extends AppCompatActivity {

    private FrameLayout ShouYe_FrameLayout;
    private BottomTabBar bottom_tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye);
        initView();
    }

    private void initView() {
        ShouYe_FrameLayout = (FrameLayout) findViewById(R.id.ShouYe_FrameLayout);
        bottom_tab_bar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottom_tab_bar.init(getSupportFragmentManager())
                .setImgSize(80,80)
                .setFontSize(12)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.GREEN,Color.DKGRAY)
                .addTabItem("咨讯",R.drawable.u53, ZiXun_Fragment.class)
                .addTabItem("科技圈",R.drawable.u45, KeJiYuan_Fragment.class)
                .addTabItem("通讯录",R.drawable.u54, TongXunLong_Fragment.class)
                .addTabItem("我的",R.drawable.u47, WoDe_Fragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
