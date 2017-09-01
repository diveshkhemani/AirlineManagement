package airline.services;

import airline.model.Flight;
import airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> search(Flight searchCriteria) {
        flightRepository = new FlightRepository();
        List<Flight> availableFlights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.getFlights()) {
            if (searchCriteria.getSource().equals(flight.getSource()) && searchCriteria.getDestination().equals(flight.getDestination()) && flight.getAvailableSeats()>=searchCriteria.getCapacity())
                availableFlights.add(flight);
        }
        return availableFlights;
    }
}
