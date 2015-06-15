package com.flat14.movie_quotes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.flat14.movie_quotes.db.Quote;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        } else {
            quoteText.setText("\"" + currentQuote.quote + "\"");
            actorText.setText(currentQuote.author);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkResponse();
                }
            },100);
        }
        return false;
    }

    private void checkResponse(){
        if (titleText.getText().toString().trim().equalsIgnoreCase(currentQuote.movieTitle)) {
            startActivity(new Intent(MainActivity.this, CorrectAnswerActivity.class));
        } else {
            Intent intent = new Intent(MainActivity.this, WrongAnswerActivity.class);
            intent.putExtra(Quote.KEY, createImage());
            startActivity(intent);
        }
    }

    private Uri createImage() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap bitmap = rootView.getDrawingCache();
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/quote.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(imagePath);
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
        return null;
    }

}
