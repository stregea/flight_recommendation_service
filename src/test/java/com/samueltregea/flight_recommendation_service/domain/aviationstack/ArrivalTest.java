package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrivalTest {

    /**
     * Test the standard Arrival record.
     */
    @Test
    public void testArrival() {
        final String airport = "Hartsfield-jackson Atlanta International";
        final String timezone = "America/New_York";
        final String iata = "ATL";
        final String icao = "KATL";
        final String terminal = "S";
        final String gate = "B11";
        final String baggage = "1";
        final OffsetDateTime scheduled = OffsetDateTime.now();
        final OffsetDateTime estimated = OffsetDateTime.now();

        Arrival arrival = new Arrival(airport, timezone, iata, icao, terminal, gate, baggage, null,
                scheduled, estimated, null, null, null);

        assertNotNull(arrival);
        assertEquals(airport, arrival.airport());
        assertEquals(timezone, arrival.timezone());
        assertEquals(iata, arrival.iata());
        assertEquals(icao, arrival.icao());
        assertEquals(terminal, arrival.terminal());
        assertEquals(gate, arrival.gate());
        assertEquals(baggage, arrival.baggage());
        assertNull(arrival.delay());
        assertEquals(scheduled, arrival.scheduled());
        assertEquals(estimated, arrival.estimated());
        assertNull(arrival.actual());
        assertNull(arrival.estimatedRunway());
        assertNull(arrival.actualRunway());
    }
}
