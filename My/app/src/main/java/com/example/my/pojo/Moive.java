package com.example.my.pojo;

import android.database.sqlite.SQLiteDatabase;

import com.example.my.sqlite.DBHelper;

public class Moive implements DBHelper.TableCreateTnterface {
    private String id;
    private String mName;
    private String directorName;
    private  String money;
    private float score;
    private String uid;

    public Moive() {
    }

    public Moive(String id, String mName, String directorName, String money, float score, String uid) {
        this.id = id;
        this.mName = mName;
        this.directorName = directorName;
        this.money = money;
        this.score = score;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Moive{" +
                "id='" + id + '\'' +
                ", mName='" + mName + '\'' +
                ", directorName='" + directorName + '\'' +
                ", money='" + money + '\'' +
                ", score=" + score +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getUId() {
        return uid;
    }

    public void setUId(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }



    //返回表的实例创建于更新
    private static Moive moive=new Moive();
    public static Moive getInstance(){
        return Moive.moive;
    }


    @Override
    public void onCreat(SQLiteDatabase db) {
        String CREAT_TABLE="create table Movie(MId integer primary key autoincrement," +
                "mName varchar(20)," +
                "director varchar(20)," +
                "money varchar(20)," +
                "score double," +
                "uid varchar(20))";
        db.execSQL(CREAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
