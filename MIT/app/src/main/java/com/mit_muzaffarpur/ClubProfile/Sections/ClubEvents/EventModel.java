package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import androidx.annotation.Keep;

@Keep
public class EventModel {
    public String date;
    public String time;
    public String image;
    public String mode;
    public String venue;
    public String description;
    public String title;
    public String link;

    @Override
    public String toString() {
        return "EventModel{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", image='" + image + '\'' +
                ", mode='" + mode + '\'' +
                ", venue='" + venue + '\'' +
                ", description='" + description + '\'' +
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}
