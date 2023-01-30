package com.college.Dashboard.Gallery;


import androidx.annotation.Keep;

@Keep
public class GalleryModel {
    public  String  image;

    @Override
    public String toString() {
        return "GalleryModel{" +
                "image='" + image + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
