import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

public class BoardingPass {

    // variables
    private int boardingPassNumber;
    private int customerNumber;
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


    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

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
        this.ticketPrice = Math.round(ticketPrice*100.0)/100.0;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Boarding Pass" + "\n  departure city: " + getOriginLocation() + "\n  departure time: " + getDepartureTime() + "\n  arrival city: " + getDestinationLocation() + "\n  arrival time: " + getArrivalTime() + "\n eta: " + getEta() + "\n price: $" + getTicketPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardingPass)) return false;
        BoardingPass that = (BoardingPass) o;
        return getBoardingPassNumber() == that.getBoardingPassNumber() && getCustomerNumber() == that.getCustomerNumber() && Double.compare(that.getTicketPrice(), getTicketPrice()) == 0 && getEta().equals(that.getEta()) && getOriginLocation() == that.getOriginLocation() && getDestinationLocation() == that.getDestinationLocation() && getDepartureTime().equals(that.getDepartureTime()) && getArrivalTime().equals(that.getArrivalTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBoardingPassNumber(), getCustomerNumber(), getEta(), getOriginLocation(), getDestinationLocation(), getDepartureTime(), getArrivalTime(), getTicketPrice());
    }
}
