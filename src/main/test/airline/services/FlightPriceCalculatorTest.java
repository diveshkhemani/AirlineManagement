package airline.services;

import airline.model.Airplane;
import airline.model.Flight;
import airline.model.Seat;
import airline.model.TravelClass;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FlightPriceCalculatorTest {
    Flight flight;
    FlightPriceCalculator flightPriceCalculator;

    @Before
    public void initialize(){
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,10,10));
        testSeats.add(new Seat(TravelClass.Business,10,30,3));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        flightPriceCalculator = new FlightPriceCalculator();
    }

    @Test
    public void shouldReturnPriceFor1PersonForEconomyClass() throws Exception {
        Assert.assertEquals(40,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturnPriceFor2PersonForEconomyClass() throws Exception {
        Assert.assertEquals(80,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 2),0.00);
    }

    @Test
    public void shouldReturnPriceFor2PersonForBusinessClass() throws Exception {
        Assert.assertEquals(20,flightPriceCalculator.getPrice(flight, TravelClass.Business, 2),0.00);
    }

}