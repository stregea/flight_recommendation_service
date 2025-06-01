package com.samueltregea.flight_recommendation_service.service;

import com.samueltregea.flight_recommendation_service.api.aviationstack.FlightResponse;
import com.samueltregea.flight_recommendation_service.domain.aviationstack.FlightData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Service that will allow the FlightRecommendationController to communicate with the
 * AviationStack API.
 */
@Service
public class AviationStackService {

    private static final Logger LOG = LogManager.getLogger(AviationStackService.class);

    @Value("${api.keys.aviationstack}")
    private String API_KEY;

    private final RestClient restClient;

    @Autowired
    public AviationStackService(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Reach out to the AviationStackService API's /flights endpoint.
     *
     * @param departingAirport - The airport to depart from.
     * @param arrivingAirport  - The airport to arrive at.
     * @return A list of flights.
     */
    public List<FlightData> getFlights(String departingAirport, String arrivingAirport) {
        LOG.info("-> getFlights");
        final String url = "http://api.aviationstack.com/v1/flights";
        List<FlightData> flights = null;
        try {
            LOG.info("Beginning connection to the AviationStack API with parameters: departingAirport={}, arrivingAirport={}",
                    departingAirport, arrivingAirport);

            LOG.info("Beginning request to the {} endpoint.", url);

            // Build the API url and make the request.
            // todo: create function to dynamically create query string
            FlightResponse response = restClient.get()
                    .uri(url + "?access_key={key}&dep_iata={dep}&arr_iata={arr}&flight_status=scheduled", API_KEY, departingAirport, arrivingAirport)
                    .retrieve().
                    body(FlightResponse.class);

            if (response != null) {
                flights = response.data();
            }

            LOG.info("Response Received: {}", response);

        } catch (Exception e) {
            LOG.error("There was an error while communicating with AviationStack.");
            LOG.error(e);
        }

        LOG.info("<- getFlights");
        return flights;
    }
}
