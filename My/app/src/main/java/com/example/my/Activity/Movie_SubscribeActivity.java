package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.my.Adapter.MovieAdapter;
import com.example.my.R;
import com.example.my.pojo.Moive;
import com.example.my.sqlite.SqliteDao;
import com.example.my.utils.GlobalUtil;

import java.util.ArrayList;
import java.util.List;

public class Movie_SubscribeActivity extends AppCompatActivity {

    private List<String> listName=new ArrayList<String>();;
    private List<Moive> listMovie=new ArrayList<Moive>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__subscribe);
        final SqliteDao dao=new SqliteDao(this,"Movie");
        listMovie=dao.querySubscribe(GlobalUtil.uName);
        for (int i = 0; i <listMovie.size() ; i++) {
            listName.add(listMovie.get(i).getmName());
        }

        //显示订阅的电影------------------------------------------------------------------------
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Movie_SubscribeActivity.this,R.layout.item_simpletext,listName);
        ListView listViewMname=this.findViewById(R.id.lv_subscribe);
        listViewMname.setAdapter(adapter);

        //点击进入详情页面-------------------------------------------------------------------------
        listViewMname.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=listName.get(position);    //position即为点击的第几条，和list里面的id对应
                Intent intent=new Intent(Movie_SubscribeActivity.this, Movie_detailActivity.class);
                intent.putExtra("name",name);           //传一个电影名去Movie——detail
                startActivity(intent);
            }
        });

    }

    public void myClick(View view) {
    }
}
