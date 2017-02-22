package it.foit.corsofoit.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import it.foit.corsofoit.networking.EventsApi;

import static it.foit.corsofoit.repository.EventRepository.OnElementsLoadedListener;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EventRepositoryTest {

    @Mock
    EventsApi eventsApi;

    @Mock
    OnElementsLoadedListener listener;

    EventRepository testRespository;

    @Before
    public void setUp() throws Exception {
        eventsApi = mock(EventsApi.class);
        listener = mock(OnElementsLoadedListener.class);

        testRespository = new EventRepository(eventsApi, listener);
    }

    @Test
    public void testNetworkGoneBad() throws Exception {
        when(eventsApi.getEvents()).thenReturn(null);
        testRespository.loadEvents();

        verify(listener, atLeastOnce()).onElementWentIncrediblyBad();
    }
}
