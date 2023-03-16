package com.trendnxt.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object AppPreference {

    var MyPREFERENCES = "loginprefence"

    var MyPREFERENCES_OTHER = "OTHER"

    lateinit var mPrefs: SharedPreferences
    lateinit var mPrefsEditor: SharedPreferences.Editor

    lateinit var mPrefsNonClear: SharedPreferences
    lateinit var mPrefsEditorNonClear: SharedPreferences.Editor

    fun Logout(ctx: Context?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.clear().commit()
    }

    fun getID(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("regid", "")
    }

    fun setID(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.putString("regid", value)
        mPrefsEditor.commit()
    }


    fun getDeviceId(ctx: Context): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("device_id", "")
    }

    fun setDeviceId(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.putString("device_id", value)
        mPrefsEditor.commit()
    }

    fun getYoutubeAuthName(ctx: Context): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("youtube_auth_name", "")
    }

    fun setYoutubeAuthName(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.putString("youtube_auth_name", value)
        mPrefsEditor.commit()
    }

    fun getYoutubeAccessToken(ctx: Context): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("youtube_access_token", "")
    }

    fun setYoutubeAccessToken(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.putString("youtube_access_token", value)
        mPrefsEditor.commit()
    }



    fun getRedditToken(ctx: Context): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("reddit_token", "")
    }

    fun setRedditToken(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        mPrefsEditor.putString("reddit_token", value)
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getCountryCode(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("country_code", "")
    }

    @JvmStatic
    fun setCountryCode(ctx: Context?, value: String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("country_code", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getCountryName(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("country_name", "")
    }

    @JvmStatic
    fun setCountryName(ctx: Context?, value: String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("country_name", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getTwitterToken(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("twitter_token", "")
    }

    @JvmStatic
    fun setTwitterToken(ctx: Context?, value: String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("twitter_token", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getTwitterTokenSecrets(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("twitter_token_secrets", "")
    }

    @JvmStatic
    fun setTwitterTokenSecrets(ctx: Context?, value: String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("twitter_token_secrets", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getTwitterSelectedCountry(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("twitter_selected_country", "Worldwide")
    }

    @JvmStatic
    fun setTwitterSelectedCountry(ctx: Context?, value: String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("twitter_selected_country", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getPermissionTime(ctx: Context?): Int? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getInt("permission_time", 0)
    }

    @JvmStatic
    fun setPermissionTime(ctx: Context?, value: Int) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putInt("permission_time", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun isFirstUser(ctx: Context?): Boolean {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getBoolean("first_login", true)
    }

    @JvmStatic
    fun setFirstUser(ctx: Context?, value: Boolean) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putBoolean("first_login", value)
        }
        mPrefsEditor.commit()
    }


    @JvmStatic
    fun isTwitterAuthenticated(ctx: Context?): Boolean {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getBoolean("TWITTER_IS_LOGGED_IN_v4", true)
    }

    @JvmStatic
    fun isTwitterAuthenticated(ctx: Context?, value: Boolean) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putBoolean("TWITTER_IS_LOGGED_IN_v4", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun isProductUnlocked(ctx: Context?): Boolean {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getBoolean("product_payment", true)
    }

    @JvmStatic
    fun setLockUnlockProduct(ctx: Context?, value: Boolean) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putBoolean("product_payment", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getCategories(ctx: Context?): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString("categories", "")
    }

    @JvmStatic
    fun setCategories(ctx: Context?, value: String?) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString("categories", value)
        }
        mPrefsEditor.commit()
    }

    @JvmStatic
    fun getList(ctx: Context?, key: String): String? {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        return mPrefs.getString(key, "")
    }

    @JvmStatic
    fun setList(ctx: Context?, value: String?, key:String) {
        //        mPrefs = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        mPrefsEditor = mPrefs.edit()
        if (value != null) {
            mPrefsEditor.putString(key, value)
        }
        mPrefsEditor.commit()
    }


}