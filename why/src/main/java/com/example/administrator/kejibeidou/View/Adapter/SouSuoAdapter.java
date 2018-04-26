package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.SouSuoDataBean;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Activity.SouSuoActivity;

/**
 * Created by Administrator on 2018/3/19.
 */

public class SouSuoAdapter extends BaseAdapter {
    Context context;
    SouSuoDataBean souSuoDataBean;

    public SouSuoAdapter(Context context, SouSuoDataBean souSuoDataBean) {
        this.context = context;
        this.souSuoDataBean = souSuoDataBean;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodel viewHodel;
        if (view==null){
             viewHodel = new ViewHodel();
            view = View.inflate(context, R.layout.sousuo_adapter_layout, null);
            viewHodel.name=view.findViewById(R.id.sousuo_adapter_name);
            viewHodel.phone=view.findViewById(R.id.sousuo_adapter_phone);
            viewHodel.button=view.findViewById(R.id.sousuo_adapter_btn);
            view.setTag(viewHodel);

        }else {
            viewHodel = (ViewHodel) view.getTag();
        }
        viewHodel.phone.setText("账号:"+souSuoDataBean.getResult().getPhone());
        viewHodel.name.setText("昵称:"+souSuoDataBean.getResult().getNickName());
        viewHodel.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
    class ViewHodel{
      TextView phone;

      TextView name;
      Button button;

    }
}
