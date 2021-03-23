package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button saveButton;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view finding
        editText=findViewById(R.id.editTextId);
        saveButton=findViewById(R.id.saveButtonId);


        dataBaseHelper=new DataBaseHelper(MainActivity.this);
        dataBaseHelper.getWritableDatabase();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  inputValue=editText.getText().toString();
                long id=dataBaseHelper.insertData(new MyDataType(inputValue));
                if (id>0){
                    Toast.makeText(MainActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}