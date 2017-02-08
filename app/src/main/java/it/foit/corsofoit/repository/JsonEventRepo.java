package it.foit.corsofoit.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class JsonEventRepo {

    private final Gson gson = new Gson();
    private final EventRepository eventRepository = new EventRepository();

    public JsonEventRepo(final Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


}
