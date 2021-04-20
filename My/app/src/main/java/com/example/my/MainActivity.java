package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.my.fragment.ChatFragment;
import com.example.my.fragment.HomeFragment;
import com.example.my.fragment.MyFragment;

public class MainActivity extends FragmentActivity {


    private Button homeBtn,chatBtn,myBtn,btn1;
    private Fragment homeFra,chatFra,myFra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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
