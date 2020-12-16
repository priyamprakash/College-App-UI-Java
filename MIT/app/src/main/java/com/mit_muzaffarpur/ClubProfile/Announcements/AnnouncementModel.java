package com.mit_muzaffarpur.ClubProfile.Announcements;


import androidx.annotation.Keep;

@Keep
public class AnnouncementModel {

    public String announcementTitle;
    public String announcementImage;
    public String announcementLink;
    public String announcementTimestamp;
    public String announcementMessage;

    @Override
    public String toString() {
        return "AnnouncementModel{" +
                "announcementTitle='" + announcementTitle + '\'' +
                ", announcementImage='" + announcementImage + '\'' +
                ", announcementLink='" + announcementLink + '\'' +
                ", announcementTimestamp='" + announcementTimestamp + '\'' +
                ", announcementMessage='" + announcementMessage + '\'' +
                '}';
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementImage() {
        return announcementImage;
    }

    public void setAnnouncementImage(String announcementImage) {
        this.announcementImage = announcementImage;
    }

    public String getAnnouncementLink() {
        return announcementLink;
    }

    public void setAnnouncementLink(String announcementLink) {
        this.announcementLink = announcementLink;
    }

    public String getAnnouncementTimestamp() {
        return announcementTimestamp;
    }

    public void setAnnouncementTimestamp(String announcementTimestamp) {
        this.announcementTimestamp = announcementTimestamp;
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public void setAnnouncementMessage(String announcementMessage) {
        this.announcementMessage = announcementMessage;
    }
}
