package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AirlineTest {

    /**
     * Test the standard Airline record.
     */
    @Test
    public void testAirline() {
        final String name = "Delta Air Lines";
        final String iata = "DL";
        final String icao = "DAL";

        Airline airline = new Airline(name, iata, icao);

        assertNotNull(airline);
        assertEquals(name, airline.name());
        assertEquals(iata, airline.iata());
        assertEquals(icao, airline.icao());
    }
}
