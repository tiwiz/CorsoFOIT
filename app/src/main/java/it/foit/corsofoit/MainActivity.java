package it.foit.corsofoit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView eventsList = (RecyclerView) findViewById(R.id.eventsList);

        eventsList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            events.add(new Event(R.mipmap.ic_event, "Evento " + i, "Adesso"));
        }

        EventAdapter adapter = new EventAdapter(events);
        eventsList.setAdapter(adapter);
    }

}
