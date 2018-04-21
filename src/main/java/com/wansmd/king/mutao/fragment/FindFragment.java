package com.wansmd.king.mutao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wansmd.king.mutao.R;
import com.wansmd.king.mutao.adapter.HotAdapter;
import com.wansmd.king.mutao.adapter.MyMenuAdapter;
import com.wansmd.king.mutao.util.DateUtil;

/**
 * Created by King on 2018/3/15.
 */

public class FindFragment extends Fragment{
    protected RecyclerView recyclerView,recyclerViewSecond;
    //菜单属性
    protected int[] Icons = {R.mipmap.find_main_travel,R.mipmap.find_main_square,R.mipmap.find_main_hotwind,R.mipmap.find_main_way};
    protected String[] menuNames;
    //二级菜单属性
    protected int[] IconsSecond = {R.mipmap.find_channel_parter,R.mipmap.find_chnnel_me,R.mipmap.find_channel_online};
    protected String[] menuSecondNames;
    //进度条
    protected ProgressBar progressBar1,progressBar2;
    protected TextView textViewpk1,textViewpk2,perViewpk1,perViewpk2;
    protected int intpk1,intpk2;
    //hot的RecyclerView
    protected RecyclerView recyclerViewhot;
    protected int[] img1 = {R.mipmap.find_hot_city,R.mipmap.find_hot_home,R.mipmap.find_hot_jiangnan};
    protected String[] hotstr1, hotstr2, hotstr3, hotstr4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 设置菜单
        recyclerView = getView().findViewById(R.id.recycview_find_menu);
        menuNames = getActivity().getResources().getStringArray(R.array.find_menu);
        //设置布局
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MyMenuAdapter menuAdapter = new MyMenuAdapter(getActivity(), DateUtil.getMenus(Icons, menuNames), R.layout.item_find_menu);
        recyclerView.setAdapter(menuAdapter);

        // 设置二级菜单
        recyclerViewSecond = getView().findViewById(R.id.recycview_find_menu_second);
        menuSecondNames = getActivity().getResources().getStringArray(R.array.find_menu_second);
        recyclerViewSecond.setLayoutManager(new GridLayoutManager(getActivity(),3));
        MyMenuAdapter menuSecondAdapter = new MyMenuAdapter(getActivity(),DateUtil.getMenus(IconsSecond,menuSecondNames),R.layout.item_find_menu_second);
        recyclerViewSecond.setAdapter(menuSecondAdapter);
        //进度条
        intpk1 = 36;
        intpk2 = 64;
        progressBar1 = getView().findViewById(R.id.probar_find_pk1);
        progressBar2 = getView().findViewById(R.id.probar_find_pk2);
        progressBar1.setProgress(intpk1);
        progressBar2.setProgress(intpk2);
        perViewpk1 = getView().findViewById(R.id.per_find_pk1);
        perViewpk2 = getView().findViewById(R.id.per_find_pk2);
        //点赞按钮
        ImageView imgbut1 = getView().findViewById(R.id.imgbut_find_pk1);
        ImageView imgbut2 = getView().findViewById(R.id.imgbut_find_pk2);
        textViewpk1 = getView().findViewById(R.id.text2_find_pk1);
        textViewpk2 = getView().findViewById(R.id.text2_find_pk2);
        imgbut1.setOnClickListener(new ImageViewListener());
        imgbut2.setOnClickListener(new ImageViewListener());
        //hot
        recyclerViewhot =getView().findViewById(R.id.hot_find);
        hotstr1 = getActivity().getResources().getStringArray(R.array.find_hot_str1);
        hotstr2 = getActivity().getResources().getStringArray(R.array.find_hot_str2);
        hotstr3 = getActivity().getResources().getStringArray(R.array.find_hot_str3);
        hotstr4 = getActivity().getResources().getStringArray(R.array.find_hot_str4);
        recyclerViewhot.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        HotAdapter hotAdapter = new HotAdapter(getActivity(),DateUtil.getHot(img1,hotstr1,hotstr2,hotstr3,hotstr4),R.layout.item_find_hot);
        recyclerViewhot.setAdapter(hotAdapter);

    }
    class ImageViewListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.imgbut_find_pk1:
                    intpk1++;
                    progressBar1.setProgress(intpk1*100/(intpk1+intpk2));
                    progressBar2.setProgress(intpk2*100/(intpk1+intpk2));
                    perViewpk1.setText(intpk1*100/(intpk1+intpk2)+"%");
                    perViewpk2.setText(100-intpk1*100/(intpk1+intpk2)+"%");
                    textViewpk1.setText(intpk1 + "人喜欢");
                    break;
                case R.id.imgbut_find_pk2:
                    intpk2++;
                    progressBar1.setProgress(intpk1*100/(intpk1+intpk2));
                    progressBar2.setProgress(intpk2*100/(intpk1+intpk2));
                    perViewpk1.setText(intpk1*100/(intpk1+intpk2)+"%");
                    perViewpk2.setText(100-intpk1*100/(intpk1+intpk2)+"%");
                    textViewpk2.setText(intpk2 + "人喜欢");
                    break;
            }
        }
    }

}
