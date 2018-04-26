package com.example.administrator.kejibeidou.View.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kejibeidou.Model.Bean.SouSuoDataBean;
import com.example.administrator.kejibeidou.Presenter.SouSuoPresenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.SouSuoAdapter;
import com.example.administrator.kejibeidou.View.Interface.SouSuoView;

public class SouSuoActivity extends AppCompatActivity implements View.OnClickListener, SouSuoView {

    private EditText sousuo_EditText;
    private TextView sousuo_sousuo;
    private SouSuoPresenter souSuoPresenter;
    private ListView sousuo_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        initView();

    }

    private void initView() {
        sousuo_EditText = (EditText) findViewById(R.id.sousuo_EditText);
        sousuo_sousuo = (TextView) findViewById(R.id.sousuo_sousuo);

        sousuo_sousuo.setOnClickListener(this);
        souSuoPresenter = new SouSuoPresenter(this);
        sousuo_listview = (ListView) findViewById(R.id.sousuo_listview);
    }

    private void submit() {
        // validate
        String EditText = sousuo_EditText.getText().toString().trim();
        if (TextUtils.isEmpty(EditText)) {
            Toast.makeText(this, "QQ号/手机号", Toast.LENGTH_SHORT).show();
            return;
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sousuo_sousuo:
                String sousuo = sousuo_EditText.getText().toString();
                submit();
                souSuoPresenter.getDataUrl(sousuo);
                break;
        }
    }

    @Override
    public void success(SouSuoDataBean souSuoDataBean) {
        SouSuoAdapter souSuoAdapter = new SouSuoAdapter(SouSuoActivity.this,souSuoDataBean);
        sousuo_listview.setAdapter(souSuoAdapter);
    }
}
