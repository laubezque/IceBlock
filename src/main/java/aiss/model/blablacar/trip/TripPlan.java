
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
    "date",
    "city",
    "address",
    "latitude",
    "longitude",
    "country_code",
    "meeting_point_id",
    "vinci_shuttle_enabled"
})
public class TripPlan {

    @JsonProperty("date")
    private String date;
    @JsonProperty("city")
    private String city;
    @JsonProperty("address")
    private String address;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("meeting_point_id")
    private Integer meetingPointId;
    @JsonProperty("vinci_shuttle_enabled")
    private Boolean vinciShuttleEnabled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
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

    @JsonProperty("meeting_point_id")
    public Integer getMeetingPointId() {
        return meetingPointId;
    }

    @JsonProperty("meeting_point_id")
    public void setMeetingPointId(Integer meetingPointId) {
        this.meetingPointId = meetingPointId;
    }

    @JsonProperty("vinci_shuttle_enabled")
    public Boolean getVinciShuttleEnabled() {
        return vinciShuttleEnabled;
    }

    @JsonProperty("vinci_shuttle_enabled")
    public void setVinciShuttleEnabled(Boolean vinciShuttleEnabled) {
        this.vinciShuttleEnabled = vinciShuttleEnabled;
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
