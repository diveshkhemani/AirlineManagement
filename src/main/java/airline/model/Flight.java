package airline.model;

import airline.repositories.AirplaneRepository;
import java.time.LocalDate;


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

    public String getFlightNumber() { return flightNumber; }

    public String getSource() { return source; }

    public String getDestination() { return destination; }

    public LocalDate getDepartureDate() { return departureDate; }

    public boolean startsFrom(String source){ return this.source.equals(source); }

    public boolean goesTo(String destination){ return  this.destination.equals(destination); }

    public int getSeatsByClass(TravelClass travelClass) { return airplane.getSeatsByClass(travelClass); }

    public String getAirPlaneName() { return airplane.getAirPlaneName(); }

    public boolean fliesOn(LocalDate journeyDate){ return departureDate.isEqual(journeyDate);}

    public int getSeatsByClass(String travelClass){ return getSeatsByClass(TravelClass.valueOf(travelClass)); }

}
