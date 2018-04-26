package com.example.administrator.kejibeidou.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.kejibeidou.Model.Bean.RegBean;
import com.example.administrator.kejibeidou.Presenter.Reg_Presenter;
import com.example.administrator.kejibeidou.Presenter.YanZhengMa_Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.Util.VerifyUtil;
import com.example.administrator.kejibeidou.View.Interface.Reg_View;

import java.util.Timer;
import java.util.TimerTask;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,Reg_View {

    Handler handler=new Handler(){

        public void handleMessage(Message msg) {
            //倒计时完成
            if(msg.what==1){
                timer.cancel();
                total=10;
                zhuce_yuanzhenma.setEnabled(true);
                zhuce_yuanzhenma.setText("点击获取验证码");
            }else{
                zhuce_yuanzhenma.setEnabled(false);
                zhuce_yuanzhenma.setText(total+"秒后再获取");  //9 8 7 6   0
            }

        };

    };
    private EditText zhuce_EditText_name;
    private EditText zhuce_EditText_yanzhenma;
    private Button zhuce_yuanzhenma;
    private EditText zhuce_password;
    private EditText zhuce_password2;
    private EditText zhuce_name;
    private Button zhuce_but_zhuce;
    private Reg_Presenter main_presenter;
    private YanZhengMa_Presenter yanZhengMa_presenter;
    private Timer timer;
    private int total=60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initView();
    }

    private void initView() {
        zhuce_EditText_name = (EditText) findViewById(R.id.zhuce_EditText_name);
        zhuce_EditText_yanzhenma = (EditText) findViewById(R.id.zhuce_EditText_yanzhenma);
        zhuce_yuanzhenma = (Button) findViewById(R.id.zhuce_yuanzhenma);
        zhuce_password = (EditText) findViewById(R.id.zhuce_password);
        zhuce_password2 = (EditText) findViewById(R.id.zhuce_password2);
        zhuce_name = (EditText) findViewById(R.id.zhuce_name);
        zhuce_but_zhuce = (Button) findViewById(R.id.zhuce_but_zhuce);
        zhuce_yuanzhenma.setOnClickListener(this);
        zhuce_but_zhuce.setOnClickListener(this);

        main_presenter = new Reg_Presenter(this);
        yanZhengMa_presenter = new YanZhengMa_Presenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce_yuanzhenma:
                boolean mobile1 = VerifyUtil.isMobile(zhuce_EditText_name.getText().toString());
                if (mobile1){
                    timer = new Timer();
                    //使用timer进行计时
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            total--;
                            //判断是否计时完成
                            if(total==0){
                                handler.sendEmptyMessage(1);  //
                            }else{
                                handler.sendEmptyMessage(2);
                            }

                        }
                    }, 0, 1000);
                    yanZhengMa_presenter.getDataUrl(zhuce_EditText_name);


                }else {
                    Toast.makeText(this,"手机号有误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zhuce_but_zhuce:
               boolean mobile = VerifyUtil.isMobile(zhuce_EditText_name.getText().toString());
                boolean b = VerifyUtil.verifyLength(zhuce_password.getText().toString());
                //手机号
                String s = zhuce_EditText_name.getText().toString();
                //密码
                String password1 = zhuce_password.getText().toString();
                //确认密码
                String password2 = zhuce_password2.getText().toString();
                //真实姓名
                String name1 = zhuce_name.getText().toString();

                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2) && !TextUtils.isEmpty(name1)){
                    if (mobile && password1.length() >= 6 && password1.equals(password2) && password1.length() < 17) {
                        //
                        String s1 = zhuce_EditText_name.getText().toString();
                        String s2 = zhuce_password.getText().toString();
                        String s3 = zhuce_EditText_yanzhenma.getText().toString();
                        Log.d("TAG",s1+s2+s3+"----");
                        main_presenter.getDataUrl(s1,s2,s3);
                    }else {
                        Toast.makeText(RegActivity.this, "帐号或密码长度不正确!!", Toast.LENGTH_SHORT).show();
                    }
                    } else {
                    Toast.makeText(RegActivity.this, "帐号或密码不能为空!!", Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }

    @Override
    public void success(final RegBean zhuCeDataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (zhuCeDataBean.getMessage().equals("注册完成")){
                    Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(RegActivity.this,"注册失败--"+zhuCeDataBean.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
