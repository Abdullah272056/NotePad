package com.example.notepad;


import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    Context context;

    public DataBaseHelper(@Nullable Context context) {
        super(context, Constants.TABLE_NAME, null, Constants.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
        Toast.makeText(context, "On created is called", Toast.LENGTH_SHORT).show();
    }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

   }

    public long insertData(MyDataType myDataType){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Constants.COLUMN_INPUT_TEXT,myDataType.getInputValue());

        long id=sqLiteDatabase.insert(Constants.TABLE_NAME,null,contentValues);
        return id;

    }


}
