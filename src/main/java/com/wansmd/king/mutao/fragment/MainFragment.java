package com.wansmd.king.mutao.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wansmd.king.mutao.R;
import com.wansmd.king.mutao.adapter.MainHeaderAdAdapter;
import com.wansmd.king.mutao.adapter.MyMenuAdapter;
import com.wansmd.king.mutao.util.DateUtil;


/**
 * Created by King on 2018/3/15.
 */

public class MainFragment extends Fragment {
    protected ViewPager mVPagerHeaderAd;
    protected RecyclerView recyclerView;
    protected RecyclerView recyclerViewSecond;
    //广告页
    protected int[] icons = {R.mipmap.header_pic_ad1, R.mipmap.header_pic_ad2, R.mipmap.header_pic_ad1};
    //主菜单
    protected int[] menuIcons = {R.mipmap.menu_airport, R.mipmap.menu_hatol, R.mipmap.menu_trav, R.mipmap.menu_nearby,
                                 R.mipmap.menu_ticket, R.mipmap.menu_train, R.mipmap.menu_car, R.mipmap.menu_course};
    protected String[] menuName;
    //二级菜单
    protected int[] menuSecondIcons = {R.mipmap.menu_second_airport,R.mipmap.menu_second_play,
                                        R.mipmap.menu_second_quan,R.mipmap.menu_second_service,
                                        R.mipmap.menu_second_ticket,R.mipmap.menu_second_wifi};
    protected String[] menuSecondName;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        //广告页轮播
        mVPagerHeaderAd = getView().findViewById(R.id.vpager_main_header_ad);
        MainHeaderAdAdapter adapter = new MainHeaderAdAdapter(getActivity(), DateUtil.getHeaderAddInfo(getActivity(), icons));
        @SuppressLint("HandlerLeak") final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1001){
                    //设置Item,如果当前Item为图片的最后一张则减去(图片长度-1)，反之+1,实现循环。
                    mVPagerHeaderAd.setCurrentItem(mVPagerHeaderAd.getCurrentItem() + ((icons.length - 1) != mVPagerHeaderAd.getCurrentItem() ? 1 : -(icons.length - 1)));
                    sendEmptyMessageDelayed(1001,2000);
                }
            }
        };
        handler.sendEmptyMessageDelayed(1001,2000);
        mVPagerHeaderAd.setAdapter(adapter);

        //菜单
        recyclerView = getView().findViewById(R.id.recycview_main_menu);
        menuName = getActivity().getResources().getStringArray(R.array.main_menu);
        //设置布局
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MyMenuAdapter menuAdapter = new MyMenuAdapter(getActivity(),DateUtil.getMenus(menuIcons,menuName),R.layout.item_main_menu);
        recyclerView.setAdapter(menuAdapter);

        //二级菜单
        recyclerViewSecond = getView().findViewById(R.id.recycview_main_menu_second);
        menuSecondName = getActivity().getResources().getStringArray(R.array.main_menu_second);

        recyclerViewSecond.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        MyMenuAdapter menuSecondAdapter = new MyMenuAdapter(getActivity(),DateUtil.getMenus(menuSecondIcons,menuSecondName),R.layout.item_main_menu_second);


        recyclerViewSecond.setAdapter(menuSecondAdapter);

    }
}
