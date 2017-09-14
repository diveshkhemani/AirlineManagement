package airline.services;

import airline.model.Flight;
import airline.model.TravelClass;

public class FlightFareMultiplierService {

    public static Double getEconomyClassRateByBookingDate(Flight flight) {
        int availableEconomySeats = flight.getAvailableSeatsByClass(TravelClass.Economy);
        int totalEconomySeats = flight.getTotalSeatsByClass(TravelClass.Economy);
        int bookedEconomySeats = totalEconomySeats - availableEconomySeats;
        double basePrice = flight.getPriceByClass(TravelClass.Economy);

        if(bookedEconomySeats >= totalEconomySeats*0.40 && bookedEconomySeats < totalEconomySeats*0.9){
            return basePrice + (basePrice * 0.3);
        }
        if(bookedEconomySeats >= totalEconomySeats*0.9){
            return basePrice + (basePrice * 0.5);
        }
        return basePrice;
    }

    public static Double getBusinessClassRateByBookingDate(Flight flight) {
        return flight.getPriceByClass(TravelClass.Business);
    }

    public static Double getFirstClassRateByBookingDate(Flight flight) {
        return flight.getPriceByClass(TravelClass.First);
    }
}
