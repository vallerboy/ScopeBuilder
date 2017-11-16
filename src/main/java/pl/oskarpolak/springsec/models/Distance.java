package pl.oskarpolak.springsec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Distance {
    @JsonProperty("text")
    private String text;

    public String getText() {
        return text;
    }
}