package com.wansmd.king.mutao.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by King on 2018/3/16.
 */

public class MainHeaderAdAdapter extends PagerAdapter{
    protected Context context;
    protected List<ImageView> images;

    public MainHeaderAdAdapter(Context context, List<ImageView> images){
        this.context = context;
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public int getCount() {
        return null != images? images.size(): 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }


}
