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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fenlei);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();}





    }
}
