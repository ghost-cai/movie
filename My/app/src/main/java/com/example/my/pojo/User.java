package com.example.my.pojo;

import android.database.sqlite.SQLiteDatabase;

import com.example.my.sqlite.DBHelper;

public class User implements DBHelper.TableCreateTnterface
{

    private String uid;
    private String uname;
    private String pwd;

    public User() {
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "UId='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUId() {
        return uid;
    }

    public void setUId(String UId) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //返回表的实例创建于更新
    private static User user=new User();
    public static User getInstance(){
        return User.user;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="create table User(uid integer primary key autoincrement," +
                "uname varchar(20)," +
                "pwd varchar(20))";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<newVersion){
            String sql="drop table if exists User";
            db.execSQL(sql);
            this.onCreate(db);
        }
    }

}
