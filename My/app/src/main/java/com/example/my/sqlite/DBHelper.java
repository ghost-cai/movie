package com.example.my.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.my.pojo.Moive;
import com.example.my.pojo.User;

public class DBHelper extends SQLiteOpenHelper {

    private Context myContext;
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContext=context;
    }

    //创建一个用于创表的接口，创建类时候直接实现这个接口，就方便创建，管理多个表了
    //简而言之，就是可以一个类一个表，比如一个teacher类，我直接在创建的teacher类中实现创表接口并写建表语句就行。
    public static interface TableCreateTnterface{
        public void onCreate(SQLiteDatabase db);
        public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Moive.getInstance().onCreate(db);//创建表Moive
        User.getInstance().onCreate(db);//创建表User
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Moive.getInstance().onUpgrade(db, oldVersion, newVersion);
        User.getInstance().onUpgrade(db, oldVersion, newVersion);
    }


}
