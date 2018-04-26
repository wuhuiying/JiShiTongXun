package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.ZhuangTaiDataBean;
import com.example.administrator.kejibeidou.R;

/**
 * Created by Administrator on 2018/3/21.
 */

public class NewFriendAdapter extends BaseAdapter{
    Context context;
    ZhuangTaiDataBean zhuangTaiDataBean;

    public NewFriendAdapter(Context context, ZhuangTaiDataBean zhuangTaiDataBean) {
        this.context = context;
        this.zhuangTaiDataBean = zhuangTaiDataBean;
    }

    @Override
    public int getCount() {
        return zhuangTaiDataBean.getResult().size();
    }

    @Override
    public Object getItem(int i) {
        return  zhuangTaiDataBean.getResult().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoerl viewHoerl;
        if (view==null){
            viewHoerl= new ViewHoerl();
            view=View.inflate(context, R.layout.xingpengyou_adapter_layout,null);
            viewHoerl.textView1=view.findViewById(R.id.xinpengyouadapter_t1);
            viewHoerl.textView2=view.findViewById(R.id.xinpengyouadapter_t2);
            view.setTag(viewHoerl);
        }else {
            viewHoerl = (ViewHoerl) view.getTag();

        }
        viewHoerl.textView1.setText( zhuangTaiDataBean.getResult().get(i).getContent());
        viewHoerl.textView2.setText( zhuangTaiDataBean.getResult().get(i).getNotice());

        return view;
    }
    class ViewHoerl{
     TextView textView1;
     TextView textView2;
    }
}
