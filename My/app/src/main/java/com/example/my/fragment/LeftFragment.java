package com.example.my.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.my.Adapter.MovieAdapter;
import com.example.my.R;
import com.example.my.pojo.Moive;
import com.example.my.sqlite.SqliteDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    public LeftFragment() {
        // Required empty public constructor
    }


    private String[] data={"爱情","科幻","恐怖"};
    /*定义一个动态数组*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_left, container, false);

        ArrayAdapter<String> adapterL=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,data);
        ListView listViewL=view.findViewById(R.id.lv1);
        listViewL.setAdapter(adapterL);
        listViewL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String classsiyf=data[position];
                SqliteDao dao=new SqliteDao(getActivity(),"Movie");
                List<Moive> moivesList=dao.queryClassify(classsiyf);
                MovieAdapter adapter=new MovieAdapter(getActivity(),moivesList);
                ListView listViewHome=view.findViewById(R.id.lv2);
                listViewHome.setAdapter(adapter);
            }
        });

        return view;
    }
}
