package com.example.orientationapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TextView t;
EditText et;
Button b1;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.txt1);
        et=findViewById(R.id.editTxt);
        b1=findViewById(R.id.btn1);

 b1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        String etText=et.getText().toString();
         t.setText(etText);

     }
 });

    }

  @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String savedToSave=et.getText().toString();
        outState.putString("saved_state",savedToSave);
        Toast.makeText(this," state Saved"+savedToSave,Toast.LENGTH_SHORT).show();
    }


     @Override
   protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String s1=(String)savedInstanceState.get("saved_state");

        if(s1 == null)
        {
            Toast.makeText(this,"On restorestate No state Saved",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"On restorestate data state Saved"+s1,Toast.LENGTH_SHORT).show();
           t.setText(s1);
           et.setText(s1);
        }
    }


}
