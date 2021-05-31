package com.example.my.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.my.Activity.FenleiActivity;
import com.example.my.Activity.Movie_detailActivity;
import com.example.my.Adapter.MovieAdapter;
import com.example.my.R;
import com.example.my.pojo.Moive;
import com.example.my.sqlite.SqliteDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home,null);

        //跳转分类搜索页面----------------------------------------------------------------------------
        Button flBtn=view.findViewById(R.id.flBtn);
        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FenleiActivity.class);
                startActivity(intent);
            }
        });


        //主页显示高分电影---------------------------------------------------------------------------

                /*从表中得到movielist*/
        SqliteDao dao=new SqliteDao(this.getActivity(),"Movie");
        final List<Moive> moivesList=dao.queryMovieList();

        final MovieAdapter adapter=new MovieAdapter(this.getActivity(),moivesList);
        ListView listViewHome=view.findViewById(R.id.list_Home);
        listViewHome.setAdapter(adapter);
        /*点击事件*/
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name=moivesList.get(position).getmName();    //position即为点击的第几条，和list里面的id对应
                Intent intent=new Intent(getActivity(), Movie_detailActivity.class);
                intent.putExtra("name",name);           //传一个电影名去Movie——detail
                startActivity(intent);
            }
        });





        return view;
    }


}


