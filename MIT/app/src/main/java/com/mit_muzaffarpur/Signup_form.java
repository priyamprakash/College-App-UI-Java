package com.mit_muzaffarpur;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.Bottom.MainActivity;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")

@Keep
public class Signup_form extends AppCompatActivity {

    LinearLayout myLayout;
    AnimationDrawable animationDrawable;
    EditText txt_fullname,txt_username, txt_email,txtPassword,txtConfirmPassword;
    Button btn_register;
    RadioButton radioGenderMale,radioGenderFemale;
    ProgressBar progressBar;
    DatabaseReference databaseReference;
    String gender="";
    FirebaseDatabase firebaseDatabase;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);

        txt_fullname=findViewById(R.id.txt_full_name);
        txt_username=findViewById(R.id.txt_username);
        txt_email=findViewById(R.id.txt_email);
        txtPassword=findViewById(R.id.txt_password);
        txtConfirmPassword=findViewById(R.id.txt_confirm_password);
        btn_register=findViewById(R.id.buttonRegister);
        radioGenderMale=findViewById(R.id.male);
        radioGenderFemale=findViewById(R.id.female);
        progressBar=findViewById(R.id.progressBar);

        //this is for transition of background


        myLayout = findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        //   animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //--------------------------------------------------------------------------------------------------------------------
        databaseReference=FirebaseDatabase.getInstance().getReference("Student");
        firebaseAuth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullName=txt_fullname.getText().toString();
                final String userName=txt_username.getText().toString();
                final String email=txt_email.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                String confirmpassword=txtConfirmPassword.getText().toString().trim();

                if(radioGenderMale.isChecked()) {
                    gender = "Male";
                }
                if(radioGenderFemale.isChecked()) {
                    gender = "Female";
                }

                //-------------------------------------------------------------------------------------

                //------------------------------------------------------------------------------------------------------------------------------------

                if(TextUtils.isEmpty(fullName)){
                    Toast.makeText(Signup_form.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(Signup_form.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

         /*   if(TextUtils.isEmpty(confirmpassword)){
                Toast.makeText(Signup_form.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                return;
            }
         */
                //--------------------------------------------------------------------------------------------------------------------------------------
                //ab validation part

                if(password.length()<6) {

                    Toast.makeText(Signup_form.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                //---------------------------------------------------------------------------------------------------------------------------------------




                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup_form.this,
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);


                                        if (task.isSuccessful()) {

                                            Signup_Model information=new Signup_Model(

                                                    fullName,
                                                    userName,
                                                    email,
                                                    gender

                                            );

                                            FirebaseDatabase.getInstance().getReference("Student").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                                    .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(Signup_form.this,"Registration Complete",Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(),
                                                            MainActivity.class));
                                                }
                                            });

                                        }

                                        else {
                                            Toast.makeText(Signup_form.this,"Authentication Failed",
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                        // ...
                                    }
                                });



            }
        });

    }

}
