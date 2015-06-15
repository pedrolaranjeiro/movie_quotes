package com.flat14.movie_quotes;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

import com.flat14.movie_quotes.db.Database;

import de.greenrobot.event.EventBus;

public class BaseActivity extends FragmentActivity {

    protected Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        database = new Database();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    // Dummy Event
    public void onEvent(Object object) {

    }

}
