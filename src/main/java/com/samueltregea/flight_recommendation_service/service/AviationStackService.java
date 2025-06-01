package com.samueltregea.flight_recommendation_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samueltregea.flight_recommendation_service.domain.aviationstack.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
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
    private final ObjectMapper objectMapper;

    @Autowired
    public AviationStackService(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    /**
     * Reach out to the AviationStackService API's /flights endpoint.
     *
     * @param departingAirport - The airport to depart from.
     * @param arrivingAirport  - The airport to arrive at.
     * @return A list of flights.
     */
    public List<Flight> getFlights(String departingAirport, String arrivingAirport) {
        LOG.info("-> getFlights");
        final String url = "http://api.aviationstack.com/v1/flights";
        List<Flight> flights = null;
        try {
            LOG.info("Beginning connection to the AviationStack API with parameters: departingAirport={}, arrivingAirport={}",
                    departingAirport, arrivingAirport);

            // Build the API url and make the request.
            // todo: create function to dynamically create query string
            String response = restClient.get().uri(url + "?access_key={key}&dep_iata={dep}&arr_iata={arr}&flight_status=scheduled",
                    API_KEY, departingAirport, arrivingAirport).retrieve().body(String.class);

            LOG.info("Response Received: {}", response);

            // Parse the response.
            flights = readFlights(objectMapper.readTree(response));

        } catch (Exception e) {
            LOG.error("There was an error while communicating with AviationStack.");
            LOG.error(e);
        }

        LOG.info("<- getFlights");
        return flights;
    }

    /**
     * Construct a list of flights based on a
     *
     * @param root - The root JsonNode.
     * @return a list of flights.
     */
    private List<Flight> readFlights(JsonNode root) {
        List<Flight> flights = new ArrayList<>();
        JsonNode flightData = root.path("data");

        for (JsonNode node : flightData) {
            flights.add(readFlight(node));
        }

        return flights;
    }

    /**
     * Construct a Flight record based on a JsonNode.
     *
     * @param node - The node to construct the Flight record from.
     * @return a Flight record.
     */
    private Flight readFlight(JsonNode node) {
        final String airline = node.path("airline").path("name").asText();
        final String flightNumber = node.path("flight").path("number").asText();
        final String departureAirport = node.path("departure").path("airport").asText();
        final String arrivalAirport = node.path("arrival").path("airport").asText();
        final String status = node.path("flight_status").asText();
        final String departureTime = node.path("departure").path("scheduled").asText();

        return new Flight(airline, flightNumber, departureAirport, arrivalAirport, status, departureTime);
    }
}
