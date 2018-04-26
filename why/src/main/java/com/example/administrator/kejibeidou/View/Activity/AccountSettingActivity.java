package com.example.administrator.kejibeidou.View.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.kejibeidou.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class AccountSettingActivity extends AppCompatActivity {


    private boolean isDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        isDebug = getSharedPreferences("config", MODE_PRIVATE).getBoolean("isDebug", false);
        //获取控件
        initView();
    }

    private void initView() {
        RelativeLayout mPassword = (RelativeLayout) findViewById(R.id.ac_set_change_pswd);
        RelativeLayout mPrivacy = (RelativeLayout) findViewById(R.id.ac_set_privacy);
        RelativeLayout mNewMessage = (RelativeLayout) findViewById(R.id.ac_set_new_message);
        RelativeLayout mClean = (RelativeLayout) findViewById(R.id.ac_set_clean);
        RelativeLayout mExit = (RelativeLayout) findViewById(R.id.ac_set_exit);
        LinearLayout layout_push = (LinearLayout) findViewById(R.id.layout_push_setting);
        if (isDebug) {
            layout_push.setVisibility(View.VISIBLE);

        } else {
            layout_push.setVisibility(View.GONE);
        }
  //退出登录的点击事件
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EMClient.getInstance().logout(true, new EMCallBack() {
                    @Override
                    public void onSuccess() {

//                     AlertDialog alertDialog=new AlertDialog.Builder(AccountSettingActivity.this).create();
//                      alertDialog.setMessage("是否退出登录");
//                      alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
//                          @Override
//                          public void onClick(DialogInterface dialogInterface, int i) {
//                              Intent intent=new Intent(AccountSettingActivity.this,LoginActivity.class);
//                              startActivity(intent);
//                              finish();
//                          }
//                      });
//                      alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
//                          @Override
//                          public void onClick(DialogInterface dialogInterface, int i) {
//                              finish();
//                          }
//                      });

                    }

                    @Override
                    public void onError(int i, String s) {

                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
            }
        });

    }



}


