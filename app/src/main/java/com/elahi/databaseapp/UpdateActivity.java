package com.elahi.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    String[] fields={"Department","Cell No","Email"};
    DatabaseHelper databaseHelper;
    EditText newField,Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        databaseHelper= new DatabaseHelper(this);
        newField=(EditText) findViewById(R.id.newValue);
        Id=(EditText) findViewById(R.id.ID);
        final Spinner spinner;
        spinner = (Spinner) findViewById(R.id.FieldSP);
        spinner.setPrompt("Choose Field To be Updated");
        ArrayAdapter aa= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,fields);
        spinner.setAdapter(aa);
        Button btnUpdate=(Button) findViewById(R.id.update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Object a = (String) spinner.getSelectedItem();
                int ch = 44;
                if(a.equals("Department")){
                    ch=databaseHelper.UpdateData(newField.getText().toString(),Integer.parseInt(Id.getText().toString()),1);
                }
              else if(a.equals("Cell No")){
                    ch=databaseHelper.UpdateData(newField.getText().toString(),Integer.parseInt(Id.getText().toString()),2);
                }
                else if(a.equals("Email")){
                    ch=databaseHelper.UpdateData(newField.getText().toString(),Integer.parseInt(Id.getText().toString()),3);
                }
                if(ch==1){
                    Toast.makeText(getApplicationContext(),"Record is Updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Record is Not Updated",Toast.LENGTH_SHORT).show();
                }
                newField.setText(null);
                Id.setText(null);
                Id.findFocus();
            }
        });
    }
}
