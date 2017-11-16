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
    private Rows[] rows;

    public String[] getDestinationAddresses() {
        return destinationAddresses;
    }

    public String[] getOriginAddresses() {
        return originAddresses;
    }

    public Rows[] getRows() {
        return rows;
    }
}
