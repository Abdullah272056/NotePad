package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button saveButton;
    DataBaseHelper dataBaseHelper;
    List<MyDataType> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view finding
        editText=findViewById(R.id.editTextId);
        saveButton=findViewById(R.id.saveButtonId);
        dataBaseHelper=new DataBaseHelper(MainActivity.this);
        dataBaseHelper.getWritableDatabase();


        // call loadData method
        loadData();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataList.size()>0){

                }else {
                    String  inputValue=editText.getText().toString();
                    long id=dataBaseHelper.insertData(new MyDataType(inputValue));
                    if (id>0){
                        Toast.makeText(MainActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });





    }


    // create load data for my Save data show in  editText
    private void loadData() {
        dataList  = new ArrayList<>();
        dataList = dataBaseHelper.getAllNotes();

        if (dataList.size() > 0){
            editText.setText(dataList.get(0).getInputValue());

        }else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }


}