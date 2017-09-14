package airline.services;

import airline.model.Flight;

import airline.model.TravelClass;
import java.util.function.Function;

public class FlightPriceCalculator {

    Function<Flight, Double> getMuliplierByClassByBookingDate(TravelClass travelClass) {
         switch (travelClass.toString()){
             case "Business":
                 return FlightFareMultiplier::getBusinessClassRate;
             case "First":
                 return FlightFareMultiplier::getFirstClassRateByBookingDate;
             case "Economy":
                 return FlightFareMultiplier::getEconomyClassRate;
             default:
                 return (it) ->  0.0;
         }
    }

    public double getPrice(Flight flight, TravelClass travelClass, int numberOfPassengers){
        return getMuliplierByClassByBookingDate(travelClass).apply(flight) * numberOfPassengers;
    }
}
