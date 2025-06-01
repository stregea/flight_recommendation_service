package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record Arrival(String airport,
                      String timezone,
                      String iata,
                      String icao,
                      String terminal,
                      String gate,
                      String baggage,
                      Integer delay,
                      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") OffsetDateTime scheduled,
                      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") OffsetDateTime estimated,
                      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") OffsetDateTime actual,
                      @JsonProperty("estimated_runway") @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") OffsetDateTime estimatedRunway,
                      @JsonProperty("actual_runway") @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") OffsetDateTime actualRunway) {
}
