package com.sdsmdg.pulkit.callingtext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pulkit on 4/2/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Caller_Details";
    private static final String TABLE_CALLERS= "callers";
    private static final String CALLER_NAME = "name";
    private static final String CALLER_NUMBER="number";
    private static final String CALL_TIME = "time";
    private static final String CALL_TYPE= "type";
    private static final String MESSAGE="message";


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_users = "CREATE TABLE " + TABLE_CALLERS + "(" + CALLER_NAME + " TEXT,"+CALLER_NUMBER +"TEXT," + CALL_TIME + " TEXT," + MESSAGE+"TEXT,"+ CALL_TYPE + " TEXT,)";
        db.execSQL(create_table_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addCaller(CallerDetails cd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CALLER_NAME,cd.caller_name);
        values.put(CALLER_NUMBER,cd.caller_number);
        values.put(CALL_TIME,cd.call_time);
        values.put(CALL_TYPE,cd.call_type);
        values.put(MESSAGE,cd.caller_msg);

        db.insert(TABLE_CALLERS, null, values);
        db.close();
    }
    public List<CallerDetails> getAllCallers() {
        List<CallerDetails> userList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CALLERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                CallerDetails cd = new CallerDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
                userList.add(cd);
            } while (cursor.moveToNext());
        }
        return userList;
    }
}
