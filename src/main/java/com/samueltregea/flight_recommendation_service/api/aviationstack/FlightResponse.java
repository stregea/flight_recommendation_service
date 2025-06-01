package com.samueltregea.flight_recommendation_service.api.aviationstack;

import com.samueltregea.flight_recommendation_service.domain.aviationstack.FlightData;
import com.samueltregea.flight_recommendation_service.domain.aviationstack.Pagination;

import java.util.List;

public record FlightResponse(Pagination pagination, List<FlightData> data) {
}