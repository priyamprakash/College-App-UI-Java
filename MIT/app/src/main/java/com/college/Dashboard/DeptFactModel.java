package com.college.Dashboard;

import androidx.annotation.Keep;

@Keep
public class DeptFactModel {
    String name;
    String designation;
    String image;

    @Override
    public String toString() {
        return "DeptFactModel{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
