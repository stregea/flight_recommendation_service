package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightDataTest {

    /**
     * Test the standard FlightData record.
     */
    @Test
    public void testFlightData() {
        final String flightDate = "2025-06-01";
        final String flightStatus = "scheduled";
        final Departure departure = new Departure(null, null, null, null, null,
                null, null, null, null, null, null, null);
        final Arrival arrival = new Arrival(null, null, null, null, null, null,
                null, null, null, null, null, null, null);
        final Airline airline = new Airline(null, null, null);
        final Flight flight = new Flight(null, null, null, null);
        final Aircraft aircraft = new Aircraft(null, null, null, null);
        final LiveData liveData = new LiveData(null, null, null, null, null,
                null, null, null);

        FlightData flightData = new FlightData(flightDate, flightStatus, departure, arrival, airline, flight, aircraft, liveData);

        assertNotNull(flightData);
        assertEquals(flightDate, flightData.flightDate());
        assertEquals(flightStatus, flightData.flightStatus());
        assertEquals(departure, flightData.departure());
        assertEquals(arrival, flightData.arrival());
        assertEquals(airline, flightData.airline());
        assertEquals(flight, flightData.flight());
        assertEquals(aircraft, flightData.aircraft());
        assertEquals(liveData, flightData.liveData());
    }
}
