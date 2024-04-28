package com.example.pr12_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String dbname = "student";
    public static final String tablename = "studentDetails";
    public static final String prncol = "studentPRN";
    public static final String namecol = "studentName";
    SQLiteDatabase sqldb;

    public DatabaseHandler(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table studentDetails (studentPRN, studentName)";
        db.execSQL(query);
    }

    public void opendb() {
        sqldb = getWritableDatabase();
    }

    public void insertValue(String prn, String name) {
        ContentValues cv = new ContentValues();
        cv.put(prncol, prn);
        cv.put(namecol, name);
        sqldb.insert(tablename, null, cv);
    }

    public boolean updateValue(String prn, String newName) {
        ContentValues cv = new ContentValues();
        cv.put(namecol, newName);
        int updatedRows = sqldb.update(tablename, cv, prncol + "=?", new String[]{prn});
        return updatedRows > 0;
    }

    public boolean deleteValue(String prn) {
        int deletedRows = sqldb.delete(tablename, prncol + "=?", new String[]{prn});
        return deletedRows > 0;
    }

    public Cursor selectdata() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery("select * from studentDetails",null);
                return cursor;
        //Cursor cursor = db.query(tablename, null, null, null, null, null, null);
        //return cursor;
    }

    public void closedb() {
        sqldb.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
