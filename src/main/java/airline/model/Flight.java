package airline.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;


public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private Airplane airplane;
    private LocalDate departureDate;
    private final DayOfWeek[] POPULAR_DAYS_TO_FLY = new DayOfWeek[] {DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY};

    public Flight(String flightNumber, String source, String destination,LocalDate departureDate, Airplane airplane) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.airplane= airplane;
    }

    private boolean startsFrom(String source){ return this.source.equals(source); }

    private boolean goesTo(String destination){ return  this.destination.equals(destination); }

    public boolean hasRoute(String source, String destination){
        return startsFrom(source) && goesTo(destination);
    }

    public boolean fliesOn(LocalDate journeyDate){ return departureDate.isEqual(journeyDate);}

    //Smell : Not sure where to add this method;
    //do : Make a util class if needed
    public boolean isValidTravelClass(String travelClass) {
        return Arrays.stream(TravelClass.values()).anyMatch(e -> e.name().equals(travelClass));
    }

    public boolean hasAvailableSeatsByClass(String travelClass, int requiredSeats){
        if(isValidTravelClass(travelClass)){
            return requiredSeats <= airplane.getAvailableSeatsByClass(TravelClass.valueOf(travelClass));
        }
        else
            return false;
    }

    public int getSeatsByClass(String travelClass){
        return isValidTravelClass(travelClass) ?
                airplane.getAvailableSeatsByClass(TravelClass.valueOf(travelClass)) :
                0;
    }

    public boolean departsOnPopularDays(){
        return Arrays.asList(POPULAR_DAYS_TO_FLY).contains(departureDate.getDayOfWeek());
    }

    // Proxy Methods for Airplane
    public int getAvailableSeatsByClass(TravelClass travelClass){
        return airplane.getAvailableSeatsByClass(travelClass);
    }

    public int getTotalSeatsByClass(TravelClass travelClass){
        return airplane.getTotalSeatsByClass(travelClass);
    }

    public double getPriceByClass(TravelClass travelClass)
    {
        return airplane.getBasePriceByClass(travelClass);
    }

    public String getAirPlaneName() {
        return airplane.getAirPlaneName();
    }

    // Required in Views
    public String getFlightNumber() { return flightNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDate getDepartureDate() { return departureDate; }

}
