package com.example.my.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.Activity.Movie_detailActivity;
import com.example.my.R;
import com.example.my.pojo.Moive;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mycontext;
    private List<Moive> moiveList;

/*通过构造方法获取一些参数*/
    public MovieAdapter(Context context, List<Moive> moiveList) {
        this.moiveList=moiveList;                   //获取电影
        this.inflater=LayoutInflater.from(context);
        this.mycontext=context;
    }

    //决定显示多少条item
    @Override
    public int getCount() {
        return moiveList==null ? 0:moiveList.size();
    }

    //拿到一条数据
    @Override
    public Object getItem(int position) {

        return moiveList.get(position);
    }

    //获取item的id
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//绑定item-layout与其中的各个控件
        View view=inflater.inflate(R.layout.item_home_movie,null);//获取layout
        Moive movieItem=(Moive) getItem(position);
    /*获取控件*/
        ImageView imageHome=view.findViewById(R.id.imagleHome);
        TextView tv_name=view.findViewById(R.id.tv_name_Home);
        TextView tv_score=view.findViewById(R.id.tv_score_Homme);
    /*把值放控件上显示*/
        Picasso.with(mycontext).load(movieItem.getPictureId()).into(imageHome);
//        imageHome.setBackgroundResource(R.mipmap.pic_haishanggangqinshi);
        tv_name.setText(movieItem.getmName());
        String score=String.valueOf(movieItem.getScore());  //对象中是flaot类型数据，转化成string
        tv_score.setText(score);
        return view;
    }
}
