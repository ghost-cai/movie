package com.example.my.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.my.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    public LeftFragment() {
        // Required empty public constructor
    }


    private String[] data={"爱情","科幻","动作","西部","恐怖","戏剧"};
    /*定义一个动态数组*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_left, container, false);

        ArrayAdapter<String> adapterL=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,data);
        ListView listViewL=view.findViewById(R.id.lv1);
        listViewL.setAdapter(adapterL);

        return view;
    }
}
