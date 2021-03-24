package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
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

        // create object
        dataBaseHelper=new DataBaseHelper(MainActivity.this);
        // get access for read and write
        dataBaseHelper.getWritableDatabase();


        // call loadData method
        loadData();



        // save button's set OnClickListener and call update and insert method call
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String  inputValue=editText.getText().toString();
                if (dataList.size()>0){
                    updateData(inputValue);
                }else {
                    insertData(inputValue);
                }
            }
        });
    }


    // create load data for my Save data show in editText
    private void loadData() {
        dataList  = new ArrayList<>();
        dataList = dataBaseHelper.getAllNotes();

        if (dataList.size() > 0){
            editText.setText(dataList.get(0).getInputValue());

        }else {
            //Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }


    //create insertData method  for new data save data
    private void insertData(String inputValue){
        long id=dataBaseHelper.insertData(new MyDataType(inputValue));
        if (id>0){
            Toast.makeText(MainActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }


    //create update method  for save data change
    private void updateData(String inputValue){
        int status = dataBaseHelper.updateData(new MyDataType(dataList.get(0).getId(),
                inputValue));
        if (status==1){
            Toast.makeText(MainActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

        }
    }


    //  onBackPressed override method call
    // and alert dialog show for data save alert

    @Override
    public void onBackPressed() {
         AlertDialog.Builder alert = new AlertDialog.Builder(
                MainActivity.this);
        alert.setTitle("Save Data ! ");
        alert.setMessage("\n \nDo you want to save data ?\n");

        alert.setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String  inputValue=editText.getText().toString();
                        if (dataList.size()>0){
                            updateData(inputValue);
                        }else {
                            insertData(inputValue);
                        }

                        dialog.dismiss();
                        finish();

                    }
                })
            .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                finish();
                            }
                        });

        final AlertDialog dialog = alert.create();
        dialog.setCancelable(true);
        dialog.show();
    }

}