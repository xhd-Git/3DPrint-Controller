package com.realwork.reol.a3dprint_controller.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realwork.reol.a3dprint_controller.R;

/**
 * Created by reol on 2017/4/6.
 */

public class PrintFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_print,container,false);
        return view;
    }
}
