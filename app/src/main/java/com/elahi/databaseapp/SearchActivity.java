package com.elahi.databaseapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    TextView txName,txDept,txID,txEmail,txCellNo;
    RelativeLayout myLayout;
    Button btnSearch;
    EditText txtID;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        databaseHelper = new DatabaseHelper (this);
        txID=(TextView) findViewById(R.id.txtID);
        txName=(TextView) findViewById(R.id.txtName);
        txDept=(TextView) findViewById(R.id.txtDept);
        txEmail=(TextView) findViewById(R.id.txtEmail);
        txCellNo=(TextView) findViewById(R.id.txtCellNo);
        txtID= (EditText) findViewById(R.id.ID);
        btnSearch=(Button) findViewById(R.id.Search);
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!(txtID.getText().toString().isEmpty())) {
                        Cursor crs = databaseHelper.SearchData(Integer.parseInt(txtID.getText().toString()));
                        txID.setText(" ");
                        txDept.setText(" ");
                        txCellNo.setText(" ");
                        txName.setText(" ");
                        txEmail.setText(" ");
                        int ch = crs.getCount();
                        if (ch > 0) {
                            while (crs.moveToNext()) {
                                txID.setText(crs.getString(0));
                                txName.setText(crs.getString(1));
                                txDept.setText(crs.getString(2));
                                txCellNo.setText(crs.getString(3));
                                txEmail.setText(crs.getString(4));

                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Rcord Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Enter ID",Toast.LENGTH_SHORT).show();
                    }
                    txtID.setText(null);
                    txtID.findFocus();
                }
            });
        }

    }

