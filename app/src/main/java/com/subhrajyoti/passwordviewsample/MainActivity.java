package com.subhrajyoti.passwordviewsample;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.subhrajyoti.passwordview.PasswordView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PasswordView passwordView = (PasswordView) findViewById(R.id.passwordView);
        passwordView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf"));
        passwordView.useStrikeThrough(true);
    }
}
