
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
    "links",
    "pager",
    "trips",
    "top_trips",
    "facets",
    "lowest_price",
    "lowest_price_object",
    "full_trips_count",
    "total_trip_count_to_display",
    "sorting_algorithm"
})
public class Example {

    @JsonProperty("links")
    private Links links;
    @JsonProperty("pager")
    private Pager pager;
    @JsonProperty("trips")
    private List<Trip> trips = null;
    @JsonProperty("top_trips")
    private List<Object> topTrips = null;
    @JsonProperty("facets")
    private List<Facet> facets = null;
    @JsonProperty("lowest_price")
    private Integer lowestPrice;
    @JsonProperty("lowest_price_object")
    private LowestPriceObject lowestPriceObject;
    @JsonProperty("full_trips_count")
    private Integer fullTripsCount;
    @JsonProperty("total_trip_count_to_display")
    private Integer totalTripCountToDisplay;
    @JsonProperty("sorting_algorithm")
    private String sortingAlgorithm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("pager")
    public Pager getPager() {
        return pager;
    }

    @JsonProperty("pager")
    public void setPager(Pager pager) {
        this.pager = pager;
    }

    @JsonProperty("trips")
    public List<Trip> getTrips() {
        return trips;
    }

    @JsonProperty("trips")
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @JsonProperty("top_trips")
    public List<Object> getTopTrips() {
        return topTrips;
    }

    @JsonProperty("top_trips")
    public void setTopTrips(List<Object> topTrips) {
        this.topTrips = topTrips;
    }

    @JsonProperty("facets")
    public List<Facet> getFacets() {
        return facets;
    }

    @JsonProperty("facets")
    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

    @JsonProperty("lowest_price")
    public Integer getLowestPrice() {
        return lowestPrice;
    }

    @JsonProperty("lowest_price")
    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @JsonProperty("lowest_price_object")
    public LowestPriceObject getLowestPriceObject() {
        return lowestPriceObject;
    }

    @JsonProperty("lowest_price_object")
    public void setLowestPriceObject(LowestPriceObject lowestPriceObject) {
        this.lowestPriceObject = lowestPriceObject;
    }

    @JsonProperty("full_trips_count")
    public Integer getFullTripsCount() {
        return fullTripsCount;
    }

    @JsonProperty("full_trips_count")
    public void setFullTripsCount(Integer fullTripsCount) {
        this.fullTripsCount = fullTripsCount;
    }

    @JsonProperty("total_trip_count_to_display")
    public Integer getTotalTripCountToDisplay() {
        return totalTripCountToDisplay;
    }

    @JsonProperty("total_trip_count_to_display")
    public void setTotalTripCountToDisplay(Integer totalTripCountToDisplay) {
        this.totalTripCountToDisplay = totalTripCountToDisplay;
    }

    @JsonProperty("sorting_algorithm")
    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    @JsonProperty("sorting_algorithm")
    public void setSortingAlgorithm(String sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
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
