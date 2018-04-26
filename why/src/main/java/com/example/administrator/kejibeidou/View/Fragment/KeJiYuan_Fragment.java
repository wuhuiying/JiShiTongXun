package com.example.administrator.kejibeidou.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Activity.HaoYouActivity;
import com.hyphenate.EMContactListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCmdMessageBody;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/27.
 */

public class KeJiYuan_Fragment extends Fragment {

    private ImageView kejiquan_img1;
    private ImageView kejiquan_img2;
    private ListView kejiquan_lv;
    private EaseContactListFragment contactListFragment;
    private EaseConversationListFragment cf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kejiquan_fragment_layout, container, false);
//        initView(view);
        cf = new EaseConversationListFragment();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fl_contains, cf).commit();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cf.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                // 聊天需要的bundle对象
                Intent intent = new Intent(getActivity(), HaoYouActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(EaseConstant.EXTRA_USER_ID, conversation.getLastMessage().getUserName());
                bundle.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
                intent.putExtras(bundle);
                /**
                 * 从会话列表跳转到聊天页面
                 * 首先要判断最后一条信息是接收还是发送消息
                 * 然后分情况传递头像和昵称
                 *
                 */
                EMMessage lastMessage = conversation.getLastMessage();
              /*  if (lastMessage.direct() == EMMessage.Direct.RECEIVE) {
                    try {
                        intent.putExtra(Utils.FROM_AVATER, lastMessage.getStringAttribute(Utils.FROM_AVATER));
                        intent.putExtra(Utils.FROM_NICHENG, lastMessage.getStringAttribute(Utils.FROM_NICHENG));
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        intent.putExtra(Utils.FROM_AVATER, lastMessage.getStringAttribute(Utils.TO_AVATER));
                        intent.putExtra(Utils.FROM_NICHENG, lastMessage.getStringAttribute(Utils.TO_NICHENG));
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                }*/
                startActivity(intent);
            }
        });
    }


    private void initView(View view) {
//        kejiquan_img1 = (ImageView) view.findViewById(R.id.kejiquan_img1);
//        kejiquan_img2 = (ImageView) view.findViewById(R.id.kejiquan_img2);
//        kejiquan_lv = (ListView) view.findViewById(R.id.kejiquan_lv);

    }

}
