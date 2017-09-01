package airline.model;

import java.awt.datatransfer.FlavorListener;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int capacity;
    private int availableSeats;

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats(){
        return availableSeats;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Flight() {
    
    }

    public Flight(String flightNumber, String source, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.availableSeats = capacity;
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
