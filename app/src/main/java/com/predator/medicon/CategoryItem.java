package com.predator.medicon;

public class CategoryItem {

    private int mImageResource;
    private String mtext;

    public CategoryItem(int imageResource, String text){
        mImageResource = imageResource;
        mtext = text;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public String gettext() {
        return mtext;
    }
}
