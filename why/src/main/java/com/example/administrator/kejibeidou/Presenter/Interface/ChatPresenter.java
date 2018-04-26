package com.example.administrator.kejibeidou.Presenter.Interface;

/**
 * Created by Administrator on 2018/3/12.
 */

public interface ChatPresenter {
    void initChat(String contact);

    void updateData(String username);

    void sendMessage(String username, String msg);

}
