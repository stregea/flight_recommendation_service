package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AircraftTest {

    /**
     * Test the standard Aircraft record.
     */
    @Test
    public void testAircraft() {
        final String registration = "N160AN";
        final String iata = "A321";
        final String icao = "A321";
        final String icao24 = "A0F1BB";

        Aircraft aircraft = new Aircraft(registration, iata, icao, icao24);

        assertNotNull(aircraft);
        assertEquals(registration, aircraft.registration());
        assertEquals(iata, aircraft.iata());
        assertEquals(icao, aircraft.icao());
        assertEquals(icao24, aircraft.icao24());
    }
}
