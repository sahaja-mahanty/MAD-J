package com.project.mad.fincheck;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by SAHAJA on 15-03-2018.
 */

public class Card {
    private String line1;
    private String line2;
    private int img;

    public Card(String line1, String line2,int img) {
        this.line1 = line1;
        this.line2 = line2;
        this.img=img;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}