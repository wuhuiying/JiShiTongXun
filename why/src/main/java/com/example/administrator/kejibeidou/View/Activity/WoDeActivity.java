package com.example.administrator.kejibeidou.View.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.administrator.kejibeidou.Model.Bean.WDHYDataBean;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.Util.Api;


import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.example.administrator.kejibeidou.Util.UploadUtil;
import com.example.administrator.kejibeidou.View.Adapter.UploadImgAdapter;
import com.google.gson.Gson;
import com.hyphenate.util.ImageUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WoDeActivity extends AppCompatActivity implements UploadUtil.OnUploadProcessListener,View.OnClickListener{
    private static final int UPLOAD_FILE_DONE = 4;
    private static final int UPLOAD_IN_PROCESS =5;
    private static final int UPLOAD_INIT_PROCESS =6 ;
    private UploadImgAdapter uploadImgAdapter;


    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;

    //调用照相机返回图片文件
    private File tempFile;
    private ImageView mHeader_iv;
    private ImageView my_return;
    private ImageView wode_SimpleDraweeView;
    private ProgressDialog pd;
private File filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_de);
        initView();

    }

    private void initView() {
        my_return = (ImageView) findViewById(R.id.my_return);
        mHeader_iv = (ImageView) findViewById(R.id.wode_SimpleDraweeView);
        mHeader_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





//                //跳转到相机的页面
//                Intent intent=new Intent(WoDeActivity.this,XiangjiActivity.class);
//                startActivity(intent);

                final String[] arrayFruit = new String[]{"相机", "相册"};
                new AlertDialog.Builder(WoDeActivity.this)
                        .setItems(arrayFruit, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".jpg");

                                switch (i) {
                                    case 0:// 拍照 MediaStore.ACTION_IMAGE_CAPTURE
                                    getCamera();
//                                        getPicFromCamera();
                                        break;
                                    case 1:
                                        //从相册
                                        getPhoto();
//                                        getPicFromAlbm();
                                        break;
                                }
                            }
                        }).create().show();
            }
        });
/**
 * 返回
 */
        my_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void getCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 下面这句指定调用相机拍照后的照片存储的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "hand.jpg")));
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, ALBUM_REQUEST_CODE);
    }
/****
        * 调用系统自带切图工具对图片进行裁剪微信也是
 *   @param uri
 */
    private void photoClip(Uri uri) {
        // 调用系统中自带的图片剪裁
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    /**
     * 上传图片到服务器
     */
    private void toUploadFile() {
        pd = ProgressDialog.show(this, "", "正在上传文件...");
        pd.show();
        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(WoDeActivity.this); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("userId", "");
        uploadUtil.uploadFile(filepath, fileKey, "上传头像的地址", params);
        Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

    }
/*
  **
          * 上传服务器响应回调
 */
    @Override
    public void onUploadDone(int responseCode, String message) {
        //上传完成响应
        pd.dismiss();
        Message msg = Message.obtain();
        msg.what = UPLOAD_FILE_DONE;
        msg.arg1 = responseCode;
        msg.obj = message;
    }

    @Override
    public void onUploadProcess(int uploadSize) {
        //上传中
        Message msg = Message.obtain();
        msg.what = UPLOAD_IN_PROCESS;
        msg.arg1 = uploadSize;
    }

    @Override
    public void initUpload(int fileSize) {
        //准备上传
        Message msg = Message.obtain();
        msg.what = UPLOAD_INIT_PROCESS;
        msg.arg1 = fileSize;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                switch (resultCode) {
                    case -1://-1表示拍照成功
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/hand.jpg");//保存图片
                        if (file.exists()) {
                            //对相机拍照照片进行裁剪
                            photoClip(Uri.fromFile(file));
                        }
                }
                break;

            case ALBUM_REQUEST_CODE://从相册取
                if (data != null) {
                    Uri uri = data.getData();
                    //对相册取出照片进行裁剪
                    photoClip(uri);

                }
                break;
            case CROP_REQUEST_CODE:
                //完成
                if (data != null) {

                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");
                        try {
                            //获得图片路径
                            filepath = UploadUtil.saveFile(photo, Environment.getExternalStorageDirectory().toString(), "hand.jpg");
                            //上传照片
                            toUploadFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //上传完成将照片写入imageview与用户进行交互
                        mHeader_iv.setImageBitmap(photo);
                    }
                }
                break;
        }
    }


}
