package com.example.retrofitdemoa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitdemoa.Adapter.RetroFitPagerAdapter;
import com.example.retrofitdemoa.R;
import com.example.retrofitdemoa.retrofit.ApiService;
import com.example.retrofitdemoa.retrofit.RetroClient;
import com.example.retrofitdemoa.share.NetworkConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowWallPepar_Activity extends AppCompatActivity {

    String TAG = "TAG";
    String cat_id;
    int idd;
    ViewPager viewPager;
    Activity activity;
    RetroFitPagerAdapter retroFitPagerAdapter;
    ArrayList<WallPaperIamge_Model> wallPaperIamge_modelArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_wall_pepar_);

        viewPager = findViewById(R.id.viewPager);


        cat_id = getIntent().getStringExtra("cat_id");
        idd = Integer.parseInt(cat_id);
        Log.e(TAG, "onCreate: " + idd);

        activity = ShowWallPepar_Activity.this;
        initview();

    }

    private void initview() {

        if (NetworkConnection.isNetworkAvailable(activity)) {
            try {

                ApiService api = RetroClient.getApiService();
                Call<String> call = api.getAllWallpepar(idd);
                call.enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        Toast.makeText(ShowWallPepar_Activity.this, "hiii", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onResponseWallpepar: " + response.body());

                        if (response.body() != null) {
                            callWallPaperAPI(response.body(), "");
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e(TAG, "onFailure: ");
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            Toast.makeText(activity, "Please check your network connection", Toast.LENGTH_SHORT).show();

        }

    }

    private void callWallPaperAPI(String body, String s) {


        try {
            JSONArray jsonArray = new JSONArray(body);
            for (int i = 0; i <= jsonArray.length(); i++) {
                WallPaperIamge_Model wallPaperIamge_model = new WallPaperIamge_Model();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                wallPaperIamge_model.setId(jsonObject.optString("id"));
                wallPaperIamge_model.setImage(jsonObject.optString("image"));
                wallPaperIamge_model.setCategoryId(jsonObject.optString("category_id"));
                wallPaperIamge_modelArrayList.add(wallPaperIamge_model);

               // Log.e(TAG, "callWallPaperAPI: " + wallPaperIamge_modelArrayList.get(i).getId());
            }

            retroFitPagerAdapter = new RetroFitPagerAdapter(ShowWallPepar_Activity.this,wallPaperIamge_modelArrayList);
            viewPager.setAdapter(retroFitPagerAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
