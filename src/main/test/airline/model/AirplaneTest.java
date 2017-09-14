package airline.model;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AirplaneTest {
    Airplane airplane;

    @Before
    public void initialize(){

        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,10,10));
        testSeats.add(new Seat(TravelClass.Business,10,30,3));
        airplane = new Airplane("TestPlane",testSeats);
    }

    @Test
    public void shouldReturnAvailableSeatsWhenTravelClassSpecified() {
        Assert.assertEquals(10, airplane.getAvailableSeatsByClass(TravelClass.Economy));
    }

    @Test
    public void shouldReturnZeroAvailableSeatsWhenTravelClassNotPresent() {
        Assert.assertEquals(0, airplane.getAvailableSeatsByClass(TravelClass.First));
    }

    @Test
    public void shouldReturnTotalSeatsWhenTravelClassSpecified() {
        Assert.assertEquals(10, airplane.getTotalSeatsByClass(TravelClass.Economy));
    }

    @Test
    public void shouldReturnZeroTotalSeatsWhenTravelClassNotPresent() {
        Assert.assertEquals(0, airplane.getTotalSeatsByClass(TravelClass.First));
    }

    @Test
    public void shouldReturnBasePriceWhenTravelClassSpecified() {
        Assert.assertEquals(40, airplane.getBasePriceByClass(TravelClass.Economy),0.0);
    }

    @Test
    public void shouldReturnZeroBasePriceWhenTravelClassSpecifiedIsNotPresent() {
        Assert.assertEquals(0, airplane.getBasePriceByClass(TravelClass.First),0.0);
    }

    @Test
    public void shouldReturnName(){
        Assert.assertEquals("TestPlane", airplane.getAirPlaneName());
    }

    @Test
    public void shouldBeTrueForBusiness() throws Exception {
        Assert.assertEquals(true, airplane.hasTravelClass(TravelClass.Business));
    }

    @Test
    public void shouldBeFalseForFirst() throws Exception{
        Assert.assertEquals(false, airplane.hasTravelClass(TravelClass.First));
    }

}