package com.flat14.movie_quotes;

import android.content.Intent;
import android.net.Uri;
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
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: ")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"flat14.tech@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Movie Quotes - Quote Suggestion");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
