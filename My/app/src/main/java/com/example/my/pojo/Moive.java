package com.example.my.pojo;

import android.database.sqlite.SQLiteDatabase;

import com.example.my.sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class Moive implements DBHelper.TableCreateTnterface {
    private int id;
    private String mName;
    private String directorName;
    private  String money;
    private float score;
    private String pictureId;
    private String classify;
    private String uid;

    public Moive() {
    }

    public Moive(int id, String mName, String directorName, String money, float score, String uid) {
        this.id = id;
        this.mName = mName;
        this.directorName = directorName;
        this.money = money;
        this.score = score;
        this.uid = uid;
    }

    public Moive(int id, String mName, String directorName, String money, float score, String pictureId, String classify, String uid) {
        this.id = id;
        this.mName = mName;
        this.directorName = directorName;
        this.money = money;
        this.score = score;
        this.pictureId = pictureId;
        this.classify = classify;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    //返回表的实例创建于更新
    private static Moive moive=new Moive();
    public static Moive getInstance(){
        return Moive.moive;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREAT_TABLE="create table Movie(MId integer primary key autoincrement," +
                "mName varchar(20)," +
                "director varchar(20)," +
                "money varchar(20)," +
                "score double," +
                "pictureId varchar(300),"+
                "classify varchar(20),"+
                "uid varchar(20))";
        //图片地址-----------------------------------------------------------------------------------
        ArrayList<String> pictureId=new ArrayList<>();
        pictureId.add("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/42a98226cffc1e178e8d4b794190f603738de94c.jpg");//星际穿越
        pictureId.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=518432987,2589849699&fm=26&gp=0.jpg");//泰坦尼克号
        pictureId.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=175380895,3166043909&fm=26&gp=0.jpg");//贞子
        pictureId.add("https://i0.hdslb.com/bfs/archive/6b279f3dca77f68c82e92962855d12ab41959998.png@400w_250h_1c.webp");//第五元素
        pictureId.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3672201476,893513466&fm=26&gp=0.jpg");//回魂夜
        pictureId.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4142559325,2791830738&fm=26&gp=0.jpg");//山楂树之恋

        //插入语句-----------------------------------------------------------------------------------
        ArrayList<String> sqlInsert=new ArrayList<>();
        sqlInsert.add("insert into Movie values(1,'星际穿越','张一','2.3亿',9.8,'"+pictureId.get(0)+"','科幻',1)");
        sqlInsert.add("insert into Movie values(2,'泰坦尼克号','张二','3.3亿',9.7,'"+pictureId.get(1)+"','爱情',1)");
        sqlInsert.add("insert into Movie values(3,'贞子','张三','1.3亿',7.8,'"+pictureId.get(2)+"','恐怖',1)");
        sqlInsert.add("insert into Movie values(4,'第五元素','张四','1.2亿',8.8,'"+pictureId.get(3)+"','科幻',1)");
        sqlInsert.add("insert into Movie values(5,'回魂夜','张五','3000万',7.9,'"+pictureId.get(4)+"','恐怖',1)");
        sqlInsert.add("insert into Movie values(6,'山楂树之恋','张六','1亿',8.5,'"+pictureId.get(5)+"','爱情',1)");
        //执行------------------------------------------------------------------------------------
        db.execSQL(CREAT_TABLE);
        for (int i = 0; i <sqlInsert.size() ; i++) {
            db.execSQL(sqlInsert.get(i));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<newVersion){
            String sql="drop table if exists Movie";
            db.execSQL(sql);
            this.onCreate(db);
        }
    }
}
