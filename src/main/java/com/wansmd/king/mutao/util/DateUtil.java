package com.wansmd.king.mutao.util;

import android.content.Context;
import android.widget.ImageView;

import com.wansmd.king.mutao.entity.Hot;
import com.wansmd.king.mutao.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by King on 2018/3/16.
 */

public class DateUtil {
    public static List<ImageView> getHeaderAddInfo(Context context,int icons[]){
        List<ImageView> dates = new ArrayList<>();
        for(int i = 0; i < icons.length; i++){
            ImageView icon = new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setImageResource(icons[i]);
            dates.add(icon);
        }
        return  dates;
    }
    public  static  List<Menu> getMenus(int icons[],String names[] ){
        List<Menu> menus = new ArrayList<>();
        for(int i = 0; i < icons.length; i++){
            menus.add(new Menu(icons[i], names[i]));
        }
        return  menus;
    }

    public static List<Hot> getHot(int[] img1, String[] str1, String[] str2, String[] str3, String[] str4){
        List<Hot> hot = new ArrayList<>();
        for(int i = 0; i < img1.length; i++){
            hot.add(new Hot(img1[i], str1[i], str2[i], str3[i], str4[i]));
        }
        return hot;
    }
}
