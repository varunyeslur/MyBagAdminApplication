package com.example.mybagadminapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mybagadminapplication.Model.Admin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText InputUser, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private String parentDBname = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputUser = (EditText) findViewById(R.id.admin_login);
        InputPassword = (EditText) findViewById(R.id.password_login);

        loadingBar = new ProgressDialog(this);

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoginAdmin();
            }


        });


    }

    private void LoginAdmin()
    {

        String admin = InputUser.getText().toString();
        String password = InputPassword.getText().toString();

        if(TextUtils.isEmpty(admin))
        {
            Toast.makeText(this,"Please Enter Admin User Number", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please Enter Password", Toast.LENGTH_SHORT).show();
        }

        else
        {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait while we validate your Credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(admin, password);
        }

    }

    private void AllowAccessToAccount(final String adminUser, final String password)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                if(dataSnapshot.child(parentDBname).child(adminUser).exists())
                {
                    Admin adminData = dataSnapshot.child(parentDBname).getValue(Admin.class);

                    if(adminData.getAdmin().equals(adminUser))
                    {
                        if(adminData.getPassword().equals(password))
                        {
                            Toast.makeText(MainActivity.this, "Admin Successfully Logged in", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(MainActivity.this, AdminCategoryActivity.class);
                            startActivity(intent);

                        }
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please use valid username", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });



    }
}
