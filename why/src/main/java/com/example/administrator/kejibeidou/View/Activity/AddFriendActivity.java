package com.example.administrator.kejibeidou.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.kejibeidou.R;

public class AddFriendActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView xinpengyou_img;
    private LinearLayout tianjia_LinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_jia);
        initView();
    }

    private void initView() {
        xinpengyou_img = (ImageView) findViewById(R.id.xinpengyou_img);
        tianjia_LinearLayout = (LinearLayout) findViewById(R.id.tianjia_LinearLayout);
        xinpengyou_img.setOnClickListener(this);
        tianjia_LinearLayout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xinpengyou_img:
                finish();
                break;
            case R.id.tianjia_LinearLayout:
                startActivity(new Intent(AddFriendActivity.this,SouSuoActivity.class));
                finish();
                break;
        }
    }
}
