package com.example.hien.viewpagerface;

/**
 * Created by hien on 8/4/17.
 */

public class ItemFace {

    private String tvFace;
    private int idImg;

    public ItemFace(int idImg, String tvFace) {
        this.tvFace = tvFace;
        this.idImg = idImg;
    }

    public String getTvFace() {
        return tvFace;
    }

    public int getIdImg() {
        return idImg;
    }
}
