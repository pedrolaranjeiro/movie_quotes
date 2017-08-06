package com.flat14.movie_quotes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.flat14.movie_quotes.db.Quote;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WrongAnswerActivity extends BaseActivity {

    @BindView(R.id.wrong_answer)
    TextView wrongText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        wrongText.setText(database.getWrongAnswer());
    }

    @OnClick(R.id.try_again)
    public void onTryAgain() {
        finish();
    }

    @OnClick(R.id.post)
    public void onPost() {
        Uri uri = getIntent().getParcelableExtra(Quote.Companion.getKEY());
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("*/*");
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_url).toString());
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_intent_chooser_title)));
    }

    @OnClick(R.id.facebook)
    public void onFacebookPost() {
        Uri uri = getIntent().getParcelableExtra(Quote.Companion.getKEY());
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("image/png");
        sendIntent.setPackage("com.facebook.katana");
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_intent_chooser_title)));
    }


}
