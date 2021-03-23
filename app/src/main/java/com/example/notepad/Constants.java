package com.example.notepad;

public class Constants {

    public  static final String DATABASE_NAME="NotePad.db";
    public  static final int DATABASE_VERSION=2;
    public  static final String TABLE_NAME="NotePad";

    public  static final String COLUMN_ID="id";
    public  static final String COLUMN_INPUT_TEXT="InputValue";



    public static final String CREATE_TABLE  = " CREATE TABLE "+TABLE_NAME+"("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_INPUT_TEXT+" TEXT "
            +")";

}
