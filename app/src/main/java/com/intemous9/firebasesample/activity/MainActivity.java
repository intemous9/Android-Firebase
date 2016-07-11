package com.intemous9.firebasesample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.intemous9.firebasesample.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FirebaseAnalyticsにイベントログを送る
        Bundle fireBundle = new Bundle();
        fireBundle.putString("test", "テストでイベントログを送信");
        FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(this);
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, fireBundle);

    }

}
