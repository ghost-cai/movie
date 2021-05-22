package com.example.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.my.R;
import com.example.my.pojo.User;
import com.example.my.sqlite.SqliteDao;
import com.example.my.utils.StringUtil;
import com.example.my.utils.ToastUtil;

public class RigisterActivity extends AppCompatActivity {

    private EditText inputMobile,inputpwd,inputpwdRepeat;
    Button btnRigister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);
        intiView();
    }

    void intiView(){
        inputMobile=this.findViewById(R.id.inputMobile);
        inputpwd=this.findViewById(R.id.inputpwd);
        inputpwdRepeat=this.findViewById(R.id.inputpwd_repeat);
    }

    public void rigisterClick(View v){
        SqliteDao dao=new SqliteDao(RigisterActivity.this,"User");//新建dao对象
        switch (v.getId()){
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.rigister2:
                if (StringUtil.isEmpty(inputMobile.getText().toString())) {
                    ToastUtil.showToast(this, "请输入账号");
                    return;
                }

                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(this, "请输入密码");
                    return;
                }

                if (StringUtil.isEmpty(inputpwdRepeat.getText().toString())) {
                    ToastUtil.showToast(this, "请再次输入密码");
                    return;
                }

                if (!inputpwd.getText().toString().equals(inputpwdRepeat.getText().toString())) {
                    ToastUtil.showToast(this, "两次密码不一致");
                    return;
                }

                String name=inputMobile.getText().toString();//取出输入的值
                String pwd=inputpwd.getText().toString();
                User user=new User(name,pwd);//用值new一个对象
                dao.addUser(user);//增加user
                ToastUtil.showToast(this, "注册成功，请登录");
                finish();
                break;
        }
    }
}
