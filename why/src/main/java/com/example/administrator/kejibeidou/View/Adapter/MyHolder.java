package com.example.administrator.kejibeidou.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.kejibeidou.R;
/**
 * Created by 小慧莹 on 2017/12/17.
 */
public class MyHolder extends RecyclerView.ViewHolder {

    public TextView text_title;
    public TextView item_x;

    public MyHolder(View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        item_x = itemView.findViewById(R.id.item_x);

    }
}
