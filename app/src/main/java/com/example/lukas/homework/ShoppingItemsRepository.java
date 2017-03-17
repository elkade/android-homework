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
            values.put(DbHelper.SI_PRICE, item.getPrice());
            values.put(DbHelper.SI_PHOTO_URL, item.getPhotoUrl());
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
            values.put(DbHelper.SI_PRICE, item.getPrice());
            values.put(DbHelper.SI_PHOTO_URL, item.getPhotoUrl());

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
            List<ShoppingItem> list = new ArrayList<>();
            String[] cols = new String[]{DbHelper.SI_ID, DbHelper.SI_TITLE, DbHelper.SI_DESCRIPTION, DbHelper.SI_PRICE, DbHelper.SI_PHOTO_URL};
            try(Cursor cursor = database.query(true, DbHelper.SI_TABLE_NAME, cols, null, null, null, null, null, null)) {
                if (cursor == null)
                    return list;
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {
                        int id = cursor.getInt(cursor.getColumnIndex(DbHelper.SI_ID));
                        String title = cursor.getString(cursor.getColumnIndex(DbHelper.SI_TITLE));
                        String description = cursor.getString(cursor.getColumnIndex(DbHelper.SI_DESCRIPTION));
                        double price = cursor.getDouble(cursor.getColumnIndex(DbHelper.SI_PRICE));
                        String photoUrl = cursor.getString(cursor.getColumnIndex(DbHelper.SI_PHOTO_URL));

                        list.add(new ShoppingItem(id, title, description, price, photoUrl));
                        cursor.moveToNext();
                    }
                }
            }
            return list;
        }
    }
    public ShoppingItem getNext(int id) {
        try(SQLiteDatabase database = dbHelper.getReadableDatabase()) {
            ShoppingItem item = null;
            String[] cols = new String[]{DbHelper.SI_ID, DbHelper.SI_TITLE, DbHelper.SI_DESCRIPTION, DbHelper.SI_PRICE, DbHelper.SI_PHOTO_URL};
            String whereClause = DbHelper.SI_ID + " > ?";
            String[] whereArgs = new String[] {Integer.toString(id)};
            try(Cursor cursor = database.query(true, DbHelper.SI_TABLE_NAME, cols, whereClause, whereArgs, null, null, null, "1")) {
                if (cursor == null)
                    return null;
                if (cursor.moveToFirst()) {
                    if (!cursor.isAfterLast()) {
                        int item_id = cursor.getInt(cursor.getColumnIndex(DbHelper.SI_ID));
                        String title = cursor.getString(cursor.getColumnIndex(DbHelper.SI_TITLE));
                        String description = cursor.getString(cursor.getColumnIndex(DbHelper.SI_DESCRIPTION));
                        double price = cursor.getDouble(cursor.getColumnIndex(DbHelper.SI_PRICE));
                        String photoUrl = cursor.getString(cursor.getColumnIndex(DbHelper.SI_PHOTO_URL));
                        item = new ShoppingItem(item_id, title, description, price, photoUrl);
                        return item;
                    }
                }
            }
            return item;
        }
    }

    public ShoppingItem getItem(int id) {
        try(SQLiteDatabase database = dbHelper.getReadableDatabase()) {
            ShoppingItem item = null;
            String[] cols = new String[]{DbHelper.SI_ID, DbHelper.SI_TITLE, DbHelper.SI_DESCRIPTION, DbHelper.SI_PRICE, DbHelper.SI_PHOTO_URL};
            String whereClause = DbHelper.SI_ID + " = ?";
            String[] whereArgs = new String[] {Integer.toString(id)};
            try(Cursor cursor = database.query(true, DbHelper.SI_TABLE_NAME, cols, whereClause, whereArgs, null, null, null, "1")) {
                if (cursor == null)
                    return null;
                if (cursor.moveToFirst()) {
                    if (!cursor.isAfterLast()) {
                        int item_id = cursor.getInt(cursor.getColumnIndex(DbHelper.SI_ID));
                        String title = cursor.getString(cursor.getColumnIndex(DbHelper.SI_TITLE));
                        String description = cursor.getString(cursor.getColumnIndex(DbHelper.SI_DESCRIPTION));
                        double price = cursor.getDouble(cursor.getColumnIndex(DbHelper.SI_PRICE));
                        String photoUrl = cursor.getString(cursor.getColumnIndex(DbHelper.SI_PHOTO_URL));
                        item = new ShoppingItem(item_id, title, description, price, photoUrl);
                        return item;
                    }
                }
            }
            return item;
        }
    }
}