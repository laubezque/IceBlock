
package aiss.model.blablacar.search;

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
    "_self",
    "_front"
})
public class Links_ {

    @JsonProperty("_self")
    private String self;
    @JsonProperty("_front")
    private String front;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_self")
    public String getSelf() {
        return self;
    }

    @JsonProperty("_self")
    public void setSelf(String self) {
        this.self = self;
    }

    @JsonProperty("_front")
    public String getFront() {
        return front;
    }

    @JsonProperty("_front")
    public void setFront(String front) {
        this.front = front;
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
