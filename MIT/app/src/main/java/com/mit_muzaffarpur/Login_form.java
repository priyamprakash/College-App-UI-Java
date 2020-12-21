package com.mit_muzaffarpur;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.mit_muzaffarpur.Bottom.MainActivity;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")

@Keep

public class Login_form extends AppCompatActivity {

    LinearLayout myLayout;
    AnimationDrawable animationDrawable;
    EditText txtEmail, txtPassword;
    Button btn_login;

    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final String TAG = "Login_form";
    private FirebaseAuth firebaseAuth;
    private Button btnSignOut;

    private FirebaseAuth.AuthStateListener authStateListener;
    // AccessTokenTracker accessTokenTracker;
    //private CallbackManager mCallbackManager;
    private TextView textViewUser;
    private ImageView mLogo;
    //private LoginButton loginButton;
    // loginButton.setReadPermissions("email","public_profile");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        //---------------FB LOGIN---------------------

     /*   firebaseAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());

        textViewUser = findViewById(R.id.text_user);
        mLogo = findViewById(R.id.image_logo);
        loginButton = findViewById(R.id.login_button);
        mCallbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "onSuccess" + loginResult);
                handleFacebookToken(loginResult.getAccessToken());
                //startActivity(new Intent(getApplicationContext(),
                  //      HomeActivity.class));//1

            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError" +error);
            }
        });


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();

                if(user!=null)
                {
                    updateUItwo(user);
                    //startActivity(new Intent(getApplicationContext(),
                    //        HomeActivity.class));//2
                }
                else
                {
                    updateUItwo(null);
                }



            }
        };

accessTokenTracker= new AccessTokenTracker() {
    @Override
    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

        if(currentAccessToken == null)
        {
            firebaseAuth.signOut();

        }

    }
};




*///---------------------GOOGLE SIGN IN---------------------------


        signInButton = findViewById(R.id.sign_in_button);
        //noinspection AccessStaticViaInstance
        firebaseAuth = firebaseAuth.getInstance();
        btnSignOut = findViewById(R.id.sign_out_button);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                 .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();

            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(Login_form.this, "You are Logged Out", Toast.LENGTH_SHORT).show();

                btnSignOut.setVisibility(View.INVISIBLE);


            }
        });


        //-------------------------------EMAIL LOGIN------------------------------------


        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.buttonLogin);


        //this is for transition of background


        myLayout = findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        //   animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();


        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login_form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login_form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.length() < 6) {

                    Toast.makeText(Login_form.this, "Password too short", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login_form.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login_form.this, "Wait for few seconds while we" +
                                            " log you in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),
                                            MainActivity.class));


                                } else {
                                    Toast.makeText(Login_form.this, "Login Failed or User not available",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

            }
        });


    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 1) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

                handleSignInResult(task);

            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    public void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            // Google Sign In was successful, authenticate with Firebase
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);

            Toast.makeText(Login_form.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(Objects.requireNonNull(acc));
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } catch (ApiException e) {


            Toast.makeText(Login_form.this, "Signed in unsuccessful", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }


    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(Login_form.this, "Welcome to JUNNON\nJUNNON में आपका स्वागत है", Toast.LENGTH_SHORT).show();


                    // startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                    FirebaseUser fuser = firebaseAuth.getCurrentUser();
                    updateUI(fuser);

                } else {

                    Toast.makeText(Login_form.this, "failed", Toast.LENGTH_SHORT).show();
                    updateUI(null);

                }


            }

        });


    }

    private void updateUI(FirebaseUser fuser) {


        btnSignOut.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        if (account == null) {
            String personName = Objects.requireNonNull(account).getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(Login_form.this, personName + personEmail, Toast.LENGTH_SHORT).show();


        }


    }


    public void sign_upForm(View view) {
        startActivity(new Intent(getApplicationContext(), Signup_form.class));
    }

//-------FORGOT PASSWORD-------


    public void forgot(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");
        //set layout linear layout
        LinearLayout linearLayout = new LinearLayout(this);
        final EditText emailEt = new EditText(this);
        emailEt.setHint("Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        emailEt.setMinEms(16);


        linearLayout.addView(emailEt);
        linearLayout.setPadding(10, 10, 10, 10);
        builder.setView(linearLayout);


        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //input email
                String email = emailEt.getText().toString().trim();
                beginRecovery(email);



            }


        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss dialog
                dialog.dismiss();

            }
        });

        builder.create().show();
    }


    private void beginRecovery(String email) {



        if (TextUtils.isEmpty(email)) {
            Toast.makeText(Login_form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Toast.makeText(Login_form.this, "Sending email...", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(Login_form.this, "Email sent", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login_form.this, "Failed...", Toast.LENGTH_SHORT).show();
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //get and show proper error message
                Toast.makeText(Login_form.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }


        });
    }




/*    private void handleFacebookToken(AccessToken token) {
        Log.d(TAG, "handleFacebookToken" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Log.d(TAG,"Sign in with credential: successful");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUItwo(user);
                         //   startActivity(new Intent(getApplicationContext(),HomeActivity
                            //   .class));
                        }
                        else
                        {
                            Log.d(TAG,"Sign in with credential: failure",task.getException());
                            Toast.makeText(Login_form.this,"Authentication Failed",
                                    Toast.LENGTH_SHORT).show();
                            updateUItwo(null);


                        }

                    }
                });

   }

    private  void updateUItwo(FirebaseUser user)
    {


        if(user != null)
        {
          textViewUser .setText(user.getDisplayName());
          if(user.getPhotoUrl() != null)
          {


//              loginButton =  findViewById(R.id.login_button);
//              loginButton.setReadPermissions("email", "public_profile");


              String photoUrl= user.getPhotoUrl().toString();
              photoUrl=photoUrl+ "?type=Large";
              Picasso.get().load(photoUrl).into(mLogo);
            // startActivity(new Intent(getApplicationContext(),HomeActivity.class));//3

          }

        }
        else
        {
            textViewUser.setText("");
            mLogo.setImageResource(R.drawable.junooncircle);
        }


       // startActivity(new Intent(getApplicationContext(),HomeActivity.class));//3.5
    }

*/
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


   @Override
    protected void onStop() {
        super.onStop();



        if(authStateListener != null )
        {
            firebaseAuth.removeAuthStateListener(authStateListener);

        }




    }


   @Override
    public void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to exit ?").setCancelable(false).setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Login_form.super.onBackPressed();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
