import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

class WritetoFileTest {
    Customer customer;
    BoardingPass boardingPass;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        boardingPass = new BoardingPass();

        Date today;
        today = new Date();
        customer.setEmail("a@a.com");
        customer.setName("abba");
        customer.setGender("Male");
        customer.setAge(23);
        customer.setNumber("1234567890");

        boardingPass.setBoardingPassNumber(1234);
        boardingPass.setOriginLocation(BoardingPass.Locations.Boston);
        boardingPass.setDestinationLocation(BoardingPass.Locations.Atlanta);
        boardingPass.setArrivalTime(today);
        boardingPass.setTicketPrice(100.0);
        //ETA
    }

    @Test
    void ticketInfo(@TempDir Path tempDir) {
        Path testingFolder = tempDir.resolve("ticketInfo.txt");

        //List<String> lines = Arrays.asList("1", "2", "3");
        String age = String.valueOf(customer.getAge());
        String bpn = String.valueOf(boardingPass.getBoardingPassNumber());
        String DL = String.valueOf(boardingPass.getDestinationLocation());
        String OL = String.valueOf(boardingPass.getOriginLocation());
        String DT = String.valueOf(boardingPass.getDepartureTime());
        String AT = String.valueOf(boardingPass.getArrivalTime());
        String ticketPrice = String.valueOf(boardingPass.getTicketPrice());
        //String ETA = String.valueOf(boardingPass.getEta());

        List<String> test = Arrays.asList(customer.getName(), customer.getNumber(), customer.getGender(), age, bpn, DL, OL, DT, AT, ticketPrice);
        try {
            Files.write(testingFolder, test);

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertAll(
                () -> assertTrue(Files.exists(testingFolder), "File should exist"),
                () -> assertLinesMatch(test, Files.readAllLines(testingFolder)));
    }

    @Test
    void writeTicket(@TempDir Path tempDir) {
        Path testingFolder = tempDir.resolve("ticketInfo.txt");
        Path testingFolder = tempDir.resolve("Ticket.txt");

        List<String> lines = Arrays.asList("1", "2", "3");
        try {
            Files.write(testingFolder, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertAll(
                () -> assertTrue(Files.exists(testingFolder), "File should exist"),
                () -> assertLinesMatch(lines, Files.readAllLines(testingFolder)));
    }
}