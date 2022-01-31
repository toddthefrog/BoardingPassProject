import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardingPassTest {

    // only testing setters
    BoardingPass boardingPass;

    @BeforeEach
    void setUp() {
        boardingPass = new BoardingPass();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBoardingPassNumber() {
        boardingPass.setBoardingPassNumber(1234567890);
        assertEquals(1234567890,boardingPass.getBoardingPassNumber());
    }

    @Test
    void getOriginLocation() {
        boardingPass.setOriginLocation(BoardingPass.Locations.Atlanta);
        assertEquals(BoardingPass.Locations.Atlanta, boardingPass.getOriginLocation());
    }

    @Test
    void getDestinationLocation() {
        boardingPass.setDestinationLocation(BoardingPass.Locations.San_Francisco);
        assertEquals(BoardingPass.Locations.San_Francisco, boardingPass.getDestinationLocation());
    }

    @Test
    void getArrivalTime() {
        Date date = new Date();
        boardingPass.setArrivalTime(date);
        assertEquals(date, boardingPass.getArrivalTime());
    }

    @Test
    void getDepartureTime() {
        Date date = new Date();
        boardingPass.setDepartureTime(date);
        assertEquals(date, boardingPass.getDepartureTime());
    }

    @Test
    void getTicketPrice() {
        boardingPass.setTicketPrice(200.0);
        assertEquals(200.0, boardingPass.getTicketPrice());
    }

    @Test
    void getEta() {
        // create departure time - even though it's the current date, consider it 0
        boardingPass.setDepartureTime(new Date(1643667213622L));
        // create arrival time 3 hours / 1080000 millis after departure time
        boardingPass.setArrivalTime(new Date(Long.sum(1643667213622L,10800000)));
        assertEquals(10800000, boardingPass.getEta());
    }
}