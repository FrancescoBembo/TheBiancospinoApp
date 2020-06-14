package com.example.thebiancospinoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button goRegister;
    Button googleLoginBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN = 1;
    private CallbackManager mCallbackManager;
    String presonName;
    private LoginButton facebookLoginBtn;
    private static String TAG = "Facebook Authentication";
    private AccessTokenTracker accessTokenTracker;

    String personPhoto;

//TODO: fix fb login (up to showing fb activity)




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        facebookLoginBtn = findViewById(R.id.fb_login_btn);
        facebookLoginBtn.setPermissions("email","public_profile");
        mCallbackManager = CallbackManager.Factory.create();
        facebookLoginBtn.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "OnSuccess" + loginResult);
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser fUser = mAuth.getCurrentUser();
                if (fUser != null) {
                    updateFbUI (fUser);

                }
                else{
                    updateFbUI(null);

                }
            }
        };


        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (currentAccessToken == null){
                    mAuth.signOut();
                }
            }
        };





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
                Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
                startActivity(intent);
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
                    //Toast.makeText(LoginActivity.this, "Yep", Toast.LENGTH_SHORT).show();
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
            String personPhoto = account.getPhotoUrl().toString();

            Toast.makeText(getBaseContext(), presonName, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
            intent.putExtra("name", presonName);
            intent.putExtra("photo", personPhoto);
            startActivity(intent);



        }
    }





    private void handleFacebookToken(AccessToken token){
        Log.d(TAG, "handleFacebookToken" + token);
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "yes fb", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "sign in with credential: Successful");
                    FirebaseUser fUser = mAuth.getCurrentUser();
                    updateFbUI (fUser);
                }
                else{
                    Toast.makeText(LoginActivity.this, "No fb", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





    private void updateFbUI(FirebaseUser fUser){

        if (fUser != null){
            String presonName = fUser.getDisplayName();
            String personPhoto = fUser.getPhotoUrl().toString();
            Toast.makeText(LoginActivity.this, "yes fb", Toast.LENGTH_SHORT).show();

            //Toast.makeText(getBaseContext(), presonName, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
            intent.putExtra("name", presonName);
            intent.putExtra("photo", personPhoto);
            startActivity(intent);
        }
    }




}
