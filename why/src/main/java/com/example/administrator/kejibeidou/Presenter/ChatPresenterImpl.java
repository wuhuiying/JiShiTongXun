package com.example.administrator.kejibeidou.Presenter;

import android.util.Log;

import com.example.administrator.kejibeidou.Presenter.Interface.CallBackListener;
import com.example.administrator.kejibeidou.Presenter.Interface.ChatPresenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.MessageListenerAdapter;
import com.example.administrator.kejibeidou.View.Interface.ChatView;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMContactListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ChatPresenterImpl implements ChatPresenter {

    private ChatView mChatView;
    private  List<EMMessage> mEMMessageList = new ArrayList<>();

    public ChatPresenterImpl(ChatView chatView) {
        mChatView = chatView;
    }

    @Override
    public void initChat(String contact) {
        /**
         * 1. 如果曾经跟contact有聊天过，那么获取最多最近的20条聊天记录，然后展示到View层
         * 2. 如果没有聊天过，返回一个空的List
         * 提示:消息的获取等等方法都在环信SDK中封装了,我们直接从环信中取数据即可
         */
        updateChatData(contact);

        //View接口对象,获取数据更新UI
        mChatView.onInit(mEMMessageList);


    }

    @Override
    public void  updateData(String username) {
        updateChatData(username);
        mChatView.onUpdate(mEMMessageList.size());
    }

    @Override
    public void sendMessage( String msg,  String username ) {
        final EMMessage emMessage = EMMessage.createTxtSendMessage(msg,username);
        emMessage.setStatus(EMMessage.Status.INPROGRESS);
        mEMMessageList.add(emMessage);
        mChatView.onUpdate(mEMMessageList.size());
        emMessage.setMessageStatusCallback(new CallBackListener() {
            @Override
            public void onMainSuccess() {
                mChatView.onUpdate(mEMMessageList.size());

            }
            @Override
            public void onMainError(int i, String s) {
                mChatView.onUpdate(mEMMessageList.size());
            }
        });

        EMClient.getInstance().chatManager().sendMessage(emMessage);

    }
    //更新聊天的数据
    private void updateChatData(String contact) {
        //从环信SDK的本地数据库中拿消息
        EMConversation conversation = EMClient.getInstance().chatManager().getConversation(contact);
        //判断对象是否为空,看之前是否聊过天
        if (conversation != null) {
            //需要将所有的未读消息标记为已读
            conversation.markAllMessagesAsRead();

            //曾经有聊天过
            //那么获取最多最近的20条聊天记录，然后展示到View层
            //获取最后一条消息
            EMMessage lastMessage = conversation.getLastMessage();
            //获取最后一条消息之前的19条（最多）
            int count = 19;
            if (mEMMessageList.size()>=19){
                count = mEMMessageList.size();
            }
            //参数:   1.是消息的ID    2.拿消息的数量(除了当前的一条,也就是如果需要20条,数量为int 19即可)
            List<EMMessage> messageList = conversation.loadMoreMsgFromDB(lastMessage.getMsgId(), count);
            Collections.reverse(messageList);
            //先把集合清空
            mEMMessageList.clear();
            mEMMessageList.add(lastMessage);
            mEMMessageList.addAll(messageList);

            Collections.reverse(mEMMessageList);
        } else {
            mEMMessageList.clear();
        }
    }


}