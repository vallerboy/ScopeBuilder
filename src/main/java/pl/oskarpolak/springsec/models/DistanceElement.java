package pl.oskarpolak.springsec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceElement {
    @JsonProperty("distance")
    private Distance distance;

    public Distance getDistance() {
        return distance;
    }
}
