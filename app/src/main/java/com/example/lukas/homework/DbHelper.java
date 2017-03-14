package com.example.lukas.homework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ShoppingDb";
    private static final int DATABASE_VERSION = 1;
    public final static String SI_TABLE_NAME = "ShoppingItems";
    public final static String SI_ID = "_id";
    public final static String SI_TITLE = "title";
    public final static String SI_DESCRIPTION = "description";

    private static final String DATABASE_CREATE = String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY, %3$s TEXT, %4$s TEXT)",
            SI_TABLE_NAME, SI_ID, SI_TITLE, SI_DESCRIPTION);

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion) {
        Log.w(DbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}
