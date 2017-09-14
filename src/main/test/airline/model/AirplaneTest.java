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
        Assert.assertEquals(10, airplane.getSeatsByClass(TravelClass.Economy).getAvailableSeats());
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