package com.mit_muzaffarpur;

import androidx.annotation.Keep;

@Keep
public class Post {
    String clubImage;
    String title;
    String description;
    String author;

    public Post() {
    }


    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", clubImage='" +clubImage +'\'' +
                '}';
    }

    //getter and seter for all three strings
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
