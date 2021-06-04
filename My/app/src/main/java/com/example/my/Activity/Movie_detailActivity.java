package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.R;
import com.example.my.pojo.Moive;
import com.example.my.sqlite.SqliteDao;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Movie_detailActivity extends AppCompatActivity {

    private TextView tvDetial_name,tvDetial_people,tvDetial_hot,tvDetial_score;
    private ImageView tvDetial_picture;
    void intiView(){
        tvDetial_name=this.findViewById(R.id.tvDetial_name);
        tvDetial_people=this.findViewById(R.id.tvDetial_people);
        tvDetial_hot=this.findViewById(R.id.tvDetial_hot);
        tvDetial_score=this.findViewById(R.id.tvDetial_score);
        tvDetial_picture=this.findViewById(R.id.imgv_detial);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();            //通过getIntent（）方法获得启动获得的Intent  use getIntent() get intet object
        String mName = intent.getStringExtra("name");     //通过getStringExtra（）获得数据  use getStringExtra() get values

        //初始化控件
        intiView();
        //获取电影信息-----------------------------------------------------------------------------
        Moive moive=new Moive();
        SqliteDao dao=new SqliteDao(this,"Movie");
        moive=dao.queryMoive(mName);
        //显示到控件------------------------------------------------------------------------------
        tvDetial_name.setText("电影名称："+moive.getmName());
        tvDetial_people.setText("导演："+moive.getDirectorName());
        tvDetial_hot.setText("票房："+moive.getMoney());
        Picasso.with(Movie_detailActivity.this).load(moive.getPictureId()).into(tvDetial_picture);
        String score=String.valueOf(moive.getScore());
        tvDetial_score.setText("评分："+score);
    }
}
