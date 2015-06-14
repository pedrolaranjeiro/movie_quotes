package com.flat14.movie_quotes;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FinishActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.finish)
    public void onSuggestClick(){
        // TODO start email activity

    }
}
