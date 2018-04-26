package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Interface.OnMyItemClickListner;

import java.util.List;

/**
 * Created by Dash on 2017/12/17.
 */
public class TuiJianAdapter extends RecyclerView.Adapter<MyHolder>{
    private Context context;
    private List<String> listMyChannel;
    private OnMyItemClickListner onMyItemClickListner;

    public TuiJianAdapter(List<String> listMyChannel, Context context) {
        this.listMyChannel = listMyChannel;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.my_layout,null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        holder.text_title.setText("＋"+listMyChannel.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                onMyItemClickListner.onItemClick(holder.getLayoutPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMyChannel.size();
    }

    public void setOnItemClickListner(OnMyItemClickListner onMyItemClickListner) {

        this.onMyItemClickListner = onMyItemClickListner;
    }
}
