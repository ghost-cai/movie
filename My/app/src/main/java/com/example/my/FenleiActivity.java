package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

public class FenleiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fenlei);

    }
}
