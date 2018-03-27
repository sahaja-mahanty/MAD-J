package com.project.mad.fincheck;

/**
 * Created by SAHAJA on 27-03-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(DB.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DB.TABLE_NAME);


        // Create tables again
        onCreate(db);
    }

    public List<DB> getAllNotes() {
        List<DB> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DB.TABLE_NAME + " ORDER BY " +
                DB.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DB note = new DB();
                note.setId(cursor.getInt(cursor.getColumnIndex(DB.COLUMN_ID)));
                note.setFood(cursor.getString(cursor.getColumnIndex(DB.COLUMN_FOOD)));
                note.setEdu(cursor.getString(cursor.getColumnIndex(DB.COLUMN_EDU)));
                note.setHealth(cursor.getString(cursor.getColumnIndex(DB.COLUMN_HEALTH)));
                note.setMisc(cursor.getString(cursor.getColumnIndex(DB.COLUMN_MISC)));
                note.setShop(cursor.getString(cursor.getColumnIndex(DB.COLUMN_SHOP)));
                note.setTravel(cursor.getString(cursor.getColumnIndex(DB.COLUMN_TRAVEL)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(DB.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public void  addVal(String timestamp, String food, String edu, String shop, String misc, String travel, String health){
        List<DB> notes = getAllNotes();
        for(int i=0;i<notes.size();i++){
            if
        }
    }
}
