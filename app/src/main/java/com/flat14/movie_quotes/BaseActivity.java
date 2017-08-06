package com.flat14.movie_quotes;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.flat14.movie_quotes.db.Database;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


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
    @Subscribe
    public void onEvent(Object object) {

    }

}
