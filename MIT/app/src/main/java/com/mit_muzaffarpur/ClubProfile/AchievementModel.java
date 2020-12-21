package com.mit_muzaffarpur.ClubProfile;

import androidx.annotation.Keep;

@Keep
public class AchievementModel {
    public String achievementDate;
    public String achievementImage;
    public String achievementMessage;
    public String achievementTitle;
    public String achievementLink;


    @Override
    public String toString() {
        return "AchievementModel{" +
                "achievementDate='" + achievementDate + '\'' +
                ", achievementImage='" + achievementImage + '\'' +
                ", achievementMessage='" + achievementMessage + '\'' +
                ", achievementTitle='" + achievementTitle + '\'' +
                ", achievementLink='" + achievementLink + '\'' +
                '}';
    }

    public String getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(String achievementDate) {
        this.achievementDate = achievementDate;
    }

    public String getAchievementImage() {
        return achievementImage;
    }

    public void setAchievementImage(String achievementImage) {
        this.achievementImage = achievementImage;
    }

    public String getAchievementMessage() {
        return achievementMessage;
    }

    public void setAchievementMessage(String achievementMessage) {
        this.achievementMessage = achievementMessage;
    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
    }

    public String getAchievementLink() {
        return achievementLink;
    }

    public void setAchievementLink(String achievementLink) {
        this.achievementLink = achievementLink;
    }
}
