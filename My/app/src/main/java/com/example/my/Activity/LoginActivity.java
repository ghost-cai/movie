package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.my.R;
import com.example.my.pojo.User;
import com.example.my.sqlite.SqliteDao;
import com.example.my.utils.StringUtil;
import com.example.my.utils.ToastUtil;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class LoginActivity extends AppCompatActivity {

    private TextView tv1,tv2;
    private EditText inputMobile,inputpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SQLiteStudioService.instance().start(this);
        intiView();

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtil.isEmpty(inputMobile.getText().toString())) {
                    ToastUtil.showToast(LoginActivity.this, "请输入账号");
                    return;
                }
                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(LoginActivity.this, "请输入密码");
                    return;
                }
                User user=new User();
                SqliteDao daoUser=new SqliteDao(LoginActivity.this,"User");
                user.setUname(inputMobile.getText().toString());
                user.setPwd(inputpwd.getText().toString());
                User user1=daoUser.queryUser(user);//查询数据库
                try {
                    if(user.getPwd().equals(user1.getPwd())){
                        ToastUtil.showToast(LoginActivity.this, "登录成功");
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);//从A跳到B
                        intent.putExtra("uName",user1.getUname());//传递用户参数
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.showToast(LoginActivity.this, "用户名密码错误");
                }
            }
        });

    }

    //绑定控件
    void intiView(){
        tv1=this.findViewById(R.id.toLogin);
        tv2=this.findViewById(R.id.rigister);
        inputMobile=this.findViewById(R.id.inputMobile1);
        inputpwd=this.findViewById(R.id.inputpwd1);
    }

    public void myClick(View v){
        SqliteDao daoUser=new SqliteDao(LoginActivity.this,"User");
        switch (v.getId()){
            case R.id.toLogin:
                if (StringUtil.isEmpty(inputMobile.getText().toString())) {
                    ToastUtil.showToast(this, "请输入账号");
                    return;
                }
                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(this, "请输入密码");
                    return;
                }
                User user=new User();
                user.setUname(inputMobile.getText().toString());
                user.setPwd(inputpwd.getText().toString());
                User user1=daoUser.queryUser(user);//查询数据库
                try {
                    if(user.getPwd().equals(user1.getPwd())){
                        ToastUtil.showToast(this, "登录成功");
                        Intent intent=new Intent(this,MainActivity.class);//从A跳到B
                        intent.putExtra("uName",user1.getUname());//传递用户参数
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.showToast(this, "用户名密码错误");
                }
            case R.id.rigister:
                Intent intent=new Intent(LoginActivity.this,RigisterActivity.class);//从A跳到B
                startActivity(intent);
                break;

        }

    }

}
