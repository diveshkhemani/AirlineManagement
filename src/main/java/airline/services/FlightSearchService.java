package airline.services;

import airline.model.Flight;
import airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    private String source;
    private String destination;
    private int numberOfSeats;

    FlightRepository flightRepository;

    public FlightSearchService() {
        this.numberOfSeats = 1;
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


    public List<Flight> search() {
        flightRepository = new FlightRepository();
        List<Flight> availableFlights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.getFlights()) {
            if (source.equals(flight.getSource()) && destination.equals(flight.getDestination()) && flight.getAvailableSeats()>=numberOfSeats)
                availableFlights.add(flight);
        }
        return availableFlights;
    }
}
