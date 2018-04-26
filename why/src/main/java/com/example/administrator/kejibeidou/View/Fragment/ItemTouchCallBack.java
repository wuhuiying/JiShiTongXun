package com.example.administrator.kejibeidou.View.Fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.example.administrator.kejibeidou.View.Interface.OnItemTouchListner;


/**
 * @author Dash
 * @date 2017/11/17
 * @description:
 */
public class ItemTouchCallBack extends ItemTouchHelper.Callback {

    private OnItemTouchListner onItemTouchListener;

    public ItemTouchCallBack(OnItemTouchListner  onItemTouchListener) {
        Log.i("---",onItemTouchListener.toString());
        this.onItemTouchListener = onItemTouchListener;
    }

    //获取移动的标记类型,int值...有移动和删除
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT|ItemTouchHelper.UP;
        int swipeFlag = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;

        return makeMovementFlags(dragFlag,swipeFlag);
    }

    //移动的时候...viewHolder现在展示的那个容器,,,target目标容器,拖动之后的容器
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int oldPosition = viewHolder.getLayoutPosition();
        int newPosition = target.getLayoutPosition();

        Log.i("---",onItemTouchListener.toString());
        Log.i("---111",viewHolder.toString());
        //准备移动交换位置.....移动交换位置的操作应该写在适配器中,让适配器去实现一个接口,里面有移动的方法,当前类中持有适配器对象就可以
        onItemTouchListener.onMove(oldPosition,newPosition);

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
       /* Log.i("---",onItemTouchListener.toString());
        Log.i("---111",viewHolder.toString());
        //删除...根据位置删除
        onItemTouchListener.onSwipe(viewHolder.getAdapterPosition());*/
    }
}