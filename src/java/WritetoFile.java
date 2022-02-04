import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BarcodePDF417;
import com.lowagie.text.pdf.PdfWriter;

public class WritetoFile {
    FileWriter fw;

    public void ticketInfo(Customer customer, BoardingPass boardingPass) {
        {
            try {
                //fw = new FileWriter("ticketInfo.txt");
                File write = new File("ticketInfo.txt");
                FileOutputStream fos = new FileOutputStream(write);
                BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));

                fw.write(customer.getName());
                fw.newLine();
                fw.write(customer.getEmail());
                fw.newLine();
                fw.write(customer.getNumber());
                fw.newLine();
                fw.write(customer.getGender());
                fw.newLine();
                fw.write(String.valueOf(customer.getAge()));
                fw.newLine();

                //enum
                fw.write(String.valueOf(boardingPass.getBoardingPassNumber()));
                fw.newLine();
                //enum
                fw.write(String.valueOf(boardingPass.getDestinationLocation()));
                fw.newLine();
                //locations
                fw.write(String.valueOf(boardingPass.getOriginLocation()));
                fw.newLine();
                //date
                fw.write(String.valueOf(boardingPass.getDepartureTime()));
                fw.newLine();
                //date
                fw.write(String.valueOf(boardingPass.getArrivalTime()));
                fw.newLine();
                //double
                fw.write(String.valueOf(boardingPass.getTicketPrice()));
                fw.newLine();
                //long
                //fw.write(String.valueOf(boardingPass.getEta()));

                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeTicket(){
        try {
            FileReader fr = new FileReader("ticketInfo.txt");
            FileWriter fw = new FileWriter("Ticket.txt");

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

            //Passenger info
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

    public void pdf(){
        try {
            FileReader fr = new FileReader("ticketInfo.txt");
            Scanner myReader = new Scanner(fr);
            String name = myReader.nextLine();
            Paragraph PName = new Paragraph(name);
            String email = myReader.nextLine();
            Paragraph PEmail = new Paragraph(email);
            String number = myReader.nextLine();
            Paragraph PNumber = new Paragraph(number);
            String gender = myReader.nextLine();
            Paragraph PGender = new Paragraph(gender);
            String age = myReader.nextLine();
            Paragraph PAge = new Paragraph(age);

            String bpNumber = myReader.nextLine();
            Paragraph PBPNumber = new Paragraph(bpNumber);
            String destinationLocation = myReader.nextLine();
            Paragraph PDestinationLocation = new Paragraph(destinationLocation);
            String originLocation = myReader.nextLine();
            Paragraph PoriginLocation = new Paragraph(originLocation);
            String departureTime = myReader.nextLine();
            Paragraph PdepartureTime = new Paragraph(departureTime);
            String arrivalTime = myReader.nextLine();
            Paragraph ParrivalTime = new Paragraph(arrivalTime);
            String ticketPrice = myReader.nextLine();
            Paragraph PticketPrice = new Paragraph(ticketPrice);
            //String ETA = myReader.nextLine();
            //Paragraph PETA = new Paragraph(ETA);
            myReader.close();

            BarcodePDF417 pdf417 = new BarcodePDF417();
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Ticket.pdf"));
            //writer.
            document.open();
            Image img = pdf417.getImage();
            img.scalePercent(100, 100 * pdf417.getYHeight());
            document.add(img);
            document.add(PName);
            //document.add(PEmail);
            document.add(PNumber);
            document.add(PGender);
            document.add(PAge);

            document.add(PBPNumber);
            document.add(PDestinationLocation);
            document.add(PoriginLocation);
            document.add(PdepartureTime);
            document.add(ParrivalTime);
            document.add(PticketPrice);
            //document.add(PETA);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}