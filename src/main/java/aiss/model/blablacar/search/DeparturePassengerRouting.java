
package aiss.model.blablacar.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "proximity",
    "routes"
})
public class DeparturePassengerRouting {

    @JsonProperty("proximity")
    private String proximity;
    @JsonProperty("routes")
    private List<Route> routes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("proximity")
    public String getProximity() {
        return proximity;
    }

    @JsonProperty("proximity")
    public void setProximity(String proximity) {
        this.proximity = proximity;
    }

    @JsonProperty("routes")
    public List<Route> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
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
