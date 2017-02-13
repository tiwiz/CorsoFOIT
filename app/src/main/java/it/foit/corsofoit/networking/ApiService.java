package it.foit.corsofoit.networking;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private final Retrofit retrofit;
    private final EventsApi eventsApi;

    public ApiService() {
        retrofit = buildRetrofit();
        eventsApi = retrofit.create(EventsApi.class);
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://orgiu.net/CorsoFOIT/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public EventsApi getEventsApi() {
        return eventsApi;
    }
}
