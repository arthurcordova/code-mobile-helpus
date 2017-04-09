package br.com.codemobile.helpus.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

import com.google.firebase.FirebaseApp;

import br.com.codemobile.helpus.R;

public class SplashActivity extends Activity {

    static final int DELAY = 3000;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseApp.initializeApp(this);

        mContext = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doNextStep();
            }
        }, DELAY);
    }

    public void doNextStep() {
        Intent it = new Intent(mContext, LoginActivity.class);
        startActivity(it);
        finish();
    }

}
