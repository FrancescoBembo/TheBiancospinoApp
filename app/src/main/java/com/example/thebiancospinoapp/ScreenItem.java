package com.example.thebiancospinoapp;

public class ScreenItem {

    String Title,Desctiption;
    int ScreenImg;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesctiption() {
        return Desctiption;
    }

    public void setDesctiption(String desctiption) {
        Desctiption = desctiption;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public ScreenItem(String title, String desctiption, int screenImg) {
        Title = title;
        Desctiption = desctiption;
        ScreenImg = screenImg;

    }

}
