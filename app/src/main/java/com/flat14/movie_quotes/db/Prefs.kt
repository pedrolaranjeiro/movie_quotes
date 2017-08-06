package com.flat14.movie_quotes.db

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    private val TAG = Prefs::class.java.simpleName
    private val FILE_NAME = TAG + ".sharedPreferences"
    private val KEY_QUOTE_INDEX = TAG + ".quoteIndex"

    private fun open(context: Context): SharedPreferences.Editor {
        val sharedPref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sharedPref.edit()
    }

    fun getQuoteIndex(context: Context): Int {
        val sharedPref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(KEY_QUOTE_INDEX, 0)
    }

    fun saveCurrentIndex(context: Context, nextIndex: Int) {
        open(context).putInt(KEY_QUOTE_INDEX, nextIndex).commit()
    }

    fun nextQuote(context: Context) {
        val nextIndex = getQuoteIndex(context) + 1
        saveCurrentIndex(context, nextIndex)
    }
}
