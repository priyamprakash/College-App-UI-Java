package com.mit_muzaffarpur.HomeFragment_Elements.Notify;

public class Notify_Model {
    private String Title , Date , description;

    public Notify_Model(String  Title, String Date, String description) {
        this.Title = Title;
        this.Date = Date;
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    public String getDate() {
        return Date;
    }
    public String getDescription()
    {
        return description;
    }
}