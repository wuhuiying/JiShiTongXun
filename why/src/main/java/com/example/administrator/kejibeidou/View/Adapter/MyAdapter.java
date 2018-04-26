package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Interface.OnItemTouchListner;
import com.example.administrator.kejibeidou.View.Interface.OnMyItemClickListner;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements OnItemTouchListner {
    private Handler handler;
    private Context context;
    private List<String> listMyChannel;
    private OnMyItemClickListner onMyItemClickListner;
    private boolean isShow = false;

    public MyAdapter(List<String> listMyChannel, Context context, Handler handler) {
        this.listMyChannel = listMyChannel;
        this.context = context;
        this.handler = handler;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.my_layout, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.text_title.setText(listMyChannel.get(position));


        if (isShow) {
            holder.item_x.setVisibility(View.VISIBLE);
        } else {
            holder.item_x.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMyItemClickListner.onItemClick(holder.getLayoutPosition());
            }
        });

        holder.item_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onMyItemClickListner.onItemXclick(holder.getLayoutPosition());
                listMyChannel.remove(position);
                notifyDataSetChanged();
                handler.sendEmptyMessage(0);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onMyItemClickListner.onItemLongClick(holder.getLayoutPosition());

                return true;
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

    public void setIfVisible(boolean isShow) {
        this.isShow = isShow;

        notifyDataSetChanged();
    }

    @Override
    public void onMove(int oldPosition, int newPosition) {
        //把集合中的两个数据兑换一下位置
        Collections.swap(listMyChannel,oldPosition,newPosition);

        if (newPosition < oldPosition) {
            List<String> subList = listMyChannel.subList(newPosition + 1, oldPosition + 1);
            //向右移一位
            rightStepList(0, subList);
        } else {
            List<String> subList = listMyChannel.subList(oldPosition, newPosition);
            //向左移一位
            leftStepList(0, subList);
        }

        notifyItemMoved(oldPosition,newPosition);

        //通知viewPager刷新
        handler.sendEmptyMessage(0);
    }

    @Override
    public void onSwipe(int adapterPosition) {

    }
    private void reverseList(int start,int end,List list){

        int count = (end+1-start)/2 ;
        for(int i = 0;i< count;i++){
            Object temp = list.get(start+i);
            list.set(start+i,list.get(end-i));
            list.set(end-i,temp);
        }
    }
    private void leftStepList(int step,List list){

        int size = list.size() -1;
        //左移
        reverseList(0,step,list);
        reverseList(step+1,size,list);
        reverseList(0,size,list);

    }
    private void rightStepList(int step,List list){

        int size = list.size() -1;
        //右移
        reverseList(size-step,size,list);
        reverseList(0,size-step-1,list);
        reverseList(0,size,list);
    }
}
