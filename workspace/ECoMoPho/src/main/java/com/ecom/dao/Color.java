package com.ecom.dao;

public class Color {
   private int colorId;
   private String colorName;

    public Color() {
    }
    public Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public int getColorId() {
        return colorId;
    }
    
}
