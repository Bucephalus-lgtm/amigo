package com.example.sarthi.model;

public class OnBoardingItem {
    String title,desc;
    int screenAnim;

    public OnBoardingItem(String t, String d, int sA){
        title = t;
        desc = d;
        screenAnim = sA;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getScreenAnim() {
        return screenAnim;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setScreenAnim(int screenAnim) {
        this.screenAnim = screenAnim;
    }
}
