package com.example.administrator.kejibeidou.View.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kejibeidou.Model.Bean.UserNameDataBean;
import com.example.administrator.kejibeidou.Presenter.ChatPresenterImpl;
import com.example.administrator.kejibeidou.Presenter.Interface.CallBackListener;
import com.example.administrator.kejibeidou.Presenter.UserNamePresenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.ChatAdapter;
import com.example.administrator.kejibeidou.View.Interface.ChatView;
import com.example.administrator.kejibeidou.View.Interface.UserNameView;


import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.widget.EaseTitleBar;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class HaoYouActivity extends AppCompatActivity implements View.OnClickListener,ChatView,UserNameView {

//    private TextView my_name;
//    private RecyclerView my_send_messge;
//    private EditText my_edit_send;
//    private Button my_send_btn;
    private String name;
//    private TextView haoyou_fan;
//    private String s;
    private ChatPresenterImpl mChatPresenter;
    private ChatAdapter mChatAdapter;
    private String userid;
    private String userName;
    private EaseChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hao_you);
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid1");
        name = intent.getStringExtra("name");
        initView();


//new出EaseChatFragment或其子类的实例
        chatFragment = new EaseChatFragment();

        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.container1, chatFragment).commit();

    }


    private void initView() {

//        my_name = (TextView) findViewById(R.id.my_name);
//        my_send_messge = (RecyclerView) findViewById(R.id.my_send_messge);
//        my_edit_send = (EditText) findViewById(R.id.my_edit_send);
//        my_send_btn = (Button) findViewById(R.id.my_send_btn);
//        my_send_btn.setOnClickListener(this);
        UserNamePresenter userNamePresenter = new UserNamePresenter(this);
//        userNamePresenter.getDataUrl(userid);
//        my_name.setText(name);
//        haoyou_fan = (TextView) findViewById(R.id.haoyou_fan);
//        haoyou_fan.setOnClickListener(this);

        mChatPresenter = new ChatPresenterImpl(this);
        mChatPresenter.initChat(name);
        //B.注册EventBus,从消息的监听拿到发送的信息
        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.my_send_btn:
                s = my_edit_send.getText().toString();
                mChatPresenter.sendMessage(s,userid);
                //跳转到发送页面的界面
                my_edit_send.getText().clear();
                break;
            case R.id.haoyou_fan:
               finish();
                break;*/
        }
    }

    //B.当收到信消息的时候进行的逻辑处理
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(EMMessage message){
        //判断当前这个消息是不是正在聊天的用户给我发的,如果是，让ChatPresenter 更新数据
        String from = message.getFrom();//拿到发送的原始地址
        if (from.equals(userid)){
            mChatPresenter.updateData(userid);
        }
    }


    //B.释放EventBus资源
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onInit(List<EMMessage> emMessageList) {
      /*  //初始化RecyclerView
        my_send_messge.setLayoutManager(new LinearLayoutManager(this));
        mChatAdapter = new ChatAdapter(emMessageList);
        my_send_messge.setAdapter(mChatAdapter);
        if (emMessageList.size()!=0){
            my_send_messge.scrollToPosition(emMessageList.size()-1);
        }*/

    }

    @Override
    public void onUpdate(int size) {
        //更新适配器
        mChatAdapter.notifyDataSetChanged();
        //更新完数据,定位到最新一条的消息
      /*  if (size!=0){
            my_send_messge.smoothScrollToPosition(size-1);
        }*/
    }

    @Override
    public void success(UserNameDataBean userNameDataBean) {
        userName = userNameDataBean.getResult().getUserName();

    }



}
