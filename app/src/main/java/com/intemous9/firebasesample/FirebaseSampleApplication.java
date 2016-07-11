package com.intemous9.firebasesample;

import android.app.Application;
import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FirebaseSampleApplication extends Application {

    private static FirebaseSampleApplication sApp;

    private static FirebaseAnalytics mFirebaseAnalytics;

    public FirebaseSampleApplication() {
    }

    public static FirebaseSampleApplication getInstance() {
        if (sApp == null) {
            sApp = new FirebaseSampleApplication();
        }
        return sApp;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public static FirebaseAnalytics getFirebaseAnalyticsInstance(Context context) {
        if (mFirebaseAnalytics == null) {
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        }

        return mFirebaseAnalytics;
    }

}
