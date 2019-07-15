package com.example.retrofitdemoa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitdemoa.R;
import com.example.retrofitdemoa.retrofit.ApiService;
import com.example.retrofitdemoa.retrofit.RetroClient;
import com.example.retrofitdemoa.share.GlobalApplication;
import com.example.retrofitdemoa.share.NetworkConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitDemoAgainContainer extends AppCompatActivity {

    ArrayList<Wallpepar_Model> wallpepar_modelArrayList = new ArrayList<>();
    RetrofitDemoAgainAdapter retrofitDemoAgainAdapter;
    private RecyclerView recylerlylr;
    Activity activity;

    String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo_again_container);
        activity = RetrofitDemoAgainContainer.this;

        recylerlylr = findViewById(R.id.recylerlylr);
        recylerlylr.setHasFixedSize(true);
        recylerlylr.setLayoutManager(new LinearLayoutManager(this));

        initViews();
    }

    private void initViews() {

        if (NetworkConnection.isNetworkAvailable(activity)) {

            try {

                ApiService api = RetroClient.getApiService();
                Call<String> call = api.getAllApps();
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {


                        Log.e(TAG, "onResponse: " + response.body());

                        if (response.body() != null) {

                            parseResponse(response.body(), "");

                        } else {

                            //showSomethingwentWrong();

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        //hideProgressbar();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {

            Toast.makeText(activity, "Please check your network connection", Toast.LENGTH_SHORT).show();
        }


    }

    private void parseResponse(String body, String s) {

        try {

            JSONArray jsonArray = new JSONArray(body);


            for (int i = 0; i < jsonArray.length(); i++) {

                Wallpepar_Model wallpepar_model = new Wallpepar_Model();
                JSONObject jsonobject = (JSONObject) jsonArray.get(i);
                wallpepar_model.setId(jsonobject.optString("id"));
                wallpepar_model.setCategoryImage(jsonobject.optString("category_img"));
                wallpepar_model.setCategories(jsonobject.getString("categories"));
                wallpepar_modelArrayList.add(wallpepar_model);

                /*  GlobalApplication.sharePrefs.setApp_id(jsonobject.optString("app_id"));
                GlobalApplication.sharePrefs.setApp_name(jsonobject.optString("app_name"));
                GlobalApplication.sharePrefs.setApp_link(jsonobject.optString("app_link"));
                GlobalApplication.sharePrefs.setBanner_ads(jsonobject.optString("banner_ads"));
                GlobalApplication.sharePrefs.setFull_screen_ads(jsonobject.optString("full_screen_ads"));
                GlobalApplication.sharePrefs.setVideo_ads(jsonobject.optString("video_ads"));
                GlobalApplication.sharePrefs.setApp_update(jsonobject.optString("app_update"));

                Log.e(TAG, "name-->: " + GlobalApplication.sharePrefs.getApp_name());*/
            }
            retrofitDemoAgainAdapter = new RetrofitDemoAgainAdapter(RetrofitDemoAgainContainer.this, wallpepar_modelArrayList);

            recylerlylr.setAdapter(retrofitDemoAgainAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
