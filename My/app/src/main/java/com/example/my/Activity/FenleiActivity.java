package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.my.Adapter.MovieAdapter;
import com.example.my.R;
import com.example.my.pojo.Moive;
import com.example.my.sqlite.SqliteDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FenleiActivity extends AppCompatActivity {

    private String[] data={"爱情","科幻","恐怖"};
    /*定义一个动态数组*/
    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,   Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fenlei);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();}

        //左----------------------------------------------------------------------------------------
        ArrayAdapter<String> adapterL=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,data);
        ListView listViewL=this.findViewById(R.id.lv1);
        final ListView listViewClassify=this.findViewById(R.id.lv2);

        listViewL.setAdapter(adapterL);


        listViewL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String classsiyf=data[position];
                SqliteDao dao=new SqliteDao(getActivity(),"Movie");
                List<Moive> moivesList=dao.queryClassify(classsiyf);
                MovieAdapter adapter=new MovieAdapter(getActivity(),moivesList);
                listViewClassify.setAdapter(adapter);
            }
        });
        //右----------------------------------------------------------------------------------------
        //分类搜索中的显示电影和点击事件
        SqliteDao dao=new SqliteDao(this.getActivity(),"Movie");
        final List<Moive> moivesList=dao.queryMovieList();

        final MovieAdapter adapter=new MovieAdapter(this.getActivity(),moivesList);
        ListView listViewHome=this.findViewById(R.id.lv2);
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
    }

    private Context getActivity() {
        return FenleiActivity.this;
    }
}
