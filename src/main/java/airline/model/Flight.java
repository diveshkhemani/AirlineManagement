package airline.model;

import java.awt.datatransfer.FlavorListener;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int availableSeats;
    private Airplane airplane;

    public int getCapacity() {
        return airplane.getCapacity();
    }

    public int getAvailableSeats(){
        return availableSeats;
    }

    public Flight() {
    
    }

    public Flight(String flightNumber, String source, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.availableSeats = capacity;
        this.airplane = new Airplane(capacity);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
}
