package com.myapplicationdev.android.p02_holidays;

public class Holidays {
    private String name;
    private String date;
    private  int img;
    public Holidays(String name, String date, int img){
        this.name=name;
        this.date=date;
        this.img = img;
    }

    public String getName() {
        return name;
    }
    public String getDate(){
        return date;
    }

    public int getImg() {
        return img;
    }
}
