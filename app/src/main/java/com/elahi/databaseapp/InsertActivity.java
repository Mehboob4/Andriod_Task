package com.elahi.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText txtID,txtName,txtCellNo,txtDept,txtEmail;
    Button Insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        databaseHelper = new DatabaseHelper(this);
        Insert=(Button) findViewById(R.id.Insert);
        txtID=(EditText) findViewById(R.id.eTId);
        txtName=(EditText) findViewById(R.id.eTName);
        txtDept=(EditText) findViewById(R.id.eTDept);
        txtCellNo=(EditText) findViewById(R.id.eTCellNo);
        txtEmail=(EditText) findViewById(R.id.eTEmail);
        txtID.findFocus();
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result= databaseHelper.insertData(Integer.parseInt(txtID.getText().toString()),txtName.getText().toString(),txtDept.getText().toString(),txtCellNo.getText().toString(),txtEmail.getText().toString());
                if(result){
                    Toast.makeText(getApplicationContext(), "Record Inserted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Record is Not Inserted",Toast.LENGTH_SHORT).show();
                }
                txtCellNo.setText(null);
                txtDept.setText(null);
                txtName.setText(null);
                txtEmail.setText(null);
                txtID.setText(null);
                txtID.findFocus();
            }
        });
    }
}
