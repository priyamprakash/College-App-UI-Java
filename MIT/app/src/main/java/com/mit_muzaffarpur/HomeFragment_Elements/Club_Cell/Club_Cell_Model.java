package com.mit_muzaffarpur.HomeFragment_Elements.Club_Cell;

public class Club_Cell_Model {
    private  String name , subtitle , description;
    private int id;
    private String url;
    private int image;

    public Club_Cell_Model(String name ,String subtitle , String description ,int id, String url, int image) {
        this.name = name;
        this.subtitle = subtitle;
        this.description = description;
        this.id = id;
        this.url = url;
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    public int getImage() {
        return image;
    }
}