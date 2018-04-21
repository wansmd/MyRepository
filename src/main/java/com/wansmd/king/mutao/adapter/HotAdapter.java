package com.wansmd.king.mutao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wansmd.king.mutao.R;
import com.wansmd.king.mutao.entity.Hot;

import java.util.List;

/**
 * Created by King on 2018/3/20.
 */

public class HotAdapter extends RecyclerView.Adapter<HotViewHolder> {
    protected Context context;
    protected List<Hot> hot;
    protected int layout;

    public HotAdapter(Context context, List<Hot> hot, int layout) {
        this.context = context;
        this.hot = hot;
        this.layout = layout;
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotViewHolder(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(HotViewHolder holder, int position) {
        holder.img1.setImageResource(hot.get(position).img1);
        holder.str1.setText(hot.get(position).str1);
        holder.str2.setText(hot.get(position).str2);
        holder.str3.setText(hot.get(position).str3);
        holder.str4.setText(hot.get(position).str4);
    }

    @Override
    public int getItemCount() {
        return null != hot ? hot.size() : 0;
    }
}

class HotViewHolder extends RecyclerView.ViewHolder {
    public ImageView img1;
    public TextView str1, str2, str3, str4;

    public HotViewHolder(View itemView) {
        super(itemView);
        img1 = itemView.findViewById(R.id.img1_find_hot);
        str1 = itemView.findViewById(R.id.text1_find_hot);
        str2 = itemView.findViewById(R.id.text2_find_hot);
        str3 = itemView.findViewById(R.id.text3_find_hot);
        str4 = itemView.findViewById(R.id.text4_find_hot);
    }
}
