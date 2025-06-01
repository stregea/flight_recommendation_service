package com.samueltregea.flight_recommendation_service.domain.aviationstack;

public record Flight(String airline, String flightNumber, String departureAirport,
                     String arrivalAirport, String status, String departureTime)  {
}
