package com.mit_muzaffarpur.News;


import androidx.annotation.Keep;

@Keep
public class NewsModel {

public  String notificationDescription;
public  String notificationImage;
public  String notificationLink;
public  String notificationTimestamp;
public  String notificationTitle;

    @Override
    public String toString() {
        return "NewsModel{" +
                "notificationDescription='" + notificationDescription + '\'' +
                ", notificationImage='" + notificationImage + '\'' +
                ", notificationLink='" + notificationLink + '\'' +
                ", notificationTimestamp='" + notificationTimestamp + '\'' +
                ", notificationTitle='" + notificationTitle + '\'' +
                '}';
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationImage() {
        return notificationImage;
    }

    public void setNotificationImage(String notificationImage) {
        this.notificationImage = notificationImage;
    }

    public String getNotificationLink() {
        return notificationLink;
    }

    public void setNotificationLink(String notificationLink) {
        this.notificationLink = notificationLink;
    }

    public String getNotificationTimestamp() {
        return notificationTimestamp;
    }

    public void setNotificationTimestamp(String notificationTimestamp) {
        this.notificationTimestamp = notificationTimestamp;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }
}
