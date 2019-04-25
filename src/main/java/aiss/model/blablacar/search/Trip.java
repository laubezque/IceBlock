
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
    "departure_date",
    "departure_place",
    "arrival_place",
    "price",
    "price_with_commission",
    "price_without_commission",
    "commission",
    "seats_left",
    "seats",
    "duration",
    "distance",
    "permanent_id",
    "multimodal_id",
    "viaggio_rosa",
    "is_comfort",
    "freeway",
    "answer_delay",
    "booking_mode",
    "booking_type",
    "locations_to_display",
    "departure_passenger_routing",
    "corridoring_type",
    "vehicle_pictures",
    "departure_meeting_point",
    "car"
})
public class Trip {

    @JsonProperty("links")
    private Links_ links;
    @JsonProperty("departure_date")
    private String departureDate;
    @JsonProperty("departure_place")
    private DeparturePlace departurePlace;
    @JsonProperty("arrival_place")
    private ArrivalPlace arrivalPlace;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("price_with_commission")
    private PriceWithCommission priceWithCommission;
    @JsonProperty("price_without_commission")
    private PriceWithoutCommission priceWithoutCommission;
    @JsonProperty("commission")
    private Commission commission;
    @JsonProperty("seats_left")
    private Integer seatsLeft;
    @JsonProperty("seats")
    private Integer seats;
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("distance")
    private Distance distance;
    @JsonProperty("permanent_id")
    private String permanentId;
    @JsonProperty("multimodal_id")
    private MultimodalId multimodalId;
    @JsonProperty("viaggio_rosa")
    private Boolean viaggioRosa;
    @JsonProperty("is_comfort")
    private Boolean isComfort;
    @JsonProperty("freeway")
    private Boolean freeway;
    @JsonProperty("answer_delay")
    private Integer answerDelay;
    @JsonProperty("booking_mode")
    private String bookingMode;
    @JsonProperty("booking_type")
    private String bookingType;
    @JsonProperty("locations_to_display")
    private List<String> locationsToDisplay = null;
    @JsonProperty("departure_passenger_routing")
    private DeparturePassengerRouting departurePassengerRouting;
    @JsonProperty("corridoring_type")
    private String corridoringType;
    @JsonProperty("vehicle_pictures")
    private List<Object> vehiclePictures = null;
    @JsonProperty("departure_meeting_point")
    private DepartureMeetingPoint departureMeetingPoint;
    @JsonProperty("car")
    private Car car;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("links")
    public Links_ getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links_ links) {
        this.links = links;
    }

    @JsonProperty("departure_date")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("departure_date")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @JsonProperty("departure_place")
    public DeparturePlace getDeparturePlace() {
        return departurePlace;
    }

    @JsonProperty("departure_place")
    public void setDeparturePlace(DeparturePlace departurePlace) {
        this.departurePlace = departurePlace;
    }

    @JsonProperty("arrival_place")
    public ArrivalPlace getArrivalPlace() {
        return arrivalPlace;
    }

    @JsonProperty("arrival_place")
    public void setArrivalPlace(ArrivalPlace arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("price_with_commission")
    public PriceWithCommission getPriceWithCommission() {
        return priceWithCommission;
    }

    @JsonProperty("price_with_commission")
    public void setPriceWithCommission(PriceWithCommission priceWithCommission) {
        this.priceWithCommission = priceWithCommission;
    }

    @JsonProperty("price_without_commission")
    public PriceWithoutCommission getPriceWithoutCommission() {
        return priceWithoutCommission;
    }

    @JsonProperty("price_without_commission")
    public void setPriceWithoutCommission(PriceWithoutCommission priceWithoutCommission) {
        this.priceWithoutCommission = priceWithoutCommission;
    }

    @JsonProperty("commission")
    public Commission getCommission() {
        return commission;
    }

    @JsonProperty("commission")
    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    @JsonProperty("seats_left")
    public Integer getSeatsLeft() {
        return seatsLeft;
    }

    @JsonProperty("seats_left")
    public void setSeatsLeft(Integer seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    @JsonProperty("seats")
    public Integer getSeats() {
        return seats;
    }

    @JsonProperty("seats")
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonProperty("distance")
    public Distance getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    @JsonProperty("permanent_id")
    public String getPermanentId() {
        return permanentId;
    }

    @JsonProperty("permanent_id")
    public void setPermanentId(String permanentId) {
        this.permanentId = permanentId;
    }

    @JsonProperty("multimodal_id")
    public MultimodalId getMultimodalId() {
        return multimodalId;
    }

    @JsonProperty("multimodal_id")
    public void setMultimodalId(MultimodalId multimodalId) {
        this.multimodalId = multimodalId;
    }

    @JsonProperty("viaggio_rosa")
    public Boolean getViaggioRosa() {
        return viaggioRosa;
    }

    @JsonProperty("viaggio_rosa")
    public void setViaggioRosa(Boolean viaggioRosa) {
        this.viaggioRosa = viaggioRosa;
    }

    @JsonProperty("is_comfort")
    public Boolean getIsComfort() {
        return isComfort;
    }

    @JsonProperty("is_comfort")
    public void setIsComfort(Boolean isComfort) {
        this.isComfort = isComfort;
    }

    @JsonProperty("freeway")
    public Boolean getFreeway() {
        return freeway;
    }

    @JsonProperty("freeway")
    public void setFreeway(Boolean freeway) {
        this.freeway = freeway;
    }

    @JsonProperty("answer_delay")
    public Integer getAnswerDelay() {
        return answerDelay;
    }

    @JsonProperty("answer_delay")
    public void setAnswerDelay(Integer answerDelay) {
        this.answerDelay = answerDelay;
    }

    @JsonProperty("booking_mode")
    public String getBookingMode() {
        return bookingMode;
    }

    @JsonProperty("booking_mode")
    public void setBookingMode(String bookingMode) {
        this.bookingMode = bookingMode;
    }

    @JsonProperty("booking_type")
    public String getBookingType() {
        return bookingType;
    }

    @JsonProperty("booking_type")
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    @JsonProperty("locations_to_display")
    public List<String> getLocationsToDisplay() {
        return locationsToDisplay;
    }

    @JsonProperty("locations_to_display")
    public void setLocationsToDisplay(List<String> locationsToDisplay) {
        this.locationsToDisplay = locationsToDisplay;
    }

    @JsonProperty("departure_passenger_routing")
    public DeparturePassengerRouting getDeparturePassengerRouting() {
        return departurePassengerRouting;
    }

    @JsonProperty("departure_passenger_routing")
    public void setDeparturePassengerRouting(DeparturePassengerRouting departurePassengerRouting) {
        this.departurePassengerRouting = departurePassengerRouting;
    }

    @JsonProperty("corridoring_type")
    public String getCorridoringType() {
        return corridoringType;
    }

    @JsonProperty("corridoring_type")
    public void setCorridoringType(String corridoringType) {
        this.corridoringType = corridoringType;
    }

    @JsonProperty("vehicle_pictures")
    public List<Object> getVehiclePictures() {
        return vehiclePictures;
    }

    @JsonProperty("vehicle_pictures")
    public void setVehiclePictures(List<Object> vehiclePictures) {
        this.vehiclePictures = vehiclePictures;
    }

    @JsonProperty("departure_meeting_point")
    public DepartureMeetingPoint getDepartureMeetingPoint() {
        return departureMeetingPoint;
    }

    @JsonProperty("departure_meeting_point")
    public void setDepartureMeetingPoint(DepartureMeetingPoint departureMeetingPoint) {
        this.departureMeetingPoint = departureMeetingPoint;
    }

    @JsonProperty("car")
    public Car getCar() {
        return car;
    }

    @JsonProperty("car")
    public void setCar(Car car) {
        this.car = car;
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
