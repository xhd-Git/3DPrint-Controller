package com.realwork.reol.a3dprint_controller.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.ModelInfoEntity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by reol on 2017/4/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MainViewHolder> {

    private Context context;
    private List<ModelInfoEntity> list;

    private OnRecyclerItemClickListener listener;

    public RecyclerAdapter(Context context, List<ModelInfoEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(View.inflate(context, R.layout.item_recycler,null));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.itemImage.setImageURI(list.get(position).getImgUrl());
        holder.itemTitle.setText(list.get(position).getName());
        holder.itemDescription.setText(list.get(position).getDescription());
        holder.itemSize.setText(list.get(position).getSize());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                listener.onClick(v, position);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Toast.makeText(context, list.get(position).getStlUrl(), Toast.LENGTH_SHORT).show();
                listener.onLongClick(v, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<ModelInfoEntity> newList){
        setList(newList);
        notifyDataSetChanged();
    }

    public void setList(List<ModelInfoEntity> list) {
        this.list = list;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        SimpleDraweeView itemImage;
        TextView itemTitle;
        TextView itemDescription;
        TextView itemSize;

        MainViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.recycler_card);
            itemImage = (SimpleDraweeView) itemView.findViewById(R.id.item_iv);
            itemTitle = (TextView) itemView.findViewById(R.id.item_tv_title);
            itemDescription = (TextView) itemView.findViewById(R.id.item_tv_description);
            itemSize = (TextView) itemView.findViewById(R.id.item_tv_size);
        }

    }

    public void setOnClickListener(OnRecyclerItemClickListener listener){
        this.listener = listener;
    }

    public interface OnRecyclerItemClickListener{
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }
}
