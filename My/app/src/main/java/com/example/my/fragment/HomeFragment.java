package com.example.my.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.my.FenleiActivity;
import com.example.my.MainActivity;
import com.example.my.Movie_detailActivity;
import com.example.my.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


//    private ImageButton imgeBtn1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home,null);
        ImageButton imgeBtn1=view.findViewById(R.id.imgeBtn1);
        Button flBtn=view.findViewById(R.id.flBtn);
        imgeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Movie_detailActivity.class);
                //getActivity（）表示获取本fragment，Movie_detailActivity.class是目标activity
//                intent.putExtra("");//跨activity传递信息用。
                startActivity(intent);
            }
        });

        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FenleiActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
//        imgeBtn1=getActivity().findViewById(R.id.imgeBtn1);
//        imgeBtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(HomeFragment.this, Movie_detailActivity.class);//从A跳到B
//                startActivity(intent);
//            }
//        });
//
//        return inflater.inflate(R.layout.fragment_home, container, false);

}


