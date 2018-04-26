package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.kejibeidou.R;

import java.util.List;


/**
 * 通讯录适配器
 */
public class SimpleAdapter extends BaseAdapter {
    Context context;
    List<String> contact;
    List<String> contactId;

    public SimpleAdapter(Context context, List<String> contact, List<String> contactId) {
        this.context = context;
        this.contact = contact;
        this.contactId = contactId;
    }

    @Override
    public int getCount() {
        return contact.size();
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
        viewhplder vh;
        if (view==null){
            view=View.inflate(context, R.layout.contact_list_item,null);
            vh=new viewhplder();
            vh.textView= (TextView) view.findViewById(R.id.tv_name);
            vh.textView1= (TextView) view.findViewById(R.id.tv_phone);
            vh.button=view.findViewById(R.id.btn_add);
            view.setTag(vh);
        }else{
            vh= (viewhplder) view.getTag();
        }
        vh.textView.setText(contact.get(i));
        vh.textView1.setText(contactId.get(i));
        return view;
    }
    class viewhplder{
        TextView textView;
        TextView textView1;
        Button button;
    }
}
