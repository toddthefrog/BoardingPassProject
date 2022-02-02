import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

class WritetoFileTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ticketInfo(@TempDir Path tempDir) {
        Path testingFolder = tempDir.resolve("ticketInfo.txt");

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

    @Test
    void writeTicket(@TempDir Path tempDir) {
        Path testingFolder = tempDir.resolve("ticket.txt");

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