package com.example.administrator.kejibeidou.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.ZhuangTaiDataBean;
import com.example.administrator.kejibeidou.Presenter.TongZhi_Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.NewFriendAdapter;
import com.example.administrator.kejibeidou.View.Interface.TongZhi_View;

public class NewFriendActivity extends AppCompatActivity implements View.OnClickListener,TongZhi_View {

    private ImageView xinpengyou_img;
    private TextView xinpengyou_tianjia;
    private ListView xinpengyou_listview;
    private TongZhi_Presenter zhuangTaiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_peng_you);
        initView();
    }

    private void initView() {
        xinpengyou_img = (ImageView) findViewById(R.id.xinpengyou_img);
        xinpengyou_tianjia = (TextView) findViewById(R.id.xinpengyou_tianjia);
        xinpengyou_listview = (ListView) findViewById(R.id.xinpengyou_listview);
        xinpengyou_img.setOnClickListener(this);
        xinpengyou_tianjia.setOnClickListener(this);
        zhuangTaiPresenter = new TongZhi_Presenter(this);
        zhuangTaiPresenter.getDataUrl();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xinpengyou_img:
                finish();
                break;
                case R.id.xinpengyou_tianjia:
                    startActivity(new Intent(NewFriendActivity.this,AddFriendActivity.class));
                    finish();
                    break;
        }
    }

    @Override
    public void success(ZhuangTaiDataBean zhuangTaiDataBean) {

        NewFriendAdapter xinPengYouAdapter = new NewFriendAdapter(NewFriendActivity.this,zhuangTaiDataBean);
        xinpengyou_listview.setAdapter(xinPengYouAdapter);
    }
}
