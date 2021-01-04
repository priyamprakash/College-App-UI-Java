package com.mit_muzaffarpur;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.Bottom.MainActivity;

import java.util.HashMap;

@Keep
public class RegisterActivity extends AppCompatActivity {
    EditText username,fullname,email,password;
    Button register;
    TextView txt_login;
    ImageView imageView;

    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView = findViewById(R.id.img);

        Glide.with(getApplicationContext())
                .load(R.drawable.mit_pic)
                .override(0,  0) // (change according to your wish)
                .error(R.drawable.image_placeholder)
                .into(imageView);

        //sara edit text ko id se link
        username=findViewById(R.id.username);
        fullname=findViewById(R.id.fullname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        txt_login=findViewById(R.id.txt_login);
        //---------------------FIREBASE AUTHENTICATION------------------------------------
        //initialisiting the firebasebaseauth in the on create method
        auth= FirebaseAuth.getInstance();
        //Already have an account pr onClick Listener
        txt_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        //on click lgayen hn REGISTER button pr
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd= new ProgressDialog(RegisterActivity.this);
                pd.setMessage("Please Wait...");
                pd.show();

                String str_username=username.getText().toString();
                String str_fullname=fullname.getText().toString();
                String str_email=email.getText().toString();
                String str_password=password.getText().toString();

                if (TextUtils.isEmpty(str_username) || TextUtils.isEmpty(str_fullname) || TextUtils.isEmpty(str_email)  || TextUtils.isEmpty(str_password))
                {
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else if (str_password.length() < 6)
                {
                    Toast.makeText(RegisterActivity.this, "Password must have atleast 6 characters", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    register(str_username,str_fullname,str_email,str_password);

                }
            }
        });



    }
    //register namak ek alg function hai , on create k bahar hai ,will be called from register ke on click ke else block se

    private void register(final String username, final String fullname, String email, String password)
    {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            FirebaseUser firebaseUser= auth.getCurrentUser();
                            String userid=firebaseUser.getUid();

                            reference= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);

                            HashMap<String,Object> hashMap=new HashMap<>();
                            hashMap.put("id",userid);
                            hashMap.put("username",username.toLowerCase());
                            hashMap.put("fullname",fullname);
                            hashMap.put("bio","");
                            hashMap.put("imageurl","https://firebasestorage.googleapis.com/v0/b/mitcollege-71b82.appspot.com/o/placeholder.png?alt=media&token=87cf2e28-a257-459f-8216-e62495fd0bcd");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        pd.dismiss();
                                        Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);


                                    }


                                }
                            });

                        }
                        else
                        {
                            pd.dismiss();
                            Toast.makeText(RegisterActivity.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
}