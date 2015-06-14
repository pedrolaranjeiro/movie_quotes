package com.flat14.movie_quotes;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.flat14.movie_quotes.db.Quote;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @InjectView(R.id.movie_quote)
    TextView quoteText;

    @InjectView(R.id.movie_actor)
    TextView actorText;

    @InjectView(R.id.movie_title)
    EditText titleText;

    private Quote currentQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        titleText.setOnEditorActionListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        generateQuote();
        titleText.setText("");
    }

    private void generateQuote() {
        currentQuote = database.getNextQuote(this);
        if (currentQuote == null) {
            startActivity(new Intent(this, FinishActivity.class));
        }else {
            quoteText.setText("\"" + currentQuote.quote + "\"");
            actorText.setText(currentQuote.author);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // do your stuff here
            if (titleText.getText().toString().trim().equalsIgnoreCase(currentQuote.movieTitle)) {
                startActivity(new Intent(this, CorrectAnswerActivity.class));
            } else {
                Intent intent =  new Intent(this, WrongAnswerActivity.class);
                intent.putExtra(Quote.KEY, currentQuote);
                startActivity(intent);
            }
        }
        return false;
    }

}
