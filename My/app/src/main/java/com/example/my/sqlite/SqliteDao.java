package com.example.my.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.my.pojo.Moive;
import com.example.my.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class SqliteDao {

    private String tableName;
    private Context mContext;
    private DBHelper dbHeloer;
    private SQLiteDatabase db;


    public SqliteDao(Context context, String tableName) {
        this.mContext=context;
        dbHeloer=new DBHelper(context,"Moive.db",null,1);//指定数据库名
        this.tableName=tableName;
    }

    //注册用户
    public void addUser(User user){
        db=dbHeloer.getWritableDatabase();
        if(db.isOpen()){
            String sql="insert into User(uname,pwd) values(?,?)";
            db.execSQL(sql,new Object[]{user.getUname(),user.getPwd()});
            db.close();
        }
    }

    //知用户名查密码
    public User queryUser(User user){
        db=dbHeloer.getWritableDatabase();
        String sql="select * from User where uname=?";
        Cursor cursor = db.rawQuery(sql,new String[]{user.getUname()});
        User user1=new User();                    //不能等于null,否则会报setXXX虚拟方法
        while(cursor.moveToNext()){
            int nameIndex=cursor.getColumnIndex("uname");//确定列的序号，注意和表内名字对应，不然报游标错位
            int pwdIndex=cursor.getColumnIndex("pwd");//确定列的序号
            user1.setUname(cursor.getString(nameIndex));//cursor.getString(nameIndex)根据列号，取出属性
            user1.setPwd(cursor.getString(pwdIndex));
        }
        cursor.close();
        db.close();
        return user1;
    }

    //知电影名查电影
    /*private static final String CREAT_TABLE="create table Movie(MId integer primary key autoincrement," +
            "mName varchar(20)," +
            "director varchar(20)," +
            "money varchar(20)," +
            "score double," +
            "uid varchar(20))";*/
    public Moive queryMoive(String mName){
        db=dbHeloer.getWritableDatabase();
        String sql="select * from Movie where mName=?";
        Cursor cursor = db.rawQuery(sql,new String[]{mName});
        Moive moive=null;
        while(cursor.moveToNext()){
            int midIndex=cursor.getColumnIndex("MId");
            int nameIndex=cursor.getColumnIndex("mName");
            int directorIndex=cursor.getColumnIndex("director");
            int moneyIndex=cursor.getColumnIndex("money");
            int scoreIndex=cursor.getColumnIndex("score");
            int uidIndex=cursor.getColumnIndex("uid");
            int id=cursor.getInt(midIndex);
            String name=cursor.getString(nameIndex);
            String director=cursor.getString(directorIndex);
            String money=cursor.getString(moneyIndex);
            float score=cursor.getFloat(scoreIndex);
            String uid=cursor.getString(uidIndex);
            moive=new Moive(id,name,director,money,score,uid);
        }
        cursor.close();
        db.close();
        return moive;
    }

    //查全部电影信息
    public List<Moive> queryMovieList(){
        db = dbHeloer.getReadableDatabase();//打开数据库
        List<Moive> moivesBeanList = null;//用list存一条条数据
        if (db.isOpen()) {
            moivesBeanList=new ArrayList<>();
            Cursor cursor = db.rawQuery("select * from Movie order by score desc",null);
            while (cursor.moveToNext()) {//确定行
                int MidIndex = cursor.getColumnIndex("MId");//确定列的序号
                int nameIndex = cursor.getColumnIndex("mName");//确定列序号
                int directorIndex = cursor.getColumnIndex("director");//确定列序号
                int moneyIndex = cursor.getColumnIndex("money");//确定列序号
                int scoreIndex = cursor.getColumnIndex("score");//确定列序号
                int uidIndex = cursor.getColumnIndex("uid");//确定列序号

                //表中是int,用getint，表中是String，用String
                Moive moive = new Moive(
                        cursor.getInt(MidIndex),
                        cursor.getString(nameIndex),
                        cursor.getString(directorIndex),
                        cursor.getString(moneyIndex),
                        cursor.getFloat(scoreIndex),
                        cursor.getString(uidIndex)
                );
                moivesBeanList.add(moive);
            }
            cursor.close();
            db.close();
        }
        return moivesBeanList;
    }

}
