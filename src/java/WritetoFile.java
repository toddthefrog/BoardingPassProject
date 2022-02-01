import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WritetoFile {
    FileWriter fw;

    public void ticketInfo(Customer customer, BoardingPass boardingPass){
        {
            try {
                fw = new FileWriter("ticketInfo.txt");
                fw.write(customer.getName());
                fw.write(customer.getEmail());
                fw.write(customer.getNumber());
                fw.write(customer.getGender());
                fw.write(customer.getAge());

                //date
                fw.write(String.valueOf(boardingPass.getArrivalTime()));
                //date
                fw.write(String.valueOf(boardingPass.getDepartureTime()));
                //enum
                fw.write(String.valueOf(boardingPass.getDestinationLocation()));
                //long
                fw.write(String.valueOf(boardingPass.getEta()));
                //double
                fw.write(String.valueOf(boardingPass.getTicketPrice()));

                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
