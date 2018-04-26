package com.example.administrator.kejibeidou.View.Fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.kejibeidou.Model.Bean.PagerDataBean;
import com.example.administrator.kejibeidou.Presenter.News_Presenter;
import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.View.Adapter.MyAdapter;
import com.example.administrator.kejibeidou.View.Adapter.TuiJianAdapter;
import com.example.administrator.kejibeidou.View.Interface.OnItemTouchListner;
import com.example.administrator.kejibeidou.View.Interface.OnMyItemClickListner;
import com.example.administrator.kejibeidou.View.Interface.News_View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */

public class ZiXun_Fragment extends Fragment implements News_View,View.OnClickListener{

    private TabLayout tabLayout;
    private TextView text_add;
    private ViewPager viewPager;
    private View view;
    private View parent;
    private List<String> listMyChannel;
    private TextView text_x;
    private MyAdapter myAdapter;
    private TextView text_edit;
    private PopupWindow popupWindow;
    private TuiJianAdapter tuiJianAdapter;
    //所有的标题
    private List<String> listTuiJianChannel  = new ArrayList<>();;
    //用户关注的集合
    private List<String> numlist;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                fragmentPagerAdapter.notifyDataSetChanged();
            }
        }
    };
    //设配器
    private FragmentPagerAdapter fragmentPagerAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zixun_fragment_layout, container, false);
        initView(view);
        //初始化数据
        initList();
//        //适配器
        initAdapter();

        return view;
    }
    //设配器
    private void initAdapter() {
        //首先是关注新闻的适配器
        fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return listMyChannel.get(position);
            }

            @Override
            public Fragment getItem(int position) {

                    FragmentNews fragmentNews = new FragmentNews();
                    //把数据传过去
                    Bundle bundle = new Bundle();
                    bundle.putString("title", listMyChannel.get(position));
                    fragmentNews.setArguments(bundle);

                    return fragmentNews;


            }

            //Fragment在切换完成后会调用该方法去加载下一个即将展示的Page，至于是哪个Page取决于切换动作
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                    FragmentNews fragmentNews = (FragmentNews) super.instantiateItem(container, position);
                    Bundle bundle = new Bundle();
                    bundle.putString("title", listMyChannel.get(position));
                    fragmentNews.setArguments(bundle);
                return fragmentNews;
            }

            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }

            @Override
            public int getCount() {
                return listMyChannel.size();
            }
        };

        //给ViewPager设置设配器
        viewPager.setAdapter(fragmentPagerAdapter);   //*****报错啦！！！！！
        //关联
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initList() {
        //我的频道数据...tablayout初始数据
        listMyChannel = new ArrayList<>();
        listMyChannel.add("推荐");

    /*    //频道推荐数据
        listTuiJianChannel.add("科技");
        listTuiJianChannel.add("美食");
        listTuiJianChannel.add("养生");
        listTuiJianChannel.add("星座");
        listTuiJianChannel.add("美图");
        listTuiJianChannel.add("辟谣");
        listTuiJianChannel.add("新唱将");
        listTuiJianChannel.add("微头条");
        listTuiJianChannel.add("网法院");
        listTuiJianChannel.add("彩票");
        listTuiJianChannel.add("快乐男声");
        listTuiJianChannel.add("好表演");
        listTuiJianChannel.add("传媒");*/



    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        text_add = (TextView) view.findViewById(R.id.text_add);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        //当点击+号的时候，跳转Activity频道管理
        text_add.setOnClickListener(this);
        News_Presenter pager_presenter=new News_Presenter(this);
        pager_presenter.getDataUrl();
    }

    private boolean flag = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_add:
                //点击+号
                initPopWindown();
                popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);

                break;
            case R.id.text_x:
                popupWindow.dismiss();

                break;
            case R.id.text_edit:

                if (flag) {
                    text_edit.setText("编辑");
                    flag = false;
                    myAdapter.setIfVisible(false);
                } else {
                    text_edit.setText("完成");
                    flag = true;
                    myAdapter.setIfVisible(true);
                }


                break;
        }
    }

    //    点击+号时候
    private void initPopWindown() {
        parent = View.inflate(getActivity(), R.layout.activity_main, null);
        //跳转的频道管理的acticity
        final View popView = View.inflate(getActivity(), R.layout.pop_layout, null);
        //????????????      后边两个参数是宽高
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        //创建一个空白的
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

//        //找到控件
        text_x = popView.findViewById(R.id.text_x);
        text_edit = popView.findViewById(R.id.text_edit);
        RecyclerView recycler_my = popView.findViewById(R.id.recycle_my);
        RecyclerView recycle_tui_jian = popView.findViewById(R.id.recycle_tui_jian);

        text_x.setOnClickListener(this);
        text_edit.setOnClickListener(this);
//
        recycler_my.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        myAdapter = new MyAdapter(listMyChannel, getActivity(), handler);
        recycler_my.setAdapter(myAdapter);
        //触摸管理
        //创建一个触摸条目的帮助类对象...
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchCallBack((OnItemTouchListner) myAdapter));
        itemTouchHelper.attachToRecyclerView(recycler_my);

        recycle_tui_jian.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        tuiJianAdapter = new TuiJianAdapter(listTuiJianChannel, getActivity());
        recycle_tui_jian.setAdapter(tuiJianAdapter);
        myAdapter.setOnItemClickListner(new OnMyItemClickListner() {
            @Override
            public void onItemClick(int position) {
                popupWindow.dismiss();
                viewPager.setCurrentItem(position, false);
            }

            @Override
            public void onItemLongClick(int position) {
                //显示
                text_edit.setText("完成");
                flag = true;
                myAdapter.setIfVisible(true);
            }

            @Override
            public void onItemXclick(int position) {
                listTuiJianChannel.add(0, listMyChannel.get(position));
                tuiJianAdapter.notifyItemInserted(0);

                listMyChannel.remove(position);
                myAdapter.notifyItemRemoved(position);

                viewPager.removeViewAt(position);
                fragmentPagerAdapter.notifyDataSetChanged();


            }
        });
        tuiJianAdapter.setOnItemClickListner(new OnMyItemClickListner() {
            @Override
            public void onItemClick(int position) {

                listMyChannel.add(listMyChannel.size(), listTuiJianChannel.get(position));
                myAdapter.notifyItemInserted(listMyChannel.size());

                listTuiJianChannel.remove(position);
                tuiJianAdapter.notifyItemRemoved(position);


                fragmentPagerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onItemLongClick(int position) {

            }

            @Override
            public void onItemXclick(int position) {

            }
        });
    }

    @Override
    public void success(PagerDataBean pagerDataBean) {
        List<PagerDataBean.NewsTypesBean> newsTypes = pagerDataBean.getNewsTypes();
        for (PagerDataBean.NewsTypesBean newsTypes1:newsTypes ){
            listTuiJianChannel.add(newsTypes1.getName());
        }
    }
}
