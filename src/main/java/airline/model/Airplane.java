package airline.model;

import java.util.HashMap;


public class Airplane {

    private HashMap<TravelClass,Integer> seatsList;
    private String airPlaneName;

    public Airplane(String airPlaneName,HashMap<TravelClass,Integer> seatsList)
    {
        this.airPlaneName = airPlaneName;
        this.seatsList=seatsList;
    }

    public String getAirPlaneName() { return airPlaneName; }

    public int getSeatsByClass(TravelClass travelClass) { return seatsList.get(travelClass);}

}
