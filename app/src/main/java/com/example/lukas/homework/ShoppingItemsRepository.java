package com.example.lukas.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ShoppingItemsRepository {
    private DbHelper dbHelper;

    public ShoppingItemsRepository(Context context){
        this.dbHelper = new DbHelper(context);
    }

    public long insertItem(ShoppingItem item){
        try(SQLiteDatabase database = dbHelper.getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put(DbHelper.SI_TITLE, item.getTitle());
            values.put(DbHelper.SI_DESCRIPTION, item.getDescription());
            return database.insert(DbHelper.SI_TABLE_NAME, null, values);
        }
    }
    public int deleteItem(int id){
        try(SQLiteDatabase database = dbHelper.getWritableDatabase()) {
            String selection = DbHelper.SI_ID + " LIKE ?";
            String[] selectionArgs = {Integer.toString(id)};
            return database.delete(DbHelper.SI_TABLE_NAME, selection, selectionArgs);
        }
    }
    public int updateItem(ShoppingItem item){
        try(SQLiteDatabase database = dbHelper.getWritableDatabase()) {
            ContentValues values = new ContentValues();

            values.put(DbHelper.SI_TITLE, item.getTitle());
            values.put(DbHelper.SI_DESCRIPTION, item.getDescription());

            String selection = DbHelper.SI_ID + " LIKE ?";
            String[] selectionArgs = {Integer.toString(item.getId())};
            return database.update(
                    DbHelper.SI_TABLE_NAME,
                    values,
                    selection,
                    selectionArgs);
        }
    }

    public List<ShoppingItem> getItems() {
        try(SQLiteDatabase database = dbHelper.getReadableDatabase()) {
            List<ShoppingItem> list = new ArrayList<ShoppingItem>();
            String[] cols = new String[]{DbHelper.SI_ID, DbHelper.SI_TITLE, DbHelper.SI_DESCRIPTION};
            try(Cursor cursor = database.query(true, DbHelper.SI_TABLE_NAME, cols, null, null, null, null, null, null)) {
                if (cursor == null)
                    return list;
                if (cursor.moveToFirst()) {
                    while (cursor.isAfterLast() == false) {
                        int id = cursor.getInt(cursor.getColumnIndex(DbHelper.SI_ID));
                        String title = cursor.getString(cursor.getColumnIndex(DbHelper.SI_TITLE));
                        String description = cursor.getString(cursor.getColumnIndex(DbHelper.SI_DESCRIPTION));

                        list.add(new ShoppingItem(id, title, description));
                        cursor.moveToNext();
                    }
                }
            }
            return list;
        }
    }
}