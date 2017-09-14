package airline.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightTest {

    Flight flight;
    Airplane airplane;

    @Before
    public void initialize(){
        List<Seat> testSeats = new ArrayList<Seat>();
        testSeats.add(new Seat(TravelClass.Economy,40,10,10));
        testSeats.add(new Seat(TravelClass.Business,10,30,3));
        airplane = new Airplane("TestPlane",testSeats);
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
        Assert.assertEquals(true, flight.hasAvailableSeatsByClass("Business", 3));
    }

    @Test
    public void shouldBeFalseFor30SeatsForBusiness() throws Exception {
        Assert.assertEquals(false, flight.hasAvailableSeatsByClass("Business", 30));
    }

    @Test
    public void getBeFalseForUnknownClass() throws Exception {
        Assert.assertEquals(false, flight.hasAvailableSeatsByClass("", 5));
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

    @Test
    public void departsOnPopularDaysShouldBeTrueForMonday() throws Exception {
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.of(2017,9,11),airplane);
        Assert.assertEquals(true, flight.departsOnPopularDays());
    }

    @Test
    public void departsOnPopularDaysShouldBeTrueForFriday() throws Exception {
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.of(2017,9,15),airplane);
        Assert.assertEquals(true, flight.departsOnPopularDays());
    }

    @Test
    public void departsOnPopularDaysShouldBeTrueForSunday() throws Exception {
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.of(2017,9,17),airplane);
        Assert.assertEquals(true, flight.departsOnPopularDays());
    }

    @Test
    public void departsOnPopularDaysShouldBeTrueForRegularDays() throws Exception {
        Flight flight = new Flight("F1234","IXC" , "MUM", LocalDate.of(2017,9,14),airplane);
        Assert.assertEquals(false, flight.departsOnPopularDays());
    }
}