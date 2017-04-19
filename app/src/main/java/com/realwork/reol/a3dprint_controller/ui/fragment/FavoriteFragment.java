package com.realwork.reol.a3dprint_controller.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.entity.FavoriteInfoEntity;
import com.realwork.reol.a3dprint_controller.entity.MineFavoriteEntity;
import com.realwork.reol.a3dprint_controller.ui.Adapter.DefaultListAdapter;
import com.realwork.reol.a3dprint_controller.ui.Adapter.MineListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by reol on 2017/4/6.
 */

public class FavoriteFragment extends Fragment {

    @BindView(R.id.list_default)
    ListView listDefault;
    @BindView(R.id.list_mine)
    ListView listMine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_favorite,container,false);
        ButterKnife.bind(this,view);
        final ArrayList<FavoriteInfoEntity> list = FavoriteInfoEntity.getDefaultList();
        DefaultListAdapter adapter = new DefaultListAdapter(list,getContext());
        listDefault.setAdapter(adapter);

        listDefault.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        final ArrayList<MineFavoriteEntity> list2 = new ArrayList<>();
        list2.add(new MineFavoriteEntity());
        listMine.setAdapter(new MineListAdapter(list2,getContext()));
        listMine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), list2.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
