package com.elahi.databaseapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button btnDel;
    EditText etID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        etID=(EditText) findViewById(R.id.ID);
        databaseHelper = new DatabaseHelper(this);
        btnDel=(Button)findViewById(R.id.Delete);
       final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etID.getText().toString().isEmpty()) {
                    builder.setMessage("Do you want To Delete  record with ID=" + etID.getText().toString())
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    int a = 0;
                                    a = databaseHelper.DeleteData(Integer.parseInt(etID.getText().toString()));
                                    if (a > 0) {
                                        Toast.makeText(getApplicationContext(), "Record is Deleted", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Unable to Delete Record", Toast.LENGTH_SHORT).show();
                                    }
                                    etID.setText(null);
                                    etID.findFocus();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    etID.setText(null);
                                    etID.findFocus();
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alter = builder.create();
                    alter.show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Entr ID",Toast.LENGTH_SHORT).show();
                    etID.setText(null);
                    etID.findFocus();

                }
            }
        });
    }
}
