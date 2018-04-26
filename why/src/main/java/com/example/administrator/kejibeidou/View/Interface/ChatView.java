package com.example.administrator.kejibeidou.View.Interface;

import com.hyphenate.chat.EMMessage;

import java.util.List;

public interface ChatView {

    void onInit(List<EMMessage> emMessageList);

    void onUpdate(int size);
}
