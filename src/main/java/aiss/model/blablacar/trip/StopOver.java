
package aiss.model.blablacar.trip;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city_name",
    "address",
    "latitude",
    "longitude",
    "country_code",
    "departure_place",
    "arrival_place"
})
public class StopOver {

    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("departure_place")
    private Boolean departurePlace;
    @JsonProperty("arrival_place")
    private Boolean arrivalPlace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("departure_place")
    public Boolean getDeparturePlace() {
        return departurePlace;
    }

    @JsonProperty("departure_place")
    public void setDeparturePlace(Boolean departurePlace) {
        this.departurePlace = departurePlace;
    }

    @JsonProperty("arrival_place")
    public Boolean getArrivalPlace() {
        return arrivalPlace;
    }

    @JsonProperty("arrival_place")
    public void setArrivalPlace(Boolean arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
