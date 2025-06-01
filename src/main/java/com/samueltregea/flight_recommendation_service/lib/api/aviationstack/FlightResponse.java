package com.samueltregea.flight_recommendation_service.lib.api.aviationstack;

import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.FlightData;
import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.Pagination;

import java.util.List;

public record FlightResponse(Pagination pagination, List<FlightData> data) {
}