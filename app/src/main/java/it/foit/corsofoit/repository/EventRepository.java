package it.foit.corsofoit.repository;

import java.util.ArrayList;
import java.util.List;

import it.foit.corsofoit.R;
import it.foit.corsofoit.model.Event;

public class EventRepository {
    private final int NUMBER_OF_DEFAULT_EVENTS = 10;
    private final List<Event> events;

    public EventRepository() {
        events = loadEvents();
    }

    private List<Event> loadEvents() {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            events.add(new Event(R.mipmap.ic_event, "Evento " + i, "Adesso"));
        }
        return events;
    }

    public List<Event> getEvents() {
        return events;
    }
}