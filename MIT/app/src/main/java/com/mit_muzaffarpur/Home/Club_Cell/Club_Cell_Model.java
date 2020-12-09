package com.mit_muzaffarpur.Home.Club_Cell;

import android.graphics.drawable.Drawable;

public class Club_Cell_Model {
    private int id;
    private String url;
    private int image;

    public Club_Cell_Model(int id, String url, int image) {
        this.id = id;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    public int getImage() {
        return image;
    }
}