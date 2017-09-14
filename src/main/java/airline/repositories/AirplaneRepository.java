package airline.repositories;

import airline.model.Airplane;
import airline.model.Seat;
import airline.model.TravelClass;
import java.util.*;
import java.lang.*;

public class AirplaneRepository {


    HashMap<String,List<Seat>> airplanes=new HashMap<String,List<Seat>>();
    public AirplaneRepository()
    {
        List<Seat> boeingSeats = new ArrayList<Seat>();
        boeingSeats.add(new Seat(TravelClass.Economy,6000,195,195));
        boeingSeats.add(new Seat(TravelClass.Business,13000,35,35));
        boeingSeats.add( new Seat(TravelClass.First,20000,8,8));
        airplanes.put("Boeing777-200LR(77L)",boeingSeats);
        
        List<Seat> AirbusA319Seats = new ArrayList<Seat>();
        AirbusA319Seats.add(new Seat(TravelClass.Economy,4000,144,144));
        AirbusA319Seats.add(new Seat(TravelClass.Business,0,0,0));
        AirbusA319Seats.add( new Seat(TravelClass.First,0,0,0));
        airplanes.put("AirBus-A319-V2",AirbusA319Seats);
        
        List<Seat> AirbusA321Seats = new ArrayList<Seat>();
        AirbusA321Seats.add(new Seat(TravelClass.Economy,4000,152,152));
        AirbusA321Seats.add(new Seat(TravelClass.Business,0,20,20));
        AirbusA321Seats.add( new Seat(TravelClass.First,0,0,0));
        airplanes.put("AirBus-A321",AirbusA321Seats);
    }

    public Airplane getAirplaneByName(String airplaneName)
    {
        List<Seat> seats=airplanes.get(airplaneName);
        Airplane airPlane=new Airplane(airplaneName,seats);
        return airPlane;
    }
}