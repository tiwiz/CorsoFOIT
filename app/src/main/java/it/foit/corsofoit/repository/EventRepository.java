package it.foit.corsofoit.repository;

import java.util.List;

import it.foit.corsofoit.model.Event;
import it.foit.corsofoit.model.EventResponse;
import it.foit.corsofoit.networking.ApiService;
import it.foit.corsofoit.networking.EventsApi;
import retrofit2.Call;
import retrofit2.Callback;

public class EventRepository {

    private final EventsApi eventsApi = new ApiService().getEventsApi();

    private final OnElementsLoadedListener listener;

    public interface OnElementsLoadedListener {
        void onElementsLoaded(List<Event> events);
        void onElementWentIncrediblyBad();
    }

    public EventRepository(OnElementsLoadedListener listener) {
        this.listener = listener;
    }

    public void loadEvents() {

        eventsApi.getEvents().enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, retrofit2.Response<EventResponse> response) {
                listener.onElementsLoaded(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                listener.onElementWentIncrediblyBad();
            }
        });
    }

}
