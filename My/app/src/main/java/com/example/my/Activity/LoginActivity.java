package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.my.R;
import com.example.my.pojo.User;
import com.example.my.utils.StringUtil;
import com.example.my.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity {

    private TextView tv1,tv2;
    private EditText inputMobile,inputpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intiView();


    }

    //绑定控件
    void intiView(){
        tv1=this.findViewById(R.id.toLogin);
        tv2=this.findViewById(R.id.rigister);
        inputMobile=this.findViewById(R.id.inputMobile);
        inputpwd=this.findViewById(R.id.inputpwd);
    }

    public void myClick(View v){
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

        }

    }

}
