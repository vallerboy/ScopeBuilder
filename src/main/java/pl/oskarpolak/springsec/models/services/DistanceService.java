package pl.oskarpolak.springsec.models.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.oskarpolak.springsec.models.DistanceModel;

import java.util.HashMap;

@Service
public class DistanceService {

    @Value("${google.distancematrix.key}")
    String googleKey;

    public DistanceModel getDistance(String from, String to){
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + from + "&destinations=" + to + "&key=" + googleKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, DistanceModel.class, new HashMap<>());
    }

}
