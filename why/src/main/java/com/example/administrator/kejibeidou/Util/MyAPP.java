package com.example.administrator.kejibeidou.Util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.administrator.kejibeidou.View.Adapter.MessageListenerAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;


import org.greenrobot.eventbus.EventBus;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class MyAPP extends Application{
    
    /**
     * 默认情况下，只有当应用第一次启动的时候调用一次。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //A.初始化环信SDK
        initHuanxin();
    }

    //A.初始化环信SDK
    private void initHuanxin() {
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证,false
        options.setAcceptInvitationAlways(false);
        /**
         * 下面的代码是为了避免环信被初始化2次
         */
        int pid = android.os.Process.myPid();

        String processAppName = getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(getPackageName())) {
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }
        EaseUI.getInstance().init(this, null);
        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源.
        EMClient.getInstance().setDebugMode(true);
        //E.添加消息的监听
        initMessageListener();
    }

    /**
     * A.拿到进程的名称
     * @param pID
     * @return
     */
    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }

    //E.添加消息的监听
    private void initMessageListener() {
        //使用了Adapter适配器设计模式,因为不用,我们要覆写太多用不到的方法,不利于代码的阅读性
        EMClient.getInstance().chatManager().addMessageListener(new MessageListenerAdapter() {
            @Override
            public void onMessageReceived(List<EMMessage> list) {
                super.onMessageReceived(list);
                if (list != null && list.size() > 0) {
                    EventBus.getDefault().post(list.get(0));
                }
            }
        });
    }
}
