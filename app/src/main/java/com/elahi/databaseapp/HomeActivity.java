package com.elahi.databaseapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    Button btnExit,btnInsert,btnDelete,btnUpdate,btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseHelper=new DatabaseHelper(this);
        Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
        btnInsert=(Button) findViewById(R.id.btInsert);
        btnDelete=(Button) findViewById(R.id.btDelete);
        btnUpdate=(Button) findViewById(R.id.btUpdate);
        btnSearch=(Button) findViewById(R.id.btSearch);
        btnExit=(Button) findViewById(R.id.btSExit);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do you want Exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alter = builder.create();
                alter.show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DeleteIntent= new Intent(HomeActivity.this,DeleteActivity.class);
                Toast.makeText(getApplicationContext(),"Delete Activity",Toast.LENGTH_SHORT).show();
                startActivity(DeleteIntent);

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent UpdateIntent= new Intent(HomeActivity.this,UpdateActivity.class);
                Toast.makeText(getApplicationContext(),"Update Activity",Toast.LENGTH_SHORT).show();
                startActivity(UpdateIntent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SearchIntent= new Intent(HomeActivity.this,SearchActivity.class);
                Toast.makeText(getApplicationContext(),"Search Activity",Toast.LENGTH_SHORT).show();
                startActivity(SearchIntent);
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Insertintent= new Intent(HomeActivity.this,InsertActivity.class);
                Toast.makeText(getApplicationContext(),"Insert Activity",Toast.LENGTH_SHORT).show();
                startActivity(Insertintent);
            }
        });
    }
}
