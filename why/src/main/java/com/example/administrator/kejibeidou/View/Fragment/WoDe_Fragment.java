package com.example.administrator.kejibeidou.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.kejibeidou.R;
import com.example.administrator.kejibeidou.Util.Api;
import com.example.administrator.kejibeidou.Util.RetrofitHelper;
import com.example.administrator.kejibeidou.View.Activity.AccountSettingActivity;
import com.example.administrator.kejibeidou.View.Activity.WoDeActivity;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小慧莹 on 2018/2/27.
 */

public class WoDe_Fragment extends Fragment {

    private LinearLayout wd_linearLayout;
    private LinearLayout mint_shezhi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wode_fragment_layout, container, false);
        wd_linearLayout = view.findViewById(R.id.wd_linearLayout);

        //获取帐号设置的控件
        mint_shezhi = view.findViewById(R.id.mine_setting);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wd_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  startActivity(new Intent(getActivity(), WoDeActivity.class));
            }
        });
      mint_shezhi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getActivity(), AccountSettingActivity.class);
              startActivity(intent);
          }
      });

    }
}
