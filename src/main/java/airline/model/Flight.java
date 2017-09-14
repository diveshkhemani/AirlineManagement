package airline.model;

import airline.repositories.AirplaneRepository;
import java.time.LocalDate;
import java.util.Arrays;


public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private Airplane airplane;
    private LocalDate departureDate;

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

    public boolean isValidTravelClass(String travelClass) {
        return Arrays.stream(TravelClass.values()).anyMatch(e -> e.name().equals(travelClass));
    };

    public boolean hasAvailableByClass(String travelClass, int requiredSeats){
        if(!travelClass.isEmpty() && isValidTravelClass(travelClass) && airplane.hasTravelClass(TravelClass.valueOf(travelClass))){
            return requiredSeats <= airplane.getSeatsByClass(TravelClass.valueOf(travelClass)).getAvailableSeats();
        }
        else
            return false;
    }

    public int getAvailableSeatsByClass(TravelClass travelClass){
        if(isValidTravelClass(travelClass.toString()) && airplane.hasTravelClass(travelClass)){
            return airplane.getSeatsByClass(travelClass).getAvailableSeats();
        }
        else
            return 0;
    }

    public int getTotalSeatsByClass(TravelClass travelClass){
        if(isValidTravelClass(travelClass.toString()) && airplane.hasTravelClass(travelClass)){
            return airplane.getSeatsByClass(travelClass).getTotalSeats();
        }
        else
            return 0;
    }

    public int getSeatsByClass(String travelClass){
        if(!travelClass.isEmpty() && isValidTravelClass(travelClass) && airplane.hasTravelClass(TravelClass.valueOf(travelClass))){
            return airplane.getSeatsByClass(TravelClass.valueOf(travelClass)).getAvailableSeats();
        }
        else
            return 0;
    }

    public double getPriceByClass(TravelClass travelClass)
    {
        return airplane.getSeatsByClass(travelClass).getbasePrice();
    }

    public String getAirPlaneName() { return airplane.getAirPlaneName(); }

    // Required in Views
    public String getFlightNumber() { return flightNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDate getDepartureDate() { return departureDate; }

}
