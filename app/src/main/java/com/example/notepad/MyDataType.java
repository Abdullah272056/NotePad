package com.example.notepad;

import android.content.Context;

public class MyDataType {

    int id;
    String inputValue;

    public MyDataType() {
    }

    public MyDataType(String inputValue) {
        this.inputValue = inputValue;
    }

    public MyDataType(int id, String inputValue) {
        this.id = id;
        this.inputValue = inputValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
