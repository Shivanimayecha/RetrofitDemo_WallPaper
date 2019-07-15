package com.example.retrofitdemoa.activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpepar_Model  {

    String id , categories,categoryImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
