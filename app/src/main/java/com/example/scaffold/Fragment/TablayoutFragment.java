package com.example.scaffold.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scaffold.R;

public class TablayoutFragment extends Fragment {

    private static final String ARG_PARAM = "title";

    private String title;


    public TablayoutFragment() {
        // Required empty public constructor
    }

    public static TablayoutFragment newInstance(String param) {
        TablayoutFragment fragment = new TablayoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tablayout, container, false);
    }
}