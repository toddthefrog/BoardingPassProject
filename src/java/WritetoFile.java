import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WritetoFile {
    FileWriter fw;

    public void ticketInfo(Customer customer, BoardingPass boardingPass) {
        {
            try {
                fw = new FileWriter("ticketInfo.txt");
                fw.write(customer.getName());
                fw.write(customer.getEmail());
                fw.write(customer.getNumber());
                fw.write(customer.getGender());
                fw.write(customer.getAge());

                //enum
                fw.write(String.valueOf(boardingPass.getBoardingPassNumber()));
                //enum
                fw.write(String.valueOf(boardingPass.getDestinationLocation()));
                //locations
                fw.write(String.valueOf(boardingPass.getOriginLocation()));
                //date
                fw.write(String.valueOf(boardingPass.getDepartureTime()));
                //date
                fw.write(String.valueOf(boardingPass.getArrivalTime()));
                //double
                fw.write(String.valueOf(boardingPass.getTicketPrice()));
                //long
                fw.write(String.valueOf(boardingPass.getEta()));

                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeTicket(){
        try {
            FileReader fr = new FileReader("ticketInfo.txt");

            Scanner myReader = new Scanner(fr);
            String name = myReader.nextLine();
            String email = myReader.nextLine();
            String number = myReader.nextLine();
            String gender = myReader.nextLine();
            String age = myReader.nextLine();

            String bpNumber = myReader.nextLine();
            String destinationLocation = myReader.nextLine();
            String originLocation = myReader.nextLine();
            String departureTime = myReader.nextLine();
            String arrivalTime = myReader.nextLine();
            String ticketPrice = myReader.nextLine();
            String ETA = myReader.nextLine();
            myReader.close();

            //Passnger info
            fw.write("Passenger Information: ");
            fw.write("Passenger Name:" + "          " + "Gender:" + "          " + "Age:");
            fw.write(name + "          " + gender + "          " + age);
            //space
            fw.write("");

            fw.write("Email:"+ "          " + "Phone Number:");
            fw.write(email + "          " + number);

            fw.write("Boarding Pass Number:");
            fw.write(bpNumber);
            //space
            fw.write("");
            fw.write("");

            //Flight Information
            fw.write("Travel Information:");
            //space
            fw.write("");

            fw.write("From:" + "          " + "Departure Time:");
            fw.write(originLocation + "          " + departureTime);
            //space
            fw.write("");

            fw.write("To:" + "          " + "Arrival Time:");
            fw.write(destinationLocation + "          " + arrivalTime);
            //space
            fw.write("");

            fw.write("ETA:");
            fw.write(ETA);
            //space
            fw.write("");
            fw.write("");

            fw.write("Fare:");
            fw.write(ticketPrice);

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}