package com.example.administrator.kejibeidou.View.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kejibeidou.Model.Bean.Fragment1_DataBean;
import com.example.administrator.kejibeidou.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小慧莹 on 2018/3/2.
 */

public class Fragment1_Adapter extends RecyclerView.Adapter{
    //定义三种常量  表示三种条目类型
    public static final int TYPE_PULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_THREE_IMAGE = 2;

    Context context;
    Fragment1_DataBean fragment1_dataBean;

    public Fragment1_Adapter(Context context, Fragment1_DataBean fragment1_dataBean) {
        this.context = context;
        this.fragment1_dataBean = fragment1_dataBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建不同的 ViewHolder
        View view;
        //根据viewtype来创建条目

        if (viewType == TYPE_PULL_IMAGE) {
            view =View.inflate(parent.getContext(), R.layout.layout_item1,null);
            return new PullImageHolder(view);
        } else if (viewType == TYPE_RIGHT_IMAGE) {
            view =View.inflate(parent.getContext(),R.layout.layout_item2,null);
            return new RightImageHolder(view);
        } else {
            view =View.inflate(parent.getContext(),R.layout.layout_item3,null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                List<Fragment1_DataBean.ResultBean._$1Bean> beans = fragment1_dataBean.getResult().get_$1();
                break;
            case 1:

                break;
            case 2:
                break;
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    /**
     * 创建三种ViewHolder
     */
    private class PullImageHolder extends RecyclerView.ViewHolder {

        public PullImageHolder(View itemView) {
            super(itemView);
        }
    }

    private class RightImageHolder extends RecyclerView.ViewHolder {

        public RightImageHolder(View itemView) {
            super(itemView);
        }
    }

    private class ThreeImageHolder extends RecyclerView.ViewHolder {

        public ThreeImageHolder(View itemView) {
            super(itemView);
        }
    }
}
