package it.foit.corsofoit.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import it.foit.corsofoit.BuildConfig;
import it.foit.corsofoit.R;


public class RemoteConfigurationManager {
    private static final String LAYOUT_KEY = "home_items_layout";
    private static final String LOG_KEY = "RemoteConfigManager";
    private FirebaseRemoteConfig config;

    public RemoteConfigurationManager() {

        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        config = FirebaseRemoteConfig.getInstance();
        config.setConfigSettings(configSettings);
        config.setDefaults(R.xml.remote_config_defaults);

        loadValues();
    }

    private void loadValues() {
        config.fetch(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    config.activateFetched();
                    FirebaseCrash.log("Remote config values fetched!");
                    Log.d(LOG_KEY, "Remote config values fetched!");
                } else {
                    FirebaseCrash.report(new Exception("Remote config failed: " + task.getResult().toString()));
                    Log.e(LOG_KEY, "Remote config failed: " + task.getResult().toString());
                }
            }
        });
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        int numberOfColumns = safelyGetTheValueBecauseGoogleDidNotWantMeToButIdo();
        Log.d(LOG_KEY, "Number of columns: " + numberOfColumns);

        return new StaggeredGridLayoutManager(numberOfColumns, StaggeredGridLayoutManager.VERTICAL);
    }

    private int safelyGetTheValueBecauseGoogleDidNotWantMeToButIdo() {
        try {
            return Integer.parseInt(config.getString(LAYOUT_KEY));
        } catch (NumberFormatException e) {
            return 2;
        }
    }
}
