package airline.viewModels;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FlightSearchCriteria {
    private String source;
    private String destination;
    private String travelClass;
    private int numberOfSeats;
    private final int DEFAULT_NUMBER_OF_SEAT = 1;
    private LocalDate departureDate;

    public FlightSearchCriteria() {
        this.numberOfSeats = DEFAULT_NUMBER_OF_SEAT;
        this.departureDate = LocalDate.now();
    }

    public String getDepartureDate() {
        return departureDate != null ? departureDate.toString() : null;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate.equals("") ? null : LocalDate.parse(departureDate);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setTravelClass(String travelClass) { this.travelClass = travelClass; }

    public String getTravelClass() { return travelClass; }
}