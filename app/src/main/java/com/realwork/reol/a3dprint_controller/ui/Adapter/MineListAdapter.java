package com.realwork.reol.a3dprint_controller.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.MineFavoriteEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by reol on 2017/4/19.
 */

public class MineListAdapter extends BaseAdapter {
    private ArrayList<MineFavoriteEntity> list;
    private Context context;

    public MineListAdapter(ArrayList<MineFavoriteEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_mine,parent,false);
            holder = new ViewHolder();
            holder.iv_icon = (ImageView) convertView.findViewById(R.id.item_list_mine_icon);
            holder.tv_title = (TextView) convertView.findViewById(R.id.item_list_mine_title);
            holder.tv_info = (TextView) convertView.findViewById(R.id.item_list_mine_info);
            holder.iv_more = (ImageView) convertView.findViewById(R.id.item_list_mine_more);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).getIcon() != null){
            holder.iv_icon.setImageBitmap(list.get(position).getIcon());
        }

        if (list.get(position).getTitle() != null){
            holder.tv_title.setText(list.get(position).getTitle());
        }

        if (list.get(position).getInfo() != null){
            holder.tv_info.setText(list.get(position).getInfo());
        }

        holder.iv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "more", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private class ViewHolder{
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_info;
        ImageView iv_more;
    }
}
