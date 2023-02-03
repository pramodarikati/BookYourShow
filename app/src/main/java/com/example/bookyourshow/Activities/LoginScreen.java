package com.example.bookyourshow.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookyourshow.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;


public class LoginScreen extends AppCompatActivity {

    private static final int RC_SIGN_IN = 99;
    private static final String TAG = "GoogleLogin";
    private Button btnLoginWithEmail, btnLoginWithGoogle;
    private CallbackManager callbackManager;


    private Button emailLogin,skip;
    private EditText phoneNumberLogin;
    private TextView terms, privacy;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

       // FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        initViews();

        emailLogin = findViewById(R.id.btnLoginWithEmail);
        phoneNumberLogin = findViewById(R.id.etLoginWithNumber);
        terms = findViewById(R.id.terms_and_conditions);
        privacy = findViewById(R.id.privacy_policy);
        skip = findViewById(R.id.skip);
        emailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EmailLogin.class));
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
        phoneNumberLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PhonenumberLogin.class));
            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TermsandConditionsActivity.class));
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PrivacyPolicyActivity.class));
            }
        });



    }

    private void initViews() {

        btnLoginWithEmail = findViewById(R.id.btnLoginWithEmail);
        btnLoginWithGoogle = findViewById(R.id.btnLoginWithGoogle);

        btnLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnLoginWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);


    }


}