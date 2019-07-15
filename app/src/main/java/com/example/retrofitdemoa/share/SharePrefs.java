package com.example.retrofitdemoa.share;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by adminb on 1/17/2019.
 */

public class SharePrefs {


    public static int isReedeemm = 0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "EarnBoss";


    public static String app_id = "app_id";
    public static String app_name = "app_name";
    public static String app_link = "app_link";
    public static String banner_ads = "banner_ads";
    public static String full_screen_ads = "full_screen_ads";
    public static String video_ads = "video_ads";
    public static String app_update = "app_update";

    public static String isFirsttime = "isFirsttime";


    public SharePrefs(Context contx) {
        pref = contx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setApp_id(String isAppUpdate) {
        editor.putString(app_id, isAppUpdate);
        editor.commit();
    }

    public String getApp_id() {
        return pref.getString(app_id, "");
    }


    public void setApp_name(String isAppUpdate) {
        editor.putString(app_name, isAppUpdate);
        editor.commit();
    }

    public String getApp_name() {
        return pref.getString(app_name, "");
    }

    public void setApp_link(String isAppUpdate) {
        editor.putString(app_link, isAppUpdate);
        editor.commit();
    }

    public String getApp_link() {
        return pref.getString(app_link, "");
    }

    public void setBanner_ads(String isAppUpdate) {
        editor.putString(banner_ads, isAppUpdate);
        editor.commit();
    }

    public String getBanner_ads() {
        return pref.getString(banner_ads, "");
    }

    public void setFull_screen_ads(String isAppUpdate) {
        editor.putString(full_screen_ads, isAppUpdate);
        editor.commit();
    }

    public String getFull_screen_ads() {
        return pref.getString(full_screen_ads, "");
    }

    public void setVideo_ads(String isAppUpdate) {
        editor.putString(video_ads, isAppUpdate);
        editor.commit();
    }

    public String getVideo_ads() {
        return pref.getString(video_ads, "");
    }

    public void setApp_update(String isAppUpdate) {
        editor.putString(app_update, isAppUpdate);
        editor.commit();
    }

    public String getApp_update() {
        return pref.getString(app_update, "");
    }

    public void setIsFirsttime(String isAppUpdate) {
        editor.putString(isFirsttime, isAppUpdate);
        editor.commit();
    }

    public String getIsFirsttime() {
        return pref.getString(isFirsttime, "");
    }


}
