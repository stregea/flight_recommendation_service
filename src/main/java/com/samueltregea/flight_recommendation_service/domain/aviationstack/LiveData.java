package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

record LiveData(OffsetDateTime updated,
                Double latitude,
                Double longitude,
                Double altitude,
                Double direction,
                @JsonProperty("speed_horizontal") Double speedHorizontal,
                @JsonProperty("speed_vertical") Double speedVertical,
                @JsonProperty("is_ground") Boolean isGround) {
}
