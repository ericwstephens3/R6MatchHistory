package com.example.estephens.r6matchhistory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

public class SQLCommands extends SQLiteOpenHelper implements Serializable {

    public static final String DATABASE_NAME = "r6matchhistory.db";
    public static final String TABLE_NAME = "MATCH_HISTORY";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATE";
    public static final String COL_3 = "MAP";
    public static final String COL_4 = "ATTACK_OPS";
    public static final String COL_5 = "DEFEND_OPS";
    public static final String COL_6 = "WINLOSS";
    public static final String COL_7 = "SCORE";
    public static final String COL_8 = "COMMENTS";
    public static final String COL_9 = "PLAYER_SCORE";


    public SQLCommands(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, MAP TEXT, ATTACK_OPS TEXT, DEFEND_OPS TEXT, WINLOSS TEXT, SCORE TEXT, COMMENTS TEXT, PLAYER_SCORE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private boolean insertData(String date, String map, String attackOps, String defenseOps, String winLoss, String score, String comments, String playerScore)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, date);
        contentValues.put(COL_3, map);
        contentValues.put(COL_4, attackOps);
        contentValues.put(COL_5, defenseOps);
        contentValues.put(COL_6, winLoss);
        contentValues.put(COL_7, score);
        contentValues.put(COL_8, comments);
        contentValues.put(COL_9, playerScore);

        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME, null);
        return result;
    }

    public Cursor getSearchByDate(String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where DATE = " + date, null);
        return result;

    }

    public Cursor getSearchByMap(String map)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where MAP = " + map, null);
        return result;

    }

    public Cursor getSearchByWinLoss(String winLoss)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where WINLOSS = " + winLoss, null);
        return result;

    }

    public Cursor getSearchByID(int ID)
    {
        int i = ID - 10;
        if (i < 0){
            i = 0;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where ID between " + Integer.toString(i) + " and " + Integer.toString(ID), null);
        return result;

    }

    public Cursor getLastID(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select last_insert_rowid() from " + TABLE_NAME, null);
        return result;
    }

    public boolean insert(DatabaseItem item){
        String date = item.getDate();
        String map = item.getMapName();
        String attackOps = item.getAttackOperators().toString();
        String defenseOps = item.getDefenseOperators().toString();
        String winLoss;
        String score = item.getScore();
        String comments = item.getComments();
        String playerScore = item.getPlayerScore();

        if (item.getWinLoss())
            winLoss = "WIN";
        else
            winLoss = "LOSS";

        return insertData(date, map, attackOps, defenseOps, winLoss, score, comments, playerScore);


    }
}
