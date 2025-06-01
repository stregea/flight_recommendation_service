package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import java.time.LocalDateTime;

public record FlightItinerary(String airport, String timezone, String iata, String icao, String terminal, String gate,
                              String baggage, Integer delay, LocalDateTime scheduled, LocalDateTime estimated,
                              LocalDateTime actual, LocalDateTime estimatedRunway, LocalDateTime actualRunway) {
}
