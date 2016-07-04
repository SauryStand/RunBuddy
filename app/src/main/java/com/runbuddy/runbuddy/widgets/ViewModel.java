package com.runbuddy.runbuddy.widgets;

/**
 * Created by voyager on 2016/6/5.
 */
public class ViewModel {
    private String text;
    private String image;

    public ViewModel(String mtext, String mimage) {
        this.text = mtext;
        this.image = mimage;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}
