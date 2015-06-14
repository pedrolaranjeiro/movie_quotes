package com.flat14.movie_quotes;

import android.os.Bundle;
import android.widget.TextView;

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
        finish();
    }

}
