package com.example.my.fragment;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.my.Activity.FenleiActivity;
import com.example.my.Activity.MainActivity;
import com.example.my.Activity.Movie_detailActivity;
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

    private ListView listHome;
    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,   Object>>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home,null);
        ImageButton imgeBtn1=view.findViewById(R.id.imgeBtn1);
        Button flBtn=view.findViewById(R.id.flBtn);
        //跳转电影详情页面
        imgeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Movie_detailActivity.class);
                //getActivity（）表示获取本fragment，Movie_detailActivity.class是目标activity
//                intent.putExtra("");//跨activity传递信息用。
                startActivity(intent);
            }
        });

        //跳转分类搜索页面
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
        List<Moive> moivesList=dao.queryMovieList();
                /*在数组中存放数据*/
        for(int i=0;i<moivesList.size();i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.pic_haishanggangqinshi);//加入图片
            map.put("ItemName", moivesList.get(i).getmName());//加入电影名
            map.put("ItemScore", moivesList.get(i).getScore());//加入评分
            listItem.add(map);
        }

        SimpleAdapter adapterR=new SimpleAdapter(this.getActivity(),listItem,R.layout.item_home_movie,
                new String[]{"ItemImage","ItemName","ItemScore"},new int[]{R.id.imBtenHome,R.id.tvHome,R.id.tv2Homme});
        ListView listViewHome=view.findViewById(R.id.list_home);
        listViewHome.setAdapter(adapterR);
        /*加载监听器*/
//        listViewHome.setOnItemClickListener((AdapterView.OnItemClickListener)this);



        return view;
    }

    void initView(View view){
        listHome=view.findViewById(R.id.list_home);
    }

}


