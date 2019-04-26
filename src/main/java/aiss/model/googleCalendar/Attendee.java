
package aiss.model.googleCalendar;

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
    "email",
    "self",
    "responseStatus"
})
public class Attendee {

    @JsonProperty("email")
    private String email;
    @JsonProperty("self")
    private Boolean self;
    @JsonProperty("responseStatus")
    private String responseStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("self")
    public Boolean getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Boolean self) {
        this.self = self;
    }

    @JsonProperty("responseStatus")
    public String getResponseStatus() {
        return responseStatus;
    }

    @JsonProperty("responseStatus")
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
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
