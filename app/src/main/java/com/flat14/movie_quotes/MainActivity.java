package com.flat14.movie_quotes;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import net.apispark.webapi.Sdk;
import net.apispark.webapi.representation.Quote;
import net.apispark.webapi.resource.client.QuoteListClientResource;
import net.apispark.webapi.security.SecurityConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.movie_quote)
    TextView quoteText;

    @BindView(R.id.movie_actor)
    TextView actorText;

    @BindView(R.id.movie_title)
    EditText titleText;

    private Sdk api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        titleText.setOnEditorActionListener(this);
        api = new Sdk();
        SecurityConfig securityConfig = api.getConfig().getSecurityConfig();
        securityConfig.configureAuthHTTP_BASIC("moviequotestester", "testtest");
    }

    @Override
    protected void onResume() {
        super.onResume();
        generateQuote();
        titleText.setText("");
    }

    private void generateQuote() {
        new FetchNextQuote().execute();
    }

    class FetchNextQuote extends AsyncTask<Void,Void, Void>{

        private Quote currentQuote;

        @Override
        protected Void doInBackground(Void... voids) {
            currentQuote =api.quote("7c92ae00-7205-11e7-96b9-bdfd4b9e2934").getQuotesQuoteid();
            return null;
    }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            quoteText.setText("\"" + currentQuote.getDialog() + "\"");
            actorText.setText(currentQuote.getAuthor());
        }

    }


//    private void generateQuote() {
//        try {
//            currentQuote = database.getNextQuote(this);
//            quoteText.setText("\"" + currentQuote.getQuote() + "\"");
//            actorText.setText(currentQuote.getAuthor());
//        } catch (NoMoreQuotesException e) {
//            e.printStackTrace();
//            startActivity(new Intent(this, FinishActivity.class));
//        }
//    }

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
//        if (titleText.getText().toString().trim().equalsIgnoreCase(currentQuote.getMovieTitle())) {
//            startActivity(new Intent(MainActivity.this, CorrectAnswerActivity.class));
//        } else {
//            Intent intent = new Intent(MainActivity.this, WrongAnswerActivity.class);
//            intent.putExtra(Quote.Companion.getKEY(), createImage());
//            startActivity(intent);
//        }
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
