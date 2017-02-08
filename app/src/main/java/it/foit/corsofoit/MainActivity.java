package it.foit.corsofoit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.foit.corsofoit.adapter.OnElementTappedListener;
import it.foit.corsofoit.model.Event;
import it.foit.corsofoit.adapter.EventAdapter;
import it.foit.corsofoit.repository.EventRepository;

public class MainActivity extends AppCompatActivity implements OnElementTappedListener {
    private final EventRepository repository = new EventRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView eventsList = (RecyclerView) findViewById(R.id.eventsList);

        eventsList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        EventAdapter adapter = new EventAdapter(repository.getEvents(), this);
        eventsList.setAdapter(adapter);
    }

    @Override
    public void onElementTapped(Event event) {
        Toast.makeText(this, "Cliccato evento " + event.getTitle(), Toast.LENGTH_LONG);
    }
}
