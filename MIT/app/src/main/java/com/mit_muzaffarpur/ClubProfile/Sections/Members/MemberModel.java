package com.mit_muzaffarpur.ClubProfile.Sections.Members;

import androidx.annotation.Keep;

@Keep
public class MemberModel {
    public String memberAttendance;
    public String memberDepartment;
    public String memberDesignation;
    public String memberLinkedin;
    public String memberMail;
    public String memberName;
    public String memberPoints;
    public String memberImage;
    public String memberQualification;
    public String memberStatus;

    @Override
    public String toString() {
        return "MemberModel{" +
                "memberAttendance='" + memberAttendance + '\'' +
                ", memberDepartment='" + memberDepartment + '\'' +
                ", memberDesignation='" + memberDesignation + '\'' +
                ", memberLinkedin='" + memberLinkedin + '\'' +
                ", memberMail='" + memberMail + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPoints='" + memberPoints + '\'' +
                ", memberImage='" + memberImage + '\'' +
                ", memberQualification='" + memberQualification + '\'' +
                ", memberStatus='" + memberStatus + '\'' +
                '}';
    }

    public String getMemberAttendance() {
        return memberAttendance;
    }

    public void setMemberAttendance(String memberAttendance) {
        this.memberAttendance = memberAttendance;
    }

    public String getMemberDepartment() {
        return memberDepartment;
    }

    public void setMemberDepartment(String memberDepartment) {
        this.memberDepartment = memberDepartment;
    }

    public String getMemberDesignation() {
        return memberDesignation;
    }

    public void setMemberDesignation(String memberDesignation) {
        this.memberDesignation = memberDesignation;
    }

    public String getMemberLinkedin() {
        return memberLinkedin;
    }

    public void setMemberLinkedin(String memberLinkedin) {
        this.memberLinkedin = memberLinkedin;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(String memberPoints) {
        this.memberPoints = memberPoints;
    }

    public String getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(String memberImage) {
        this.memberImage = memberImage;
    }

    public String getMemberQualification() {
        return memberQualification;
    }

    public void setMemberQualification(String memberQualification) {
        this.memberQualification = memberQualification;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }
}
