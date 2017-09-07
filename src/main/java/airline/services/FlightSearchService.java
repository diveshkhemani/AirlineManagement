package airline.services;

import airline.model.Flight;
import airline.model.TravelClass;
import airline.viewModels.FlightSearchCriteria;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;


public class FlightSearchService {


    public List<Flight> search(List<Flight> flightList, FlightSearchCriteria searchCriteria) {

        Stream<Flight> filteredFlights =  flightList.stream()
                .filter(searchByRoute(flightList, searchCriteria)) //mandatory
                .filter(searchByTravelType(flightList, searchCriteria));

        if(searchCriteria.getDepartureDate() != null)  //optional
            filteredFlights = filteredFlights.filter(searchByDepartureDate(flightList, searchCriteria));


        return filteredFlights.collect(Collectors.toList());

    }

    private Predicate<Flight> searchByRoute(List<Flight> flights, FlightSearchCriteria searchCriteria) {
        return (flight -> (flight.startsFrom(searchCriteria.getSource()) && flight.goesTo(searchCriteria.getDestination())));
    }

    private Predicate<Flight> searchByDepartureDate(List<Flight> flights, FlightSearchCriteria searchCriteria) {
        return (flight -> (flight.fliesOn(LocalDate.parse(searchCriteria.getDepartureDate()))));
    }

    private Predicate<Flight> searchByTravelType(List<Flight> flights, FlightSearchCriteria searchCriteria) {
       return flight -> flight.getSeatsByClass(TravelClass.valueOf(searchCriteria.getTravelClass())) >= searchCriteria.getNumberOfSeats();
    }
}


