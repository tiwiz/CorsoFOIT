package it.foit.corsofoit.model;


import java.util.List;

public class Response {

    private final List<Event> events;

    public Response(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
