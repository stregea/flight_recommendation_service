package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AirlineTest {


    @BeforeEach
    public void setup() {}

    @Test
    public void testAirline() {
        String name = "American Airlines";
        String iata = "AA";
        String icao = "AAL";

        Airline airline = new Airline(name, iata, icao);

        assertNotNull(airline);
        assertEquals(name, airline.name());
        assertEquals(iata, airline.iata());
        assertEquals(icao, airline.icao());
    }
}
