package it.foit.corsofoit.networking;


import it.foit.corsofoit.model.EventResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EventsApi {

    @GET("events.json")
    Call<EventResponse> getEvents();
}
