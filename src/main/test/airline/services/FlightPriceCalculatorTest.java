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
        testSeats.add(new Seat(TravelClass.First,50,5,5));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        flightPriceCalculator = new FlightPriceCalculator();
    }



    @Test
    public void shouldReturnPriceFor2PersonForEconomyClass() throws Exception {
        Assert.assertEquals(80,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 2),0.00);
    }


    @Test
    public void shouldReturnPriceFor2PersonForBusinessClass() throws Exception {
        Assert.assertEquals(20,flightPriceCalculator.getPrice(flight, TravelClass.Business, 2),0.00);
    }

    @Test
    public void shouldReturnPriceFor2PersonForFirstClass() throws Exception {
        Assert.assertEquals(100,flightPriceCalculator.getPrice(flight, TravelClass.First, 2),0.00);
    }

    @Test
    public void shouldReturnPriceFor1PersonForEconomyClass() throws Exception {
        Assert.assertEquals(40,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturnBasePriceWhenNoSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,100));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }


    @Test
    public void shouldReturnBasePriceWhen10PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,90));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturnBasePriceWhen39PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,61));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturn30PCBasePriceWhen40PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,60));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(52,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturn30PCPlusBasePriceWhen50PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,50));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(52,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }

    @Test
    public void shouldReturn60PCPlusBasePriceWhen90PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,10));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(60,flightPriceCalculator.getPrice(flight, TravelClass.Economy, 1),0.00);
    }


    // first 40% seat bookings same base rate
    // Economy Travel class will be charged extra based on the filling rates of the seats.
    // next 50% seats will be charged 30% extra of base price.
    // Last 10% seats will be charged 60% extra of base price



}