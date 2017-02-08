package it.foit.corsofoit.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

public class JsonEventRepo {

    private final Gson gson = new Gson();
    private final EventRepository eventRepository = new EventRepository();
    private final SharedPreferences preferences;

    private static final String KEY = "JSON";

    public JsonEventRepo(final Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String loadEventsJsonFromMemory() {
        String json = preferences.getString(KEY, "");
        if (TextUtils.isEmpty(json)){
            json = "qualcosa";
            preferences.edit()
                    .putString(KEY, json)
                    .apply();
        }
        return json;
    }
}
