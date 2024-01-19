package com.allcodingtutorial.recyclersqliteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, age;
    Button Insert, View;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        Insert = findViewById(R.id.btnInsert);
        View = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
            }
        });

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata = DB.insertuserdate(nameTXT, emailTXT, ageTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this,"Новая запись внесена", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Новая запись не внесена", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}