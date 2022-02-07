import java.util.Date;

public class BoardingPass {

    // variables
    private int boardingPassNumber;
    private String eta;

    enum Locations {
        Atlanta,
        Amsterdam,
        Boston,
        Cancun,
        Dublin,
        Hong_Kong,
        Las_Vegas,
        London,
        Los_Angeles,
        Melbourne,
        New_York,
        New_Zealand,
        Orlando,
        Paris,
        Rome,
        San_Francisco,
        Singapore,
        Tokyo,
        Vancouver,
        Washington_DC,
        Unknown
    }
    enum Months {
        January,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December
    }
    private Locations originLocation;
    private Locations destinationLocation;
    private Date departureTime;
    private Date arrivalTime;
    private double ticketPrice;

    // getters and setters
    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public Locations getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Locations destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Locations getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(Locations originLocation) {
        this.originLocation = originLocation;
    }


    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Boarding Pass" + "\n  departure city: " + getOriginLocation() + "\n  departure time: " + getDepartureTime() + "\n  arrival city: " + getDestinationLocation() + "\n  arrival time: " + getArrivalTime() + "\n eta: " + getEta();
    }
}
