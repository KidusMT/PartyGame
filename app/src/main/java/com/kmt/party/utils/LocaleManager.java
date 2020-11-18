package com.kmt.party.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

import static com.kmt.party.data.prefs.AppPreferencesHelper.PREF_KEY_CURRENT_LANGUAGE;

/**
 * Created by KidusMT.
 */

public class LocaleManager {

    public static void setLocale(Context c) {
        setNewLocale(c, getLanguage(c));
    }

    /** This method is for changing the current language with a different language
     * @param c is the context of the base activity
     * @param language is the string value of the language we want to set in
     */
    public static void setNewLocale(Context c, String language) {
        persistLanguage(c, language);
        updateResources(c, language);
    }

    /** This method is for getting the current language setting
     * @param c is the context of the base activity
     * @return string value of the currently language
     */
    public static String getLanguage(Context c) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PREF_KEY_CURRENT_LANGUAGE, "en");// defaults to English
    }

    /** This method is for saving the new language to the sharedPreference of the application
     * @param c is the context of the base activity
     * @param language is the new selected language we want to set in
     */
    private static void persistLanguage(Context c, String language) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_LANGUAGE, language).apply();// a
    }

    /** This is a method for updating the current language with the new selected language
     * @param context is the context of the base activity
     * @param language is the new selected language for updating the language
     */
    private static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(locale);
        } else{
            config.locale=locale;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            context.getApplicationContext().createConfigurationContext(res.getConfiguration());
        } else {
            context.getResources().updateConfiguration(config,res.getDisplayMetrics());
        }

        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}
