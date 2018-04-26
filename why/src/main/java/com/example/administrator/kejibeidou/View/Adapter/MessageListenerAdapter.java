package com.example.administrator.kejibeidou.View.Adapter;

import android.util.Log;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMMessage;

import java.util.List;

/**
 * 收到环信的消息回调
 */
public class MessageListenerAdapter implements EMMessageListener {
    //收到消息的回调
    @Override
    public void onMessageReceived(List<EMMessage> list) {
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> list) {
    }

    @Override
    public void onMessageRead(List<EMMessage> list) {

    }

    @Override
    public void onMessageDelivered(List<EMMessage> list) {

    }

    @Override
    public void onMessageRecalled(List<EMMessage> list) {

    }

    //消息状态发送变化
    @Override
    public void onMessageChanged(EMMessage emMessage, Object o) {
    }
}
