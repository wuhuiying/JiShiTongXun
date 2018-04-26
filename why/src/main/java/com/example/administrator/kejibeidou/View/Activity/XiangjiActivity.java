package com.example.administrator.kejibeidou.View.Activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.UploadImgAdapter;

import java.io.File;

public class XiangjiActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUploadHead, btnUploadImg;
    private ImageView ivHead, ivImg;
   private UploadImgAdapter uploadImgAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangji);
        initView();
    }

    private void initView() {
        btnUploadHead = (Button) findViewById(R.id.btn_upload_head);
        btnUploadImg = (Button) findViewById(R.id.btn_upload_img);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        ivImg = (ImageView) findViewById(R.id.iv_img);
        btnUploadHead.setOnClickListener(this);
        btnUploadImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (uploadImgAdapter == null)
            initUploadImgAdapter();
        switch (v.getId()) {
            case R.id.btn_upload_head:
                uploadImgAdapter.withMode(UploadImgAdapter.MODE_HEAD).showDialog();
                break;
            case R.id.btn_upload_img:
                uploadImgAdapter.withMode(UploadImgAdapter.MODE_IMG).showDialog();
                break;
        }

    }

    private void initUploadImgAdapter() {
        uploadImgAdapter = new UploadImgAdapter(XiangjiActivity.this, new UploadImgAdapter.Action2() {
            @Override
            public void call(File file, int mode) {
                if (mode == UploadImgAdapter.MODE_HEAD)
                    ivHead.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                else if (mode == UploadImgAdapter.MODE_IMG)
                    ivImg.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (uploadImgAdapter != null)
            uploadImgAdapter.onActivityResult(requestCode, resultCode, data);
    }

}
