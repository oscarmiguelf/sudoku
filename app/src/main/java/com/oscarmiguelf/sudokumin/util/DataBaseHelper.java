package com.oscarmiguelf.sudokumin.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sudokuDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_GRID = "grid";

    private static final String KEY_ID = "id";
    private static final String KEY_VALUE = "value";
    private static final String KEY_PERMANENT = "permanent";

    private static DataBaseHelper INSTANCE;


    public static synchronized DataBaseHelper getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new DataBaseHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POSTS_TABLE = "CREATE TABLE " + TABLE_GRID +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_VALUE + " TEXT, " +
                KEY_PERMANENT + " TEXT" +
                ")";

        db.execSQL(CREATE_POSTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRID);
            onCreate(db);
        }
    }

    public void saveCell(int id, String value, String permanent) {

        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(KEY_ID, id);
            values.put(KEY_VALUE, value);
            values.put(KEY_PERMANENT, permanent);

            db.insertOrThrow(TABLE_GRID, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("-", "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<Grid.Cell> getInlineGrid() {

        ArrayList<Grid.Cell> cells = new ArrayList<>();
        String SELECT_QUERY =
                String.format("SELECT * FROM %s ",
                        TABLE_GRID);


        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Grid.Cell cell = new Grid.Cell(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_VALUE))));
                    String p = cursor.getString(cursor.getColumnIndex(KEY_PERMANENT));

                    cell.setPermanent(p.equals("P") ? true : false);
                    cells.add(cell);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("-", "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return cells;
    }

    public void deleteGrid() {
        SQLiteDatabase db = getReadableDatabase();
        String whereClause = "1=1";
        db.delete(TABLE_GRID, whereClause, null);
    }

    public void updateCell(int value, int position) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_VALUE, value);

        db.update(TABLE_GRID, cv, KEY_ID + " = " + position, null);
    }
}