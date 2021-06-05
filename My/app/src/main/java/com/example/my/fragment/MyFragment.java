package com.example.my.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.my.Activity.LoginActivity;
import com.example.my.Activity.Movie_SubscribeActivity;
import com.example.my.Activity.Movie_detailActivity;
import com.example.my.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view =inflater.inflate(R.layout.fragment_my, container, false);


        //退出登录
        TextView textView =view.findViewById(R.id.tv_logout);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });

        //我的订阅
        TextView textSubscribe=view.findViewById(R.id.mySubscribe);
        textSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Movie_SubscribeActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
