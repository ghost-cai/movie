package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    private CheckBox tvDetial_like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();            //通过getIntent（）方法获得启动获得的Intent  use getIntent() get intet object
        String mName = intent.getStringExtra("name");     //通过getStringExtra（）获得数据  use getStringExtra() get values

        //初始化控件
        intiView();
        //获取电影信息-----------------------------------------------------------------------------
        final SqliteDao dao=new SqliteDao(this,"Movie");
        final Moive moive=dao.queryMoive(mName);
        //电影信息显示到控件------------------------------------------------------------------------------
        showMovie(moive);
        //订阅功能------------------------------------------------------------------------------------
        tvDetial_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dao.updateMovie(moive);
                    tvDetial_like.setText("订阅");
                }
                else{
                    dao.updateMovie2(moive);
                    tvDetial_like.setText("未订阅");
                }
            }
        });




    }






    void intiView(){
        tvDetial_name=this.findViewById(R.id.tvDetial_name);
        tvDetial_people=this.findViewById(R.id.tvDetial_people);
        tvDetial_hot=this.findViewById(R.id.tvDetial_hot);
        tvDetial_score=this.findViewById(R.id.tvDetial_score);
        tvDetial_like=this.findViewById(R.id.tvDetial_like);
        tvDetial_picture=this.findViewById(R.id.imgv_detial);
    }

    /*展示电影*/
    void showMovie(Moive moive){
        tvDetial_name.setText("电影名称："+moive.getmName());
        tvDetial_people.setText("导演："+moive.getDirectorName());
        tvDetial_hot.setText("票房："+moive.getMoney());
        Picasso.with(Movie_detailActivity.this).load(moive.getPictureId()).into(tvDetial_picture);
        String score=String.valueOf(moive.getScore());
        tvDetial_score.setText("评分："+score);
    }
}
