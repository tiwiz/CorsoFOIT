package it.foit.corsofoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import it.foit.corsofoit.model.Event;

public class DetailActivity extends AppCompatActivity {

    private ImageView eventIcon;
    private TextView eventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        eventIcon = (ImageView) findViewById(R.id.eventIcon);
        eventDate = (TextView) findViewById(R.id.eventDate);

        Intent intent = getIntent();
        if (intent.hasExtra("event")) {
            loadData(intent);
        }
    }

    private void loadData(Intent intent) {
        Event event = getEventFromJson(intent);
        bindViewWith(event);
        bindToolbarWith(event);
    }

    private Event getEventFromJson(Intent intent) {
        String jsonString = intent.getStringExtra("event");
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Event.class);
    }

    private void bindViewWith(Event event) {
        eventIcon.setImageResource(event.getImage());
        eventDate.setText(event.getDateTime());
    }

    private void bindToolbarWith(Event event) {
        getSupportActionBar().setTitle(event.getTitle());
        getSupportActionBar().setSubtitle(event.getDateTime());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
