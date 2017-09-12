package airline.model;

import airline.model.Airplane;
import airline.model.TravelClass;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;


public class AirplaneTest {
    Airplane airplane;

    @Before
    public void initialize(){
        HashMap<TravelClass,Integer> seats =new HashMap<TravelClass, Integer>();
        seats.put(TravelClass.Economy,10);
        seats.put(TravelClass.Business,3);
        airplane = new Airplane("TestPlane",seats);
    }

    @Test
    public void shouldReturnAvailableSeatsWhenTravelClassSpecified() {
        Assert.assertEquals(10, airplane.getSeatsByClass(TravelClass.Economy));
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