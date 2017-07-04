package com.example.archimede.ecommerce2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archimede on 26/06/17.
 */

public class EcommerceOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = EcommerceOpenHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 2;
    private static final String CATEGORIES_LIST_TABLE = "category";
    private static final String DATABASE_NAME = "ecommerce_db";
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_IMAGEPATH = "imagePath";
    private static final String[] COLUMNS = {KEY_ID, KEY_TITLE, KEY_SUBTITLE, KEY_IMAGEPATH};
    private static final String CATEGORY_LIST_TABLE_CREATE =
            "CREATE TABLE " + CATEGORIES_LIST_TABLE + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY, " +
                    KEY_TITLE + " VARCHAR(100) NOT NULL, " +
                    KEY_SUBTITLE + " TEXT, " +
                    KEY_IMAGEPATH + " VARCHAR(255) );";


    private static final String PRODUCTS_LIST_TABLE = "products";
    public static final String KEY_TITLE_PRODUCT = "title";
    public static final String KEY_SUBTITLE_PRODUCT = "subtitle";
    public static final String KEY_FOREIGN_KEY = "foreignKey";
    public static final String KEY_IMAGEPATH_PRODUCT = "imagePath";
    private static final String[] COLUMNS_PRODUCT = {KEY_ID, KEY_TITLE, KEY_SUBTITLE, KEY_FOREIGN_KEY, KEY_IMAGEPATH};
    private static final String PRODUCT_LIST_TABLE_CREATE =
            "CREATE TABLE " + PRODUCTS_LIST_TABLE + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY, " +
                    KEY_TITLE + " VARCHAR(100) NOT NULL, " +
                    KEY_SUBTITLE + " TEXT, " +
                    KEY_FOREIGN_KEY + " INTEGER, " +
                    KEY_IMAGEPATH + " VARCHAR(255) );";

    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

    public Category query(int position) {
        String query = "SELECT * FROM " + CATEGORIES_LIST_TABLE +
                " ORDER BY " + KEY_ID + " ASC " +
                "LIMIT " + position + " ,1;";
        Cursor cursor = null;
        Category entry = new Category();
        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, null);
            cursor.moveToFirst();
            entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            entry.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
            entry.setDescription(cursor.getString(cursor.getColumnIndex(KEY_SUBTITLE)));
            entry.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH)));

        } catch (Exception e) {
            Log.d(TAG, "QUERY ERROR! " + e.getMessage());
        } finally {
            if (cursor != null)
                cursor.close();
            return entry;
        }
    }

    public Product getProduct(int productID) {
        String query = "SELECT * FROM " + PRODUCTS_LIST_TABLE + " WHERE " + KEY_ID  + "=?";
                        Cursor cursor = null;
        Product entry = new Product();
        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, new String[]{String.valueOf(productID)});
            cursor.moveToFirst();
            entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            entry.setName(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
            entry.setDesc(cursor.getString(cursor.getColumnIndex(KEY_SUBTITLE)));
            entry.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH)));

        } catch (Exception e) {
            Log.d(TAG, "QUERY ERROR! " + e.getMessage());
        } finally {
            if (cursor != null)
                cursor.close();
            return entry;
        }
    }


    public EcommerceOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void fillDatabaseWithData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        for (int i = 0; i < 10; i++) {
            values.put(KEY_TITLE, "titolo " + i);
            values.put(KEY_SUBTITLE, "sottotitolo " + i);
            values.put(KEY_IMAGEPATH, "http://www.visionealchemica.com/wp-content/uploads/2016/04/9194635-Sorridente-sole-isolato-su-sfondo-bianco-illustrazione-vettoriale-Archivio-Fotografico.jpg");
            db.insert(CATEGORIES_LIST_TABLE, null, values);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CATEGORY_LIST_TABLE_CREATE);
        db.execSQL(PRODUCT_LIST_TABLE_CREATE);
        fillDatabaseWithData(db);
        fillProductwithData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PRODUCT_LIST_TABLE_CREATE);
        onCreate(db);
        fillProductwithData(db);
    }

    private void fillProductwithData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        for (int i = 0; i < 10; i++) {
            values.put(KEY_TITLE_PRODUCT, "titolo " + i);
            values.put(KEY_SUBTITLE_PRODUCT, "sottotitolo " + i);
            values.put(KEY_IMAGEPATH_PRODUCT, "http://www.visionealchemica.com/wp-content/uploads/2016/04/9194635-Sorridente-sole-isolato-su-sfondo-bianco-illustrazione-vettoriale-Archivio-Fotografico.jpg");
            values.put(KEY_FOREIGN_KEY, 1);
            db.insert(PRODUCTS_LIST_TABLE, null, values);
        }
    }


    public List<Category> getAllCategories() {
        String query = "SELECT * FROM " + CATEGORIES_LIST_TABLE;
        Cursor cursor = null;
        List<Category> categorylist = new ArrayList<>();
        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, null);
            while (cursor.moveToNext()) {
                Category entry = new Category();
                entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                entry.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                entry.setDescription(cursor.getString(cursor.getColumnIndex(KEY_SUBTITLE)));
                entry.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH)));
                categorylist.add(entry);
            }
        } catch (Exception e) {
            Log.d(TAG, "QUERY ERROR! " + e.getMessage());
        } finally {
            if (cursor != null)
                cursor.close();
            return categorylist;
        }
    }

    public List<Product> getAllProducts(int categoryID) {
        String query = "SELECT * FROM " + PRODUCTS_LIST_TABLE + " WHERE " + KEY_FOREIGN_KEY + "=?";
        Cursor cursor = null;
        List<Product> productList = new ArrayList<>();
        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, new String[]{String.valueOf(categoryID)});
            while (cursor.moveToNext()) {
                Product entry = new Product();
                entry.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                entry.setName(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                entry.setDesc(cursor.getString(cursor.getColumnIndex(KEY_SUBTITLE)));
                entry.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH)));
                productList.add(entry);
            }
        } catch (Exception e) {
            Log.d(TAG, "QUERY ERROR! " + e.getMessage());
        } finally {
            if (cursor != null)
                cursor.close();
            return productList;
        }
    }
}

