package com.realwork.reol.a3dprint_controller.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.FavoriteInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by reol on 2017/4/19.
 */

public class DefaultListAdapter extends BaseAdapter {

    private List<FavoriteInfoEntity> list;
    private Context context;

    public DefaultListAdapter(List<FavoriteInfoEntity> list, Context context) {
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

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_default,parent,false);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.item_list_default_title);
            holder.tvNumber = (TextView) convertView.findViewById(R.id.item_list_default_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvNumber.setText(list.get(position).getNumber());
        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle;
        TextView tvNumber;
    }
}
