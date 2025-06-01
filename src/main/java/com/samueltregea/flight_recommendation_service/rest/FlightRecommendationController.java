package com.samueltregea.flight_recommendation_service.rest;

import com.samueltregea.flight_recommendation_service.lib.domain.aviationstack.FlightData;
import com.samueltregea.flight_recommendation_service.service.AviationStackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightRecommendationController {
    private static final Logger LOG = LogManager.getLogger(FlightRecommendationController.class);

    @Autowired
    private final AviationStackService aviationStackService;

    @Autowired
    public FlightRecommendationController(AviationStackService aviationStackService) {
        this.aviationStackService = aviationStackService;
    }

    @GetMapping("/api/flights")
    public List<FlightData> getFlights(@RequestParam String departure, @RequestParam String arrival) {
        // Mock data for demonstration
        List<FlightData> flights = null;
        LOG.info("-> getFlights");
        flights = aviationStackService.getFlights(departure, arrival);
        LOG.info("<- getFlights");
        return flights;
    }
}
