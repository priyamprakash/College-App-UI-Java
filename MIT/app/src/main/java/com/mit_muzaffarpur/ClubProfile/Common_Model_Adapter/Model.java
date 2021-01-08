package com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter;

import androidx.annotation.Keep;

@Keep
public class Model {
    public String date;
    public String image;
    public String message;
    public String title;
    public String link;


    @Override
    public String toString() {
        return "Model{" +
                "date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
