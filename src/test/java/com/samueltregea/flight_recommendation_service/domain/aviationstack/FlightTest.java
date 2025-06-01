package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightTest {

    /**
     * Test the standard Flight record.
     */
    @Test
    public void testFlightRecord() {
        final String number = "2097";
        final String iata = "DL2097";
        final String icao = "DAL2097";
        final Codeshared codeshared = new Codeshared(null, null);

        Flight flight = new Flight(number, iata, icao, codeshared);

        assertNotNull(flight);
        assertNotNull(flight.number());
        assertNotNull(flight.iata());
        assertNotNull(flight.icao());
        assertNotNull(flight.codeshared());
    }
}
