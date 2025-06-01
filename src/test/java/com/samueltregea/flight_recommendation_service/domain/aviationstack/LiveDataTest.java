package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LiveDataTest {

    /**
     * Test the standard LiveData record.
     */
    @Test
    public void testLiveData() {
        final OffsetDateTime updated = OffsetDateTime.now();
        final Double latitude = 36.28560000;
        final Double longitude = -106.80700000;
        final Double altitude = 8846.820;
        final Double direction = 114.340;
        final Double speedHorizontal = 894.348;
        final Double speedVertical = 1.188;
        final Boolean isGround = false;

        LiveData liveData = new LiveData(updated, latitude, longitude, altitude, direction, speedHorizontal, speedVertical, isGround);

        assertNotNull(liveData);
        assertEquals(updated, liveData.updated());
        assertEquals(latitude, liveData.latitude());
        assertEquals(longitude, liveData.longitude());
        assertEquals(altitude, liveData.altitude());
        assertEquals(direction, liveData.direction());
        assertEquals(speedHorizontal, liveData.speedHorizontal());
        assertEquals(speedVertical, liveData.speedVertical());
        assertEquals(isGround, liveData.isGround());
    }
}
