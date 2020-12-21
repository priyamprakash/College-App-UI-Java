package com.mit_muzaffarpur;


import androidx.annotation.Keep;

@Keep
public class Signup_Model {

    public String fullName,Username,Email,Gender;

    public Signup_Model(){


    }
    public Signup_Model(String fullName, String username, String email, String gender) {
        this.fullName = fullName;
        Username = username;
        Email = email;
        Gender = gender;
    }

}
