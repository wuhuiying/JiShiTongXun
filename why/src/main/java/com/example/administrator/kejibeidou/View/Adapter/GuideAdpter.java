package com.example.administrator.kejibeidou.View.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.kejibeidou.View.Activity.WelcomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小慧莹 on 2018/3/26.
 */

public class GuideAdpter extends PagerAdapter {


    private WelcomeActivity welcomeActivity;
    private List<ImageView> imageViews;
    private List<Integer> imageIDList;
//    List<Integer> imageIDList=new ArrayList<>();
//    List<ImageView> imageViews=new ArrayList<>();


    public GuideAdpter(List<ImageView> imageViews, List<Integer> imageIDList) {

        this.imageViews = imageViews;
        this.imageIDList = imageIDList;
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }
    /**
     * 判断当前分页是不是view
     * 由于ViewPager里面的分页可以填入Fragment
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    /**
     * 清理内存
     * 从第一页滑动到第二页，此时第一页的内存应该释放
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));//释放滑动过后的前一页
    }
    /**
     * 得到---->暂时是没有用的
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
    /**
     * 初始化分页
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViews.get(position);
        imageView.setImageResource(imageIDList.get(position));
//        ViewGroup.LayoutParams viewLayoutParams = new ViewGroup.LayoutParams
//                (
//
//                );
//        container.addView(imageView,viewLayoutParams);//设置图片的宽高
        return imageView;
    }
}

