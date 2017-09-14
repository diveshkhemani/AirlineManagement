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


    public Seat getSeatsByClass(TravelClass travelClass)
    {
        return seats.stream()
                .filter((seat -> seat.getTravelClass().equals(travelClass)))
                .collect(Collectors.toList()).get(0);
    }

    public boolean hasTravelClass(TravelClass travelClass){
        return seats.stream().filter(seat -> seat.getTravelClass().equals(travelClass)).findFirst().isPresent();
    }

}
