import java.util.Date;

public class BoardingPass {

    // variables
    private int boardingPassNumber;
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
        Washington_DC
    }
    private Locations originLocation;
    private Locations destinationLocation;
    private Date arrivalTime;
    private Date departureTime;
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

    // returned in milliseconds
    public long getEta(){
        return Math.subtractExact(arrivalTime.getTime(), departureTime.getTime());
    }

    // todo create method to convert milliseconds to hh:mm:ss
}
