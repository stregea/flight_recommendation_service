package com.samueltregea.flight_recommendation_service.lib.domain.aviationstack;

public record Pagination(Integer limit, Integer offset, Integer count, Integer total) {
}
