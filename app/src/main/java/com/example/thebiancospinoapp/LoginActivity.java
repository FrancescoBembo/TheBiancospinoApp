package com.example.thebiancospinoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button goRegister;
    Button googleLoginBtn;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN = 1;
    private CallbackManager mCallbackManager;
    String presonName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        googleLoginBtn = findViewById(R.id.g_login_btn);

        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                                            .requestIdToken(getString(R.string.default_web_client_id))
                                                            .requestEmail().build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        googleLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });



        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToMainActivityIntent = new Intent(LoginActivity.this, IntroActivity.class);

                startActivity(goToMainActivityIntent);

            }
        });


        //GO TO REGISTER PAGE

        goRegister = findViewById(R.id.goToRegistrationBtn);

        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToRegistrationIntent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(goToRegistrationIntent);

            }
        });


    }


    private void signIn(){

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){

        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            //Toast.makeText(LoginActivity.this, "Singed In Succefully", Toast.LENGTH_SHORT).show();

            FirebaseGoogleAuth(acc);


            //Toast.makeText(getBaseContext(), this.presonName, Toast.LENGTH_SHORT).show();


        }
        catch (ApiException e){
            Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }

    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Yep", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                }
                else{
                    Toast.makeText(LoginActivity.this, "Nope", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }

            }
        });
    }

    private void updateUI(FirebaseUser fUser) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String presonName = account.getDisplayName();
            String presonGivenName = account.getGivenName();
            String presonFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(getBaseContext(), presonName, Toast.LENGTH_SHORT).show();

            Intent goToMainActivityIntent = new Intent(LoginActivity.this, IntroActivity.class);
            goToMainActivityIntent.putExtra("name", presonName);
            startActivity(goToMainActivityIntent);



        }
    }


}
