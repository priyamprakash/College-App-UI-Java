package com.college.Dashboard.Alumni;

import androidx.annotation.Keep;

@Keep
public class AlumniModel {
    String name;
    String batch = "";
    String branch;
    String designation;
    String company;

    public AlumniModel() {
    }

    @Override
    public String toString() {
        return "AlumniModel{" +
                "name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", branch='" + branch + '\'' +
                ", designation='" + designation + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
