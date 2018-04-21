package com.wansmd.king.mutao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wansmd.king.mutao.R;
import com.wansmd.king.mutao.entity.Menu;
import java.util.List;

/**
 * Created by King on 2018/3/19.
 */

public class MyMenuAdapter extends RecyclerView.Adapter<MyMenuViewholder>{
    protected Context context;
    protected List<Menu> menus;
    protected int layout;
    public MyMenuAdapter(Context context, List<Menu> menus, int layout){
        this.context = context;
        this.menus = menus;
        this.layout = layout;
    }
    @Override
    public MyMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyMenuViewholder(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(MyMenuViewholder holder, int position) {
        holder.imageViewIcon.setImageResource(menus.get(position).icon);
        holder.textViewMenuName.setText(menus.get(position).menuName);
    }

    @Override
    public int getItemCount() {
        return null != menus?menus.size():0;
    }
}
class MyMenuViewholder extends RecyclerView.ViewHolder{
    public ImageView imageViewIcon;
    public TextView textViewMenuName;
    public MyMenuViewholder(View itemView) {
        super(itemView);
        imageViewIcon = itemView.findViewById(R.id.img_menu_icon);
        textViewMenuName = itemView.findViewById(R.id.text_menu_menuName);

    }
}
