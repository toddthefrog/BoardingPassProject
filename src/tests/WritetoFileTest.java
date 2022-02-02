import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WritetoFileTest {
    WritetoFile writeFile;

    @BeforeEach
    void setUp() {
        writeFile = new WritetoFile();
    }

    @Test
    void ticketInfo(Customer customer, BoardingPass boardingPass) {
        FileWriter fw;
        String test = null;
        try {
            fw = new FileWriter("test.txt");
            fw.write("abba");

            FileReader fr = new FileReader("test.txt");
            Scanner myReader = new Scanner(fr);
            test = myReader.nextLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("lig", test);
    }

    @Test
    void writeTicket() {
    }
}