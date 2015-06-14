package com.flat14.movie_quotes.db;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String TAG = Prefs.class.getSimpleName();
    private static final String FILE_NAME = TAG + ".sharedPreferences";

    private static final String KEY_QUOTE_INDEX = TAG + ".quoteIndex";

    private static SharedPreferences.Editor open(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPref.edit();
    }

    public static int getQuoteIndex(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPref.getInt(KEY_QUOTE_INDEX, 0);
    }

    public static void saveCurrentIndex(Context context, int nextIndex) {
        open(context).putInt(KEY_QUOTE_INDEX, nextIndex).commit();
    }

    public static void nextQuote(Context context) {
        int nextIndex = getQuoteIndex(context) + 1;
        saveCurrentIndex(context, nextIndex);
    }
}
