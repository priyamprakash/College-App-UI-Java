package com.mit_muzaffarpur.Home;

import androidx.annotation.Keep;

@Keep
public class ClubModel {
    public String clubId;
    public String clubName;
    public String clubImage;
    public String clubDescription;
    public String clubFacebookLink;
    public String clubInstaLink;
    public String clubLinkedinLink;
    public String clubTagline;
    public String clubYoutubeLink;


    @Override
    public String toString() {
        return "ClubModel{" +
                "clubId='" + clubId + '\'' +
                ", clubName='" + clubName + '\'' +
                ", clubImage='" + clubImage + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", clubFacebookLink='" + clubFacebookLink + '\'' +
                ", clubInstaLink='" + clubInstaLink + '\'' +
                ", clubLinkedinLink='" + clubLinkedinLink + '\'' +
                ", clubTagline='" + clubTagline + '\'' +
                ", clubYoutubeLink='" + clubYoutubeLink + '\'' +
                '}';
    }


    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public String getClubFacebookLink() {
        return clubFacebookLink;
    }

    public void setClubFacebookLink(String clubFacebookLink) {
        this.clubFacebookLink = clubFacebookLink;
    }

    public String getClubInstaLink() {
        return clubInstaLink;
    }

    public void setClubInstaLink(String clubInstaLink) {
        this.clubInstaLink = clubInstaLink;
    }

    public String getClubLinkedinLink() {
        return clubLinkedinLink;
    }

    public void setClubLinkedinLink(String clubLinkedinLink) {
        this.clubLinkedinLink = clubLinkedinLink;
    }

    public String getClubTagline() {
        return clubTagline;
    }

    public void setClubTagline(String clubTagline) {
        this.clubTagline = clubTagline;
    }

    public String getClubYoutubeLink() {
        return clubYoutubeLink;
    }

    public void setClubYoutubeLink(String clubYoutubeLink) {
        this.clubYoutubeLink = clubYoutubeLink;
    }

    public ClubModel() {
    }


    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubImage() {
        return clubImage;
    }

    public void setClubImage(String clubImage) {
        this.clubImage = clubImage;
    }

}
