package com.example.administrator.kejibeidou.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kejibeidou.Model.Bean.LoginBean;
import com.example.administrator.kejibeidou.Presenter.Login_Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.VerifyUtil;
import com.example.administrator.kejibeidou.View.Interface.MyPresenterKiss;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,MyPresenterKiss {

    private EditText main_EditText_name;
    private EditText main_EditText_password;
    private TextView main_zhuce;
    private Button main_but_denglu;
    private Login_Presenter main_presenter;
    private EditText code;
    private SimpleDraweeView image;
    private LinearLayout kuang;
    private SimpleDraweeView draweeView;
    private SharedPreferences.Editor edit;
    private SharedPreferences why;
    private ImageView de_img_backgroud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

        private void initView() {

        main_EditText_name = (EditText) findViewById(R.id.main_EditText_name);
        main_EditText_password = (EditText) findViewById(R.id.main_EditText_password);
        main_zhuce = (TextView) findViewById(R.id.main_zhuce);
        main_but_denglu = (Button) findViewById(R.id.main_but_denglu);
        main_zhuce.setOnClickListener(this);
        main_but_denglu.setOnClickListener(this);
        //透明图片
        de_img_backgroud = findViewById(R.id.de_img_backgroud);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation= AnimationUtils.loadAnimation(LoginActivity.this,R.anim.translate_anim);

              de_img_backgroud.startAnimation(animation);
            }
        },200);

            draweeView = (SimpleDraweeView) findViewById(R.id.image);
            main_presenter = new Login_Presenter(LoginActivity.this);
            code = (EditText) findViewById(R.id.code);
        code.setOnClickListener(this);
        image = (SimpleDraweeView) findViewById(R.id.image);
        image.setOnClickListener(this);
        kuang = (LinearLayout) findViewById(R.id.kuang);
        main_EditText_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //如果是失去焦点的时候
                if (!hasFocus) {
                    //清除缓存    删除缓存中的一条uri
                    ImagePipeline imagePipeline = Fresco.getImagePipeline();
                    imagePipeline.clearMemoryCaches();
                    imagePipeline.clearDiskCaches();
                    Uri uri = Uri.parse(Api.TuPianUrl);
                    draweeView.setImageURI(uri);
                    //显示验证码图片
                    kuang.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_but_denglu:
                boolean mobile = VerifyUtil.isMobile(main_EditText_name.getText().toString());
                boolean b = VerifyUtil.verifyLength(main_EditText_password.getText().toString());
                //验证码
                String YZM = code.getText().toString();
                if (mobile != true) {
                    Toast.makeText(LoginActivity.this, "手机号有误", Toast.LENGTH_LONG).show();
                } else if (b != true) {
                    Toast.makeText(LoginActivity.this, "密码有误", Toast.LENGTH_LONG).show();
                }
                if (mobile && b){
                    submit();
                    main_presenter.getDataUrl(main_EditText_name.getText().toString(), main_EditText_password.getText().toString(),code.getText().toString());
                }else {
                    Toast.makeText(LoginActivity.this, "验证码不能为空", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.main_zhuce:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));

                break;
            case R.id.image:
                //获取图片的验证码
                Uri uri = Uri.parse(Api.TuPianUrl);
                draweeView.setImageURI(uri);
                //清除缓存    删除缓存中的一条uri
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearMemoryCaches();
                imagePipeline.clearDiskCaches();
                break;
        }
    }


    private void submit() {
        // validate
        String codeString = code.getText().toString().trim();
        if (TextUtils.isEmpty(codeString)) {
            Toast.makeText(this, "请输入图片验证码", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public void getModelData(LoginBean dengLuDataBean) {
        if (dengLuDataBean.getStatus().equals("0000")) {
            //SPUtils.put(MainActivity.this,"userid",dengLuDataBean.getResult().getUserId()+"");
            if(edit!=null){
                edit.clear();
            }else {
                why = getSharedPreferences("why", MODE_PRIVATE);
                edit = why.edit();
                edit.putString("userid",dengLuDataBean.getResult().getUserId()+"");

            }
            edit.commit();

            String userName = dengLuDataBean.getResult().getUserName();
            String password = dengLuDataBean.getResult().getPassword();

            EMClient.getInstance().login(userName,password,new EMCallBack() {//回调
                @Override
                public void onSuccess() {
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    Log.d("main", "登录聊天服务器成功！");

                }

                @Override
                public void onProgress(int progress, String status) {

                }

                @Override
                public void onError(int code, String message) {
                    Log.d("main", "登录聊天服务器失败！");
                }
            });

            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginActivity.this,ShouYeActivity.class));

        } else {
            Toast.makeText(LoginActivity.this, dengLuDataBean.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}

