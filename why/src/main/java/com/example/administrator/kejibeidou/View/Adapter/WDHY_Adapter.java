package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.WDHYDataBean;
import com.example.administrator.kejibeidou.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 小慧瑩 on 2018/3/9.
 */

public class WDHY_Adapter extends BaseAdapter {
    Context context;
    WDHYDataBean wdhyDataBean;

    public WDHY_Adapter(Context context, WDHYDataBean wdhyDataBean) {
        this.context = context;
        this.wdhyDataBean = wdhyDataBean;
    }

    @Override
    public int getCount() {
        return wdhyDataBean.getResult().size();
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
        ViewHodel viewHodel = null;
        if (view==null){
            viewHodel = new ViewHodel();
            view=View.inflate(context, R.layout.wdhy_adapter_layout,null);
            viewHodel.simpleDraweeView=view.findViewById(R.id.wdhy_adapter_SimpleDraweeView);
            viewHodel.textView=view.findViewById(R.id.wdhy_adapter_TextView);
            view.setTag(viewHodel);
        }
        else {
            viewHodel  = (ViewHodel) view.getTag();

        }
        viewHodel.simpleDraweeView.setImageURI(wdhyDataBean.getResult().get(i).getImg());
        viewHodel.textView.setText(wdhyDataBean.getResult().get(i).getNickName());

        return view;
    }
    class ViewHodel{
        SimpleDraweeView simpleDraweeView;
        TextView textView;
    }
}
