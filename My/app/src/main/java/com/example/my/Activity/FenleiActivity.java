package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.my.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FenleiActivity extends AppCompatActivity {

    private String[] data={"爱情","科幻","动作","西部","恐怖","戏剧"};
    /*定义一个动态数组*/

    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,   Object>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fenlei);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();}

        //listview适配器，到时候连接数据库
        ArrayAdapter<String> adapterL=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        ListView listViewL=findViewById(R.id.lv1);
        listViewL.setAdapter(adapterL);

        /*在数组中存放数据*/
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.icon_photo_default);//加入图片
            map.put("ItemName", "电影名");
            map.put("ItemScore", "评分");
            listItem.add(map);
        }
        SimpleAdapter adapterR=new SimpleAdapter(this,listItem,R.layout.item_fragright,
                new String[]{"ItemImage","ItemName","ItemScore"},new int[]{R.id.imgeBtn1,R.id.fragrTV1,R.id.fragrTV2});
        ListView listViewR=findViewById(R.id.lv2);
        listViewR.setAdapter(adapterR);




    }
}
