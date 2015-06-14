package com.flat14.movie_quotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.flat14.movie_quotes.db.Quote;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class WrongAnswerActivity extends BaseActivity {

    @InjectView(R.id.wrong_answer)
    TextView wrongText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);
        ButterKnife.inject(this);
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

    @OnClick(R.id.post_facebook)
    public void onPostFacebook() {
        String helpMe = getString(R.string.activity__wrong_ask_message);
        Quote quote = getIntent().getParcelableExtra(Quote.KEY);
        helpMe = helpMe + "\n\""+quote.quote+" - "+quote.author+"\"\n" + getString(R.string.app_url);

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,helpMe);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_intent_chooser_title)));
    }

}
