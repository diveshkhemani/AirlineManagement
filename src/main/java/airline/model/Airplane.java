package airline.model;

import java.util.List;
import java.util.stream.Collectors;


public class Airplane {

    private List<Seat> seats;
    private String airPlaneName;

    public Airplane(String airPlaneName,List<Seat> seats)
    {

        this.airPlaneName = airPlaneName;
        this.seats=seats;
    }

    public String getAirPlaneName() { return airPlaneName; }


    public int getAvailableSeatsByClass(TravelClass travelClass)
    {
        if(this.hasTravelClass(travelClass)) {
            return seats.stream()
                    .filter((seat -> seat.getTravelClass().equals(travelClass)))
                    .collect(Collectors.toList())
                    .get(0)
                    .getAvailableSeats();
        }
        else
            return 0;
    }

    public int getTotalSeatsByClass(TravelClass travelClass)
    {
        if(this.hasTravelClass(travelClass)) {
            return seats.stream()
                    .filter((seat -> seat.getTravelClass().equals(travelClass)))
                    .collect(Collectors.toList())
                    .get(0)
                    .getTotalSeats();
        }
        else
            return 0;
    }

    public double getBasePriceByClass(TravelClass travelClass){
        if(this.hasTravelClass(travelClass)) {
            return seats.stream()
                    .filter((seat -> seat.getTravelClass().equals(travelClass)))
                    .collect(Collectors.toList())
                    .get(0)
                    .getBasePrice();
        }
        else
            return 0;
    }

    public boolean hasTravelClass(TravelClass travelClass){
        return seats.stream().filter(seat -> seat.getTravelClass().equals(travelClass)).findFirst().isPresent();
    }

}
