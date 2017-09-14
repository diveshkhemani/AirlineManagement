package airline.services;

import airline.model.Flight;
import airline.model.TravelClass;

public class FlightFareMultiplier {
    private static double PERCENT40 = 0.4;
    private static double PERCENT30 = 0.3;
    private static double PERCENT90 = 0.9;
    private static double PERCENT50 = 0.5;


    public static Double getEconomyClassRate(Flight flight) {
        int availableEconomySeats = flight.getAvailableSeatsByClass(TravelClass.Economy);
        int totalEconomySeats = flight.getTotalSeatsByClass(TravelClass.Economy);
        int bookedEconomySeats = totalEconomySeats - availableEconomySeats;
        double basePrice = flight.getPriceByClass(TravelClass.Economy);

        if(bookedEconomySeats >= totalEconomySeats*PERCENT40 && bookedEconomySeats < totalEconomySeats*PERCENT90){
            return basePrice + (basePrice * PERCENT30);
        }

        if(bookedEconomySeats >= totalEconomySeats*PERCENT90){
            return basePrice + (basePrice * PERCENT50);
        }
        return basePrice;
    }

    public static Double getBusinessClassRate(Flight flight) {
        double basePrice = flight.getPriceByClass(TravelClass.Business);
        return flight.departsOnPopularDays() ? basePrice+(basePrice*PERCENT40): basePrice;
    }

    public static Double getFirstClassRateByBookingDate(Flight flight) {
        return flight.getPriceByClass(TravelClass.First);
    }
}
