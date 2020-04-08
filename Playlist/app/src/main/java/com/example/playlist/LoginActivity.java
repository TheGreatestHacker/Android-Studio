package com.example.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // Field variables declared below
    EditText username, password;
    Button loginButton;
    int incorrectTries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // comment out the code below to skip the login screen
        /*
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
        */

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        loginButton = (Button)findViewById(R.id.button);

        //set a click listener for the login button
        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //hardcoded values for the user. Change it as needed.
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("password")){
                    // Successful login. Display toast message and open next screen/intent
                    Toast.makeText(getApplicationContext(), "Success! Redirecting...", Toast.LENGTH_SHORT).show();
                    // intent code block to start main activity below
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                }else{
                    //incorrect login. Display a toast message and keep track of tries.
                    //if maximum amount of tries is exceeded, disable login button
                    incorrectTries++;
                    Toast.makeText(getApplicationContext(), "Wrong Credentials. " + (5-incorrectTries) + " remaining!", Toast.LENGTH_SHORT).show();
                    if(incorrectTries == 5){
                        loginButton.setEnabled(false);
                    }
                } //end if/else statement
            } //end method onClick()
        }); //end loginButton onClickListener()

    } //end method onCreate()


}
