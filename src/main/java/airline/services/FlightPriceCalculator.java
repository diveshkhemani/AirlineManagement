package airline.services;

import airline.model.Flight;
import airline.model.TravelClass;

public class FlightPriceCalculator {

    public double getPrice(Flight flight, TravelClass travelClass, int numberOfPassengers){
        return flight.getPriceByClass(travelClass) * numberOfPassengers;
    }
}
