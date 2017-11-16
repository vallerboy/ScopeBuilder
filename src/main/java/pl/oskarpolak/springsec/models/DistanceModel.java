package pl.oskarpolak.springsec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceModel {
    @JsonProperty("destination_addresses")
    private String[] destinationAddresses;

    @JsonProperty("origin_addresses")
    private String[] originAddresses;

    @JsonProperty("rows")
    private List<Rows> rows;

    public String[] getDestinationAddresses() {
        return destinationAddresses;
    }

    public String[] getOriginAddresses() {
        return originAddresses;
    }

    public List<Rows> getRows() {
        return rows;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rows {
        @JsonProperty("elements")
        private List<DistanceElement> elements;

        public List<DistanceElement> getElements() {
            return elements;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DistanceElement {
        @JsonProperty("distance")
        private Distance distance;

        public Distance getDistance() {
            return distance;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Distance {
        @JsonProperty("text")
        private String text;

        public String getText() {
            return text;
        }
    }
}
