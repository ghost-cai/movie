package com.example.my.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;




public class SQLiteActivity extends AppCompatActivity {

//    private SQLiteDatabase db;
//    private DBHelper dbHelper,userdbHelper;
//
//    private static final String DB_NAME1 = "test.db";//测试用sqlite studio用，因为有bug，数据库个数》=2才显示，实际不用
//    private static final String DB_NAME2 = "user.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_s_q_lite);
//        //实例化数据库类，一个对象是一个数据库
//        dbHelper=new DBHelper(this,DB_NAME1,null,1);
//        userdbHelper=new DBHelper(this,DB_NAME2,null,1);
////        dbHelper.getWritableDatabase(); //测试用，所以注释掉
//
//        //获取数据库访问对象，里面有一些现成方法
//        db=userdbHelper.getWritableDatabase();
    }


}
