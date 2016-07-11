package com.intemous9.firebasesample.activity;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.intemous9.firebasesample.FirebaseSampleApplication;
import com.intemous9.firebasesample.R;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private ConstraintLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootLayout = (ConstraintLayout) findViewById(R.id.root_layout);

        findViewById(R.id.button_send_event).setOnClickListener(this);
        findViewById(R.id.button_send_crash).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_send_event:
                // イベント送信を行う
                Bundle fireBundle = new Bundle();
                fireBundle.putString("test", "テストでイベントログを送信");
                FirebaseAnalytics analytics =
                        FirebaseSampleApplication.getFirebaseAnalyticsInstance(this);
                analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, fireBundle);

                // メッセージ表示
                Snackbar.make(mRootLayout, "Firebaseにイベントを送信しました。", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        })
                        .show();
                break;
            case R.id.button_send_crash:
                // 例外を送出してクラッシュレポートを送信
                throw new NullPointerException("Test-致命的なエラーが発生して落ちた");
        }
    }
}
