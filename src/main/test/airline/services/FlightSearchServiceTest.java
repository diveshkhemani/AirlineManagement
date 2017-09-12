package airline.services;

import airline.model.Airplane;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.viewModels.FlightSearchCriteria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FlightSearchServiceTest {
    List<Flight> flights = new ArrayList<Flight>();
    FlightSearchService flightSearchService;

    @Before
    public void initialize(){
        HashMap<TravelClass,Integer> seats =new HashMap<TravelClass, Integer>();
        seats.put(TravelClass.Economy,10);
        seats.put(TravelClass.Business,3);
        Airplane airplane = new Airplane("TestPlane",seats);
        flights.add(new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane));
        flightSearchService = new FlightSearchService();
    }

    @Test
    public void searchForFlightBetweenIXCAndMUM() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("IXC");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("Economy");
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(1,searchResults.size());
    }

    @Test
    public void searchReturnNoFlightBetweenBLRAndMUM() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("BLR");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("Economy");
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(0,searchResults.size());
    }

    @Test
    public void searchReturnNoFlightBetweenIXCAndMUMForMoreThanAvailableSeats() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("IXC");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("Economy");
        searchCriteria.setNumberOfSeats(100);
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(0,searchResults.size());
    }

    @Test
    public void searchReturnNoFlightBetweenIXCAndMUMForMoreThanUnavailableTravelClass() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("IXC");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("First");
        searchCriteria.setNumberOfSeats(10);
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(0,searchResults.size());
    }

    @Test
    public void searchReturnFlightBetweenIXCAndMUMDepartingToday() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("IXC");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("Economy");
        searchCriteria.setNumberOfSeats(10);
        searchCriteria.setDepartureDate(LocalDate.now().toString());
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(1,searchResults.size());
    }

    @Test
    public void searchReturnNoFlightBetweenIXCAndMUMDepartingTomorrow() throws Exception {
        FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
        searchCriteria.setSource("IXC");
        searchCriteria.setDestination("MUM");
        searchCriteria.setTravelClass("Economy");
        searchCriteria.setNumberOfSeats(100);
        searchCriteria.setDepartureDate(LocalDate.now().plusDays(1).toString());
        List<Flight> searchResults =  flightSearchService.search(flights,searchCriteria);
        Assert.assertEquals(0,searchResults.size());
    }
}