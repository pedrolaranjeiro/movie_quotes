package com.flat14.movie_quotes;

import android.os.Bundle;

import com.flat14.movie_quotes.db.Prefs;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CorrectAnswerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.next)
    public void onNextClick() {
        Prefs.nextQuote(this);
        finish();
    }

}
