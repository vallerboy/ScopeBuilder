package pl.oskarpolak.springsec.models.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.oskarpolak.springsec.models.DistanceModel;

@Service
public class DistanceService {

    @Value("${google.distancematrix.key}")
    String googleKey;

    public DistanceModel getDistance(String from, String to){
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + from + "&destinations=" + to + "&key=" + googleKey;
    }

}
