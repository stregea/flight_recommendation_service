package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.Departure;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepartureTest {

    /**
     * Test the standard Departure record.
     */
    @Test
    public void testDeparture() {
        final String airport = "Greater Rochester International Airport";
        final String timezone = "America/New_York";
        final String iata = "ROC";
        final String icao = "KROC";
        final String gate = "B7";
        final OffsetDateTime scheduled = OffsetDateTime.now();
        final OffsetDateTime estimated = OffsetDateTime.now();

        Departure departure = new Departure(airport, timezone, iata, icao, null, gate, null,
                scheduled, estimated, null, null, null);

        assertNotNull(departure);
        assertEquals(airport, departure.airport());
        assertEquals(timezone, departure.timezone());
        assertEquals(iata, departure.iata());
        assertEquals(icao, departure.icao());
        assertNull(departure.terminal());
        assertEquals(gate, departure.gate());
        assertNull(departure.delay());
        assertEquals(scheduled, departure.scheduled());
        assertEquals(estimated, departure.estimated());
        assertNull(departure.actual());
        assertNull(departure.estimatedRunway());
        assertNull(departure.actualRunway());
    }
}
