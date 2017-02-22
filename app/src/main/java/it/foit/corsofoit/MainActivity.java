package it.foit.corsofoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;

import java.util.List;

import it.foit.corsofoit.adapter.OnElementTappedListener;
import it.foit.corsofoit.model.Event;
import it.foit.corsofoit.adapter.EventAdapter;
import it.foit.corsofoit.networking.ApiService;
import it.foit.corsofoit.repository.EventRepository;
import it.foit.corsofoit.utils.RemoteConfigurationManager;

public class MainActivity extends BaseActivity implements OnElementTappedListener, EventRepository.OnElementsLoadedListener {

    private EventRepository repository;
    private EventAdapter adapter;
    private RemoteConfigurationManager remoteConfigurationManager = new RemoteConfigurationManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView eventsList = (RecyclerView) findViewById(R.id.eventsList);
        eventsList.setLayoutManager(remoteConfigurationManager.getLayoutManager());
        adapter = new EventAdapter(this);
        eventsList.setAdapter(adapter);
        repository = new EventRepository(new ApiService().getEventsApi(), this);
        repository.loadEvents();
    }

    @Override
    public void onElementTapped(Event event) {
        Gson gson = new Gson();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("event", gson.toJson(event));
        startActivity(intent);
    }

    @Override
    public void onElementsLoaded(List<Event> events) {
        adapter.setEventList(events);
    }

    @Override
    public void onElementWentIncrediblyBad() {

    }
}
