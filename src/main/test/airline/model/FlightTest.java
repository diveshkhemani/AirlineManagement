package airline.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;

public class FlightTest {

    Flight flight;

    @Before
    public void initialize(){
        HashMap<TravelClass,Integer> seats =new HashMap<TravelClass, Integer>();
        seats.put(TravelClass.Economy,10);
        seats.put(TravelClass.Business,3);
        Airplane airplane = new Airplane("TestPlane",seats);
        flight = new Flight("F1234","IXC" , "MUM", LocalDate.now(),airplane);
    }

    @Test
    public void shouldBeTrueForIXCToMUM() throws Exception {
        Assert.assertEquals(true,flight.hasRoute("IXC", "MUM"));
    }

    @Test
    public void shouldBeFalseForHYDToMUM() throws Exception {
        Assert.assertEquals(false,flight.hasRoute("HYD", "MUM"));
    }

    @Test
    public void shouldBeFalseForEmptyCities() throws Exception {
        Assert.assertEquals(false,flight.hasRoute("",""));
    }


    @Test
    public void shouldBeTrueFor3SeatsForBusiness() throws Exception {
        Assert.assertEquals(true, flight.hasAvailableByClass("Business", 3));
    }

    @Test
    public void shouldBeFalseFor30SeatsForBusiness() throws Exception {
        Assert.assertEquals(false, flight.hasAvailableByClass("Business", 30));
    }

    @Test
    public void getBeFalseForUnknownClass() throws Exception {
        Assert.assertEquals(false, flight.hasAvailableByClass("", 5));
    }

    @Test
    public void getAirPlaneName() throws Exception {
        Assert.assertEquals("TestPlane",flight.getAirPlaneName());
    }

    @Test
    public void shouldBeTrueForToday() throws Exception {
        Assert.assertEquals(true,flight.fliesOn(LocalDate.now()));
    }

    @Test
    public void shouldBeFalseForTomorrow() throws Exception {
        Assert.assertEquals(false,flight.fliesOn(LocalDate.now().plusDays(1)));
    }

    @Test
    public void shouldBe3SeatsForBusiness() throws Exception {
        Assert.assertEquals(3, flight.getSeatsByClass("Business"));
    }

    @Test
    public void getBe0ForUnknownClass() throws Exception {
        Assert.assertEquals(0, flight.getSeatsByClass(""));
    }

}