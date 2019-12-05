package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Password;
    Button btn;


    @Override
    public void onCreate(Bundle savedInstanceState)
        {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);

            Name = findViewById(R.id.t1);
            Password = findViewById(R.id.t2);
            btn=findViewById(R.id.button);



        }
        public void register(View view2)
        {
            Intent intent2=new Intent(this,register.class);
            startActivity(intent2);
        }
        public void loginn(View view) {


            String s1 = Name.getText().toString().trim();
            String s2 = Password.getText().toString().trim();

            if (s1.equals(""))
            {
                Name.setError("Username cannot be empty");
            }
            else if (s2.equals(""))
            {
                Password.setError("Password cannot be empty");
            }
            else
            {
                if (s1.equals("athul"))
                {
                    if (s2.equals("12345"))
                    {
                        Intent intent3 = new Intent(MainActivity.this, second.class);
                        startActivity(intent3);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "incorrect username or pass", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                        Toast.makeText(getApplicationContext(), "incorrect username", Toast.LENGTH_SHORT).show();
                }


            }


        }


}



