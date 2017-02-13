package it.foit.corsofoit;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;


public class FoitApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
