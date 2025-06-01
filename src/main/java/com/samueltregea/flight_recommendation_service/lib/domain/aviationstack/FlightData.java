package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FlightData(@JsonProperty("flight_date") String flightDate,
                         @JsonProperty("flight_status") String flightStatus,
                         Departure departure,
                         Arrival arrival,
                         Airline airline,
                         Flight flight,
                         Aircraft aircraft,
                         @JsonProperty("live") LiveData liveData) {
}
