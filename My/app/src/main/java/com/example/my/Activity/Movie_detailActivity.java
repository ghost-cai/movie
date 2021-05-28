package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.my.R;

public class Movie_detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();            //通过getIntent（）方法获得启动获得的Intent  use getIntent() get intet object
        String name = intent.getStringExtra("name");     //通过getStringExtra（）获得数据  use getStringExtra() get values
        System.out.println(name);




    }


    public void myClick(View view) {
    }
}
