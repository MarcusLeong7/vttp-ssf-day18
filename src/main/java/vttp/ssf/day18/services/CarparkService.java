package vttp.ssf.day18.services;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import vttp.ssf.day18.model.Carpark;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarparkService {

    public static final String CARPARK_API_URL = "https://data.gov.sg/api/action/datastore_search";
    public static final String RESOURCE_ID = "d_9f6056bdb6b1dfba57f063593e4f34ae";

public List<Carpark> getCarparks() {

    // Construct the URL with query parameters
    String url = UriComponentsBuilder
            .fromUriString(CARPARK_API_URL)
            .queryParam("resource_id", RESOURCE_ID)
            .toUriString();

    // Create the GET request
    RequestEntity<Void> request = RequestEntity
            .get(url)
            .accept(MediaType.APPLICATION_JSON)
            .build();

    // Use RestTemplate to send the request
    RestTemplate restTemplate = new RestTemplate();
    List<Carpark> carparks = new ArrayList<>();

    try {
        // Fetch response
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        String payload = response.getBody();
        System.out.println("Received payload");
        // Parse JSON response from a JSON string to JSON object
        JsonObject jsonObj = Json.createReader(new StringReader(payload)).readObject();
        JsonObject result = jsonObj.getJsonObject("result"); // key is result
        JsonArray records = result.getJsonArray("records"); // key is records

        // Loop through each carpark and extract data
        for (int i = 0; i < records.size(); i++) {
            JsonObject data = records.getJsonObject(i); // Each parent carpark

            Carpark carparkDetails = new Carpark();
            carparkDetails.setId(data.getInt("_id"));
            carparkDetails.setCarpark(data.getString("carpark"));
            carparkDetails.setCategory(data.getString("category","-"));
            carparkDetails.setWeekdayRate1(data.getString("weekdays_rate_1","-"));
            carparkDetails.setWeekdayRate2(data.getString("weekdays_rate_2","-"));
            carparkDetails.setSaturdayRate(data.getString("saturday_rate","-"));
            carparkDetails.setSundayPhRate(data.getString("sunday_publicholiday_rate","-"));
            carparks.add(carparkDetails);
        }
        } catch (Exception e) {
        System.err.printf("Error fetching data: %s\n", e.getMessage());
    }

    return carparks;

}



}
