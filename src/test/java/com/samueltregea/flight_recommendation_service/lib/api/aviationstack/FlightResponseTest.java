package com.samueltregea.flight_recommendation_service.lib.api.aviationstack;

import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.FlightData;
import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.Pagination;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightResponseTest {

    /**
     * Test the standard FlightResponse record.
     */
    @Test
    public void testFlightResponse() {
        final Pagination pagination = new Pagination(100, 0, 1, 1);
        final List<FlightData> data = List.of(
                new FlightData(null, null, null, null, null, null, null, null)
        );

        FlightResponse flightResponse = new FlightResponse(pagination, data);

        assertNotNull(flightResponse);
        assertEquals(pagination, flightResponse.pagination());
        assertEquals(data, flightResponse.data());
        assertEquals(1, flightResponse.data().size());
    }
}
