package com.project.mad.fincheck;

/**
 * Created by SAHAJA on 27-03-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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
        String selectQuery = "SELECT  * FROM " + DB.TABLE_NAME + " ORDER BY " +
                DB.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

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

        db.close();
        return notes;
    }

    public int addVal(String time, String food, String health, String edu, String shop, String travel, String misc){
//        db.delete("notes", null, null);
        List<DB> notes = getAllNotes();
        SQLiteDatabase db = this.getWritableDatabase();

        int index = -1;
        for(int i=0;i<notes.size();i++){
            if (notes.get(i).getTimestamp().equals(time)) {
                index = i;
                break;
            }
        }
        if (index == -1){
            ContentValues values = new ContentValues();
            values.put(DB.COLUMN_EDU, edu);
            values.put(DB.COLUMN_FOOD, food);
            values.put(DB.COLUMN_HEALTH, health);
            values.put(DB.COLUMN_MISC, misc);
            values.put(DB.COLUMN_SHOP, shop);
            values.put(DB.COLUMN_TRAVEL, travel);
            values.put(DB.COLUMN_TIMESTAMP, time);

            long id = db.insert(DB.TABLE_NAME, null, values);
            db.close();
            Log.d("track","new");
            return 1;
        }
        else{
            ContentValues values = new ContentValues();
            String e = String.valueOf(Integer.parseInt(notes.get(index).getEdu())+Integer.parseInt(edu));
            String h = String.valueOf(Integer.parseInt(notes.get(index).getHealth())+Integer.parseInt(health));
            String f = String.valueOf(Integer.parseInt(notes.get(index).getFood())+Integer.parseInt(food));
            String m = String.valueOf(Integer.parseInt(notes.get(index).getMisc())+Integer.parseInt(misc));
            String s = String.valueOf(Integer.parseInt(notes.get(index).getShop())+Integer.parseInt(shop));
            String t = String.valueOf(Integer.parseInt(notes.get(index).getTravel())+Integer.parseInt(travel));

            values.put(DB.COLUMN_EDU, e);
            values.put(DB.COLUMN_FOOD, f);
            values.put(DB.COLUMN_HEALTH, h);
            values.put(DB.COLUMN_MISC, m);
            values.put(DB.COLUMN_SHOP, s);
            values.put(DB.COLUMN_TRAVEL, t);
            values.put(DB.COLUMN_TIMESTAMP, time);
            db.update(DB.TABLE_NAME, values, DB.COLUMN_ID + " = ?",
                    new String[]{String.valueOf(notes.get(index).getId())});
            Log.d("track","updated");
            db.close();
            return 1;
        }
    }

    public DB getNotesOfDate(String time) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB.TABLE_NAME,
                new String[]{DB.COLUMN_ID, DB.COLUMN_EDU, DB.COLUMN_FOOD, DB.COLUMN_HEALTH, DB.COLUMN_MISC, DB.COLUMN_SHOP, DB.COLUMN_TRAVEL, DB.COLUMN_TIMESTAMP},
                DB.COLUMN_TIMESTAMP + "=?",
                new String[]{String.valueOf(time)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        DB note = new DB(
                cursor.getInt(cursor.getColumnIndex(DB.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_FOOD)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_HEALTH)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_EDU)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_SHOP)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_TRAVEL)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_MISC)),
                cursor.getString(cursor.getColumnIndex(DB.COLUMN_TIMESTAMP)));

        cursor.close();

        return note;
    }
}
