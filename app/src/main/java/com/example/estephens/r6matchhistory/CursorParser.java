package com.example.estephens.r6matchhistory;

import android.database.Cursor;

import java.util.ArrayList;


public class CursorParser {

    private Cursor cursor;
    private ArrayList<DatabaseItem> items = new ArrayList<>();

    public CursorParser(Cursor item){
        this.cursor = item;
        parse();
    }

    private void parse(){
        cursor.moveToFirst();
        do{
            DatabaseItem item = new DatabaseItem();
            item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            item.setDate(cursor.getString(cursor.getColumnIndex("DATE")));
            item.setMapName(cursor.getString(cursor.getColumnIndex("MAP")));
            item.setAttackOperators(cursor.getString(cursor.getColumnIndex("ATTACK_OPS")));
            item.setDefenseOperators(cursor.getString(cursor.getColumnIndex("DEFEND_OPS")));
            item.setwinLoss(cursor.getString(cursor.getColumnIndex("WINLOSS")));
            item.setScore(cursor.getString(cursor.getColumnIndex("SCORE")));
            item.setComments(cursor.getString(cursor.getColumnIndex("COMMENTS")));

            items.add(item);
        }while(cursor.moveToNext());
    }

    public ArrayList<DatabaseItem> getDatabaseItems(){
        return items;
    }

    public Cursor getCursor() {
        return cursor;
    }
}
