package it.foit.corsofoit.model;


import java.util.List;

public class EventResponse {

    private final List<Event> events;

    public EventResponse(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
