package com.example.my.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.my.pojo.Moive;
import com.example.my.pojo.User;

public class SqliteDao {

    private String tableName;
    private Context mContext;
    private DBHelper dbHeloer;
    private SQLiteDatabase db;


    public SqliteDao(Context context, String tableName) {
        this.mContext=context;
        dbHeloer=new DBHelper(context,"user.db",null,1);//指定数据库名
        this.tableName=tableName;
    }

    //注册用户
    public void addUser(User user){
        dbHeloer.getWritableDatabase();
        String sql="insert into User(UId,uname,pwd) values(null,?,?)";
        db.execSQL(sql,new Object[]{user.getUname(),user.getPwd()});
        db.close();
    }

    //只用户名查密码
    public User queryUser(User user){
        dbHeloer.getWritableDatabase();
        String sql="select pwd from User where uname=?";
        Cursor cursor = db.rawQuery(sql,new String[]{user.getUname()});
        while(cursor.moveToNext()){
            int nameIndex=cursor.getColumnIndex("uid");//确定列的序号
            int pwdIndex=cursor.getColumnIndex("pwd");//确定列的序号
            user.setUname(cursor.getString(nameIndex));//cursor.getString(nameIndex)根据列号，取出属性
            user.setPwd(cursor.getString(pwdIndex));
        }
        cursor.close();
        db.close();
        return user;
    }

    //知电影名查电影
    /*private static final String CREAT_TABLE="create table Movie(MId integer primary key autoincrement," +
            "mName varchar(20)," +
            "director varchar(20)," +
            "money varchar(20)," +
            "score double," +
            "uid varchar(20))";*/
    public Moive queryMoive(Moive moive){
        dbHeloer.getWritableDatabase();
        String sql="select * from User where uname=?";
        Cursor cursor = db.rawQuery(sql,new String[]{moive.getmName()});
        Moive moive1=null;
        while(cursor.moveToNext()){
            int midIndex=cursor.getColumnIndex("Mid");
            int nameIndex=cursor.getColumnIndex("mName");
            int directorIndex=cursor.getColumnIndex("director");
            int moneyIndex=cursor.getColumnIndex("money");
            int scoreIndex=cursor.getColumnIndex("score");
            int uidIndex=cursor.getColumnIndex("uid");
            String id=cursor.getString(midIndex);
            String name=cursor.getString(nameIndex);
            String director=cursor.getString(directorIndex);
            String money=cursor.getString(moneyIndex);
            float score=cursor.getFloat(scoreIndex);
            String uid=cursor.getString(uidIndex);
            moive1=new Moive(id,name,director,money,score,uid);
        }
        cursor.close();
        db.close();
        return moive1;
    }

}
