package com.samueltregea.flight_recommendation_service.domain;

import com.samueltregea.flight_recommendation_service.domain.aviationstack.FlightItinerary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlightItineraryTest {

    @BeforeEach
    public void setup() {
    }

    @Test
    public void testDeparture() {
        final String airport = "Greater Rochester International Airport";
        final String timezone = "America/Rochester";
        final String iata = "ROC";
        final String icao = "KROC";
        final String terminal = "B";
        final String gate = "B6";
        final String baggage = "A2";
        final Integer delay = 0;
        final LocalDateTime scheduled = LocalDateTime.now();
        final LocalDateTime estimated = LocalDateTime.now();
        final LocalDateTime actual = LocalDateTime.now();
        final LocalDateTime estimatedRunway = LocalDateTime.now();
        final LocalDateTime actualRunway = LocalDateTime.now();

        FlightItinerary departure = new FlightItinerary(airport, timezone, iata, icao, terminal, gate, baggage, delay,
                scheduled, estimated, actual, estimatedRunway, actualRunway);

        assertNotNull(departure);
        assertEquals(airport, departure.airport());
        assertEquals(timezone, departure.timezone());
        assertEquals(iata, departure.iata());
        assertEquals(icao, departure.icao());
        assertEquals(terminal, departure.terminal());
        assertEquals(gate, departure.gate());
        assertEquals(baggage, departure.baggage());
        assertEquals(delay, departure.delay());
        assertEquals(scheduled, departure.scheduled());
        assertEquals(estimated, departure.estimated());
        assertEquals(actual, departure.actual());
        assertEquals(estimatedRunway, departure.estimatedRunway());
        assertEquals(actualRunway, departure.actualRunway());
    }

    @Test
    public void testArrival() {
        final String airport = "Dallas/Fort Worth International";
        final String timezone = "America/Chicago";
        final String iata = "DFW";
        final String icao = "KDFW";
        final String terminal = "A";
        final String gate = "A22";
        final String baggage = "A17";
        final Integer delay = 0;
        final LocalDateTime scheduled = LocalDateTime.now();
        final LocalDateTime estimated = LocalDateTime.now();

        FlightItinerary arrival = new FlightItinerary(airport, timezone, iata, icao, terminal, gate, baggage, delay,
                scheduled, estimated, null, null, null);

        assertNotNull(arrival);
        assertEquals(airport, arrival.airport());
        assertEquals(timezone, arrival.timezone());
        assertEquals(iata, arrival.iata());
        assertEquals(icao, arrival.icao());
        assertEquals(terminal, arrival.terminal());
        assertEquals(gate, arrival.gate());
        assertEquals(baggage, arrival.baggage());
        assertEquals(delay, arrival.delay());
        assertEquals(scheduled, arrival.scheduled());
        assertEquals(estimated, arrival.estimated());
        assertNull(arrival.actual());
        assertNull(arrival.estimatedRunway());
        assertNull(arrival.actualRunway());
    }
}
