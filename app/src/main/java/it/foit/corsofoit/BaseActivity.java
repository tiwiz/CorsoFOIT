package it.foit.corsofoit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

public abstract class BaseActivity extends AppCompatActivity{
    private FirebaseAnalytics analytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        analytics = FirebaseAnalytics.getInstance(this);

        FirebaseCrash.report(new Exception("Non-fatal exception during " + getClass().getSimpleName() + " onCreate() method"));
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, getClass().getSimpleName());
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        FirebaseCrash.log("User saw Activity " + getClass().getSimpleName());
    }
}
