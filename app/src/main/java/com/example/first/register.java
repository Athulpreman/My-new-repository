package com.example.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1,b2;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    Data data=new Data();
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1=findViewById(R.id.usrname);
        e2=findViewById(R.id.mobno);
        e3=findViewById(R.id.mailid);
        e4=findViewById(R.id.pswd);
        b1=findViewById(R.id.resetbtn);
        b2=findViewById(R.id.registerbtn);

        firebaseAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
    }

    public void Reset(View v1)
    {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
    }

    public void Register(View v2) {


        final String s1, s3, s4, s2;
        s1 = e1.getText().toString().trim();
        s2 = e2.getText().toString().trim();
        s3 = e3.getText().toString().trim();
        s4 = e4.getText().toString().trim();


        if (s1.equals("")) {
            e1.setError("Username required");
            return;
        } else if (s2.equals("")) {
            e2.setError("Mob no required");
            return;
        } else if (s3.equals("")) {
            e3.setError("Email required");
            return;
        } else if (s4.equals("")) {
            e4.setError("Password required");
            return;
        } else {

            progressBar.setVisibility(View.VISIBLE);

            mData = FirebaseDatabase.getInstance().getReference().child(s3);

            data.setUsrname(s1);
            data.setPhoneno(s2);
            data.setMailid(s3);
            data.setPswd(s4);


            mData.setValue(data);



            firebaseAuth.createUserWithEmailAndPassword(s3, s4).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {


                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                    else {

                        Toast.makeText(getApplicationContext(), "Error...! " + task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });


        }

    }


}
