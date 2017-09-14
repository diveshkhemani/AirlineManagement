package airline.services;

import airline.model.Flight;

import airline.model.TravelClass;
import java.util.function.Function;

public class FlightPriceCalculator {

    Function<Flight, Double> getMuliplierByClassByBookingDate(TravelClass travelClass) {
         switch (travelClass.toString()){
             case "Business":
                 return FlightFareMultiplierService::getBusinessClassRateByBookingDate;
             case "First":
                 return FlightFareMultiplierService::getFirstClassRateByBookingDate;
             default:
                 return FlightFareMultiplierService::getEconomyClassRateByBookingDate;
         }
    }

    public double getPrice(Flight flight, TravelClass travelClass, int numberOfPassengers){
        return getMuliplierByClassByBookingDate(travelClass)
                .apply(flight) * numberOfPassengers;
    }
}
