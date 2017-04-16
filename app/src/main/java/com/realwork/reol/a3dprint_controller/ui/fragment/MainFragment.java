package com.realwork.reol.a3dprint_controller.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.realwork.reol.a3dprint_controller.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by reol on 2017/4/6.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.rl_no_data)
    RelativeLayout rlNoData;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout srlMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main,container,false);
        ButterKnife.bind(this,view);
        srlMain.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW);
        srlMain.setEnabled(false);
        return view;
    }
}
