
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
    "id",
    "model",
    "make",
    "comfort",
    "comfort_nb_star",
    "category"
})
public class Car {

    @JsonProperty("id")
    private String id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("make")
    private String make;
    @JsonProperty("comfort")
    private String comfort;
    @JsonProperty("comfort_nb_star")
    private Integer comfortNbStar;
    @JsonProperty("category")
    private String category;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("comfort")
    public String getComfort() {
        return comfort;
    }

    @JsonProperty("comfort")
    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    @JsonProperty("comfort_nb_star")
    public Integer getComfortNbStar() {
        return comfortNbStar;
    }

    @JsonProperty("comfort_nb_star")
    public void setComfortNbStar(Integer comfortNbStar) {
        this.comfortNbStar = comfortNbStar;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
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
