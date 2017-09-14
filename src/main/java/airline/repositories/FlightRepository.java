package airline.repositories;

import airline.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    AirplaneRepository airplaneRepository = new AirplaneRepository();

    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("AF1465", "HYD", "BLR",  LocalDate.now(),airplaneRepository.getAirplaneByName("Boeing777-200LR(77L)"));
        Flight flight2 = new Flight("AF2897", "HYD", "PUN", LocalDate.now().plusDays(1),airplaneRepository.getAirplaneByName("AirBus-A319-V2"));
        Flight flight3 = new Flight("AF4513", "BLR", "PUN",  LocalDate.now().plusDays(3),airplaneRepository.getAirplaneByName("Boeing777-200LR(77L)"));
        Flight flight4 = new Flight("AF5784", "HYD", "BLR", LocalDate.now().plusDays(15),airplaneRepository.getAirplaneByName("AirBus-A321"));

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }
}
