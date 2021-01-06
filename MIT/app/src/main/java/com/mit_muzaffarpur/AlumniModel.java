package com.mit_muzaffarpur;

import androidx.annotation.Keep;

@Keep
public class AlumniModel {
    String clubImage;
    String name;
    String description;
    String author;

    public AlumniModel() {
    }


    @Override
    public String toString() {
        return "AlumniModel{" +
                "title='" + name + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", clubImage='" +clubImage +'\'' +
                '}';
    }

    //getter and seter for all three strings
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubImage() {
        return clubImage;
    }

    public void setClubImage(String clubImage) {
        this.clubImage = clubImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
