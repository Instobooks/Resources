package com.example.khatabookact7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLController extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Instobooks.db";
    public static final String TABLE_NAME = "Users";
    String COL_1 = "id";
    String COL_2 = "name";
    String COL_3 = "mobile";
    String COL_4 = "balance";
    String COL_5 = "type_trxn";
    String COL_6 = "date_trxn";


    public SQLController(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table Users " +
                        "(id integer primary key autoincrement, name text, mobile text, balance int, type_trxn int, date_trxn date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(db);
    }

    public boolean insert(String name, String mobile, int bal, int type_trxn, String date_trxn) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, mobile);
        contentValues.put(COL_4, bal);
        contentValues.put(COL_5, type_trxn);
        contentValues.put(COL_6, date_trxn);

        long res = db.insert(TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }
}