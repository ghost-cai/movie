package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.my.fragment.ChatFragment;
import com.example.my.fragment.HomeFragment;
import com.example.my.fragment.MyFragment;
import com.example.my.sqlite.DBHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class MainActivity extends FragmentActivity {


    private Button homeBtn,chatBtn,myBtn,btn1;
    private Fragment homeFra,chatFra,myFra;

    private SQLiteDatabase db1,db2;
    private DBHelper dbHelper,userdbHelper;

    private static final String DB_NAME1 = "test.db";//测试用sqlite studio用，因为有bug，数据库个数》=2才显示，实际不用
    private static final String DB_NAME2 = "user.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //连接sqlite studio时使用
        SQLiteStudioService.instance().start(this);


        setContentView(R.layout.activity_s_q_lite);
        //实例化数据库类，一个对象是一个数据库
        dbHelper=new DBHelper(this,DB_NAME1,null,1);
        userdbHelper=new DBHelper(this,DB_NAME2,null,1);

        //获取数据库访问对象，里面有一些现成方法
        db1=dbHelper.getWritableDatabase();
        db2=userdbHelper.getWritableDatabase();


        initView();

    }



    void initView(){
        homeBtn=this.findViewById(R.id.homeBtn);
        chatBtn=this.findViewById(R.id.chatBtn);
        myBtn=this.findViewById(R.id.myBtn);
    }

    public void myClick(View v){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();//开启事务
        switch (v.getId()){
            case R.id.homeBtn:
                homeFra=new HomeFragment();
                transaction.replace(R.id.fragment_container,homeFra);
                transaction.commit();
                break;
            case R.id.chatBtn:
                chatFra=new ChatFragment();
                transaction.replace(R.id.fragment_container,chatFra);
                transaction.commit();
                break;
            case R.id.myBtn:
               myFra=new MyFragment();
                transaction.replace(R.id.fragment_container,myFra);
                transaction.commit();
                break;
        }
    }

}
