package com.intemous9.firebasesample;

import android.app.Application;
import android.content.res.Configuration;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.intemous9.firebasesample.utils.LocalStorageUtil;

public class FirebaseSampleApplication extends Application {

    private static FirebaseSampleApplication sApp;

    private FirebaseAnalytics mFirebaseAnalytics;

    public FirebaseSampleApplication() {
    }

    public static FirebaseSampleApplication getInstance() {
        if (sApp == null) {
            sApp = new FirebaseSampleApplication();
        }
        return sApp;

    }

    /**
     * If a device is a tablet, allow an applicaiton to autoRotate
     *
     * @return true: autoRotate false: Do not allow landscape mode
     */
    public static boolean isAutoLandscape() {
        return LocalStorageUtil.getBoolean("is_tablet", false);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        //Check if a device is a tablet
        LocalStorageUtil.putBoolean("is_tablet", getResources().getBoolean(R.bool.is_tablet));

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public boolean isLandscape() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

}
