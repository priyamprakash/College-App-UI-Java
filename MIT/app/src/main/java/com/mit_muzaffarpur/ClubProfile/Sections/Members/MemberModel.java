package com.mit_muzaffarpur.ClubProfile.Sections.Members;

import androidx.annotation.Keep;

@Keep
public class MemberModel {
    public String attendance;
    public String department;
    public String designation;
    public String linkedin;
    public String mail;
    public String name;
    public String points;
    public String image;
    public String qualification;
    public String position;
    public String status;


    @Override
    public String toString() {
        return "MemberModel{" +
                "attendance='" + attendance + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", points='" + points + '\'' +
                ", image='" + image + '\'' +
                ", qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
