package pl.oskarpolak.springsec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rows {
    @JsonProperty("elements")
    private DistanceElement[] elements;

    public DistanceElement[] getElements() {
        return elements;
    }
}