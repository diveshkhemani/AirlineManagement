package airline.viewModels;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FlightSearchCriteriaTest {

    @Test
    public void getDepartureDateWhenDateIsPresent() throws Exception {
        String testDate = "2017-09-11";
        FlightSearchCriteria flightSearchCriteria = new FlightSearchCriteria();
        flightSearchCriteria.setDepartureDate(testDate);
        Assert.assertEquals(testDate,flightSearchCriteria.getDepartureDate());
    }

    @Test
    public void getNullWhenDateIsAbsent() throws Exception {
        String testDate = "";
        FlightSearchCriteria flightSearchCriteria = new FlightSearchCriteria();
        flightSearchCriteria.setDepartureDate(testDate);
        Assert.assertEquals(null,flightSearchCriteria.getDepartureDate());
    }

}