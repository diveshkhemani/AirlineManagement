package airline.services;

import airline.model.Airplane;
import airline.model.Flight;
import airline.model.Seat;
import airline.model.TravelClass;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightFareMultiplierTest {

    
    // Economy Class Test Cases
    @Test
    public void shouldReturnBasePriceWhenNoSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,100));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }


    @Test
    public void shouldReturnBasePriceWhen10PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,90));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight  = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }

    @Test
    public void shouldReturnBasePriceWhen39PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,61));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(40, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }

    @Test
    public void shouldReturn30PCBasePriceWhen40PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,60));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(52, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }

    @Test
    public void shouldReturn30PCPlusBasePriceWhen50PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,50));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(52, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }

    @Test
    public void shouldReturn60PCPlusBasePriceWhen90PCSeatsAreBooked() throws Exception {
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,100,10));
        Airplane airplane = new Airplane("TestPlane",testSeats);
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
        Assert.assertEquals(60, FlightFareMultiplier.getEconomyClassRate(flight),0.00);
    }

    // Business Class Test Cases
    

}