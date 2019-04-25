
package aiss.model.blablacar.trip;

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
    "departure_date_iso8601",
    "departure_place",
    "arrival_place",
    "price",
    "price_with_commission",
    "price_without_commission",
    "commission",
    "seats_left",
    "seats",
    "seats_count_origin",
    "duration",
    "distance",
    "permanent_id",
    "main_permanent_id",
    "comment",
    "viaggio_rosa",
    "is_comfort",
    "freeway",
    "stop_overs",
    "bucketing_eligible",
    "booking_mode",
    "booking_type",
    "is_booking_allowed",
    "view_count",
    "cross_border_alert",
    "trip_plan",
    "messaging_status",
    "passengers",
    "display_contact",
    "vehicle_pictures",
    "can_report"
})
public class Example {

    @JsonProperty("links")
    private Links links;
    @JsonProperty("departure_date")
    private String departureDate;
    @JsonProperty("departure_date_iso8601")
    private String departureDateIso8601;
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
    @JsonProperty("seats_count_origin")
    private Integer seatsCountOrigin;
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("distance")
    private Distance distance;
    @JsonProperty("permanent_id")
    private String permanentId;
    @JsonProperty("main_permanent_id")
    private String mainPermanentId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("viaggio_rosa")
    private Boolean viaggioRosa;
    @JsonProperty("is_comfort")
    private Boolean isComfort;
    @JsonProperty("freeway")
    private Boolean freeway;
    @JsonProperty("stop_overs")
    private List<StopOver> stopOvers = null;
    @JsonProperty("bucketing_eligible")
    private Boolean bucketingEligible;
    @JsonProperty("booking_mode")
    private String bookingMode;
    @JsonProperty("booking_type")
    private String bookingType;
    @JsonProperty("is_booking_allowed")
    private Boolean isBookingAllowed;
    @JsonProperty("view_count")
    private Integer viewCount;
    @JsonProperty("cross_border_alert")
    private Boolean crossBorderAlert;
    @JsonProperty("trip_plan")
    private List<TripPlan> tripPlan = null;
    @JsonProperty("messaging_status")
    private String messagingStatus;
    @JsonProperty("passengers")
    private List<Object> passengers = null;
    @JsonProperty("display_contact")
    private Boolean displayContact;
    @JsonProperty("vehicle_pictures")
    private List<Object> vehiclePictures = null;
    @JsonProperty("can_report")
    private Boolean canReport;
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

    @JsonProperty("departure_date")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("departure_date")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @JsonProperty("departure_date_iso8601")
    public String getDepartureDateIso8601() {
        return departureDateIso8601;
    }

    @JsonProperty("departure_date_iso8601")
    public void setDepartureDateIso8601(String departureDateIso8601) {
        this.departureDateIso8601 = departureDateIso8601;
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

    @JsonProperty("seats_count_origin")
    public Integer getSeatsCountOrigin() {
        return seatsCountOrigin;
    }

    @JsonProperty("seats_count_origin")
    public void setSeatsCountOrigin(Integer seatsCountOrigin) {
        this.seatsCountOrigin = seatsCountOrigin;
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

    @JsonProperty("main_permanent_id")
    public String getMainPermanentId() {
        return mainPermanentId;
    }

    @JsonProperty("main_permanent_id")
    public void setMainPermanentId(String mainPermanentId) {
        this.mainPermanentId = mainPermanentId;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
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

    @JsonProperty("stop_overs")
    public List<StopOver> getStopOvers() {
        return stopOvers;
    }

    @JsonProperty("stop_overs")
    public void setStopOvers(List<StopOver> stopOvers) {
        this.stopOvers = stopOvers;
    }

    @JsonProperty("bucketing_eligible")
    public Boolean getBucketingEligible() {
        return bucketingEligible;
    }

    @JsonProperty("bucketing_eligible")
    public void setBucketingEligible(Boolean bucketingEligible) {
        this.bucketingEligible = bucketingEligible;
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

    @JsonProperty("is_booking_allowed")
    public Boolean getIsBookingAllowed() {
        return isBookingAllowed;
    }

    @JsonProperty("is_booking_allowed")
    public void setIsBookingAllowed(Boolean isBookingAllowed) {
        this.isBookingAllowed = isBookingAllowed;
    }

    @JsonProperty("view_count")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("view_count")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("cross_border_alert")
    public Boolean getCrossBorderAlert() {
        return crossBorderAlert;
    }

    @JsonProperty("cross_border_alert")
    public void setCrossBorderAlert(Boolean crossBorderAlert) {
        this.crossBorderAlert = crossBorderAlert;
    }

    @JsonProperty("trip_plan")
    public List<TripPlan> getTripPlan() {
        return tripPlan;
    }

    @JsonProperty("trip_plan")
    public void setTripPlan(List<TripPlan> tripPlan) {
        this.tripPlan = tripPlan;
    }

    @JsonProperty("messaging_status")
    public String getMessagingStatus() {
        return messagingStatus;
    }

    @JsonProperty("messaging_status")
    public void setMessagingStatus(String messagingStatus) {
        this.messagingStatus = messagingStatus;
    }

    @JsonProperty("passengers")
    public List<Object> getPassengers() {
        return passengers;
    }

    @JsonProperty("passengers")
    public void setPassengers(List<Object> passengers) {
        this.passengers = passengers;
    }

    @JsonProperty("display_contact")
    public Boolean getDisplayContact() {
        return displayContact;
    }

    @JsonProperty("display_contact")
    public void setDisplayContact(Boolean displayContact) {
        this.displayContact = displayContact;
    }

    @JsonProperty("vehicle_pictures")
    public List<Object> getVehiclePictures() {
        return vehiclePictures;
    }

    @JsonProperty("vehicle_pictures")
    public void setVehiclePictures(List<Object> vehiclePictures) {
        this.vehiclePictures = vehiclePictures;
    }

    @JsonProperty("can_report")
    public Boolean getCanReport() {
        return canReport;
    }

    @JsonProperty("can_report")
    public void setCanReport(Boolean canReport) {
        this.canReport = canReport;
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
