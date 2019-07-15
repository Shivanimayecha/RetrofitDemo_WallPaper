package com.example.retrofitdemoa.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.retrofitdemoa.activity.ShowWallPepar_Activity;
import com.example.retrofitdemoa.activity.WallPaperIamge_Model;

import java.util.ArrayList;

public class RetroFitPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<WallPaperIamge_Model> wallPaperIamge_modelArrayList;

    public RetroFitPagerAdapter(Context context, ArrayList<WallPaperIamge_Model> wallPaperIamge_modelArrayList) {
        this.context = context;
        this.wallPaperIamge_modelArrayList = wallPaperIamge_modelArrayList;
    }

    @Override
    public int getCount() {
        return wallPaperIamge_modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
