package com.example.admin.goatourism;

/**
 * Created by Admin on 16-Jan-20.
 */


public class ListData {
    private String name;
    private String image;
    private String info;

    public ListData(){


    }


    public ListData(String image, String info, String name) {
        this.image = image;
        this.info= info;

        this.name = name;

    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getInfo() {
        return info;
    }

}
