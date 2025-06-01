package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CodesharedTest {

    /**
     * Test the standard Codeshared record.
     */
    @Test
    public void testCodeshared() {
        final Airline airline = new Airline(null, null, null);
        final Flight flight = new Flight(null, null, null, null);

        Codeshared codeshared = new Codeshared(airline, flight);

        assertNotNull(codeshared);
        assertEquals(airline, codeshared.airline());
        assertEquals(flight, codeshared.flight());
    }
}
