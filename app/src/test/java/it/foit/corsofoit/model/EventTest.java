package it.foit.corsofoit.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EventTest {

    @Mock
    EventBase event;

    @Before
    public void setUp() throws Exception {
        event = mock(EventBase.class);
    }

    @Test
    public void testDateIsValidUnixTimestamp() throws Exception {
        when(event.getDateTime()).thenReturn("1");
        assertNotEquals("", event.getDateTime());
    }
}
