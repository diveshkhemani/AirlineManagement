package airline.model;

public class Seat {
    private TravelClass travelClass;
    private  double basePrice;
    private int totalSeats;
    private int availableSeats;

    public Seat(TravelClass travelClass, double basePrice, int totalSeats, int availableSeats) {
        this.travelClass = travelClass;
        this.basePrice = basePrice;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public double getbasePrice() {
        return basePrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}