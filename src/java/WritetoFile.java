import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BarcodePDF417;
import com.lowagie.text.pdf.FontSelector;
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
                fw.write(customer.getGender());
                fw.newLine();
                fw.write(String.valueOf(customer.getAge()));
                fw.newLine();
                fw.write(customer.getEmail());
                fw.newLine();
                fw.write(customer.getNumber());
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

    public void pdf(BoardingPass boardingPass){
        try {
            FileReader fr = new FileReader("ticketInfo.txt");
            Scanner myReader = new Scanner(fr);
            /*
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
*/
            BarcodePDF417 pdf417 = new BarcodePDF417();
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Ticket.pdf"));
            //writer.
            document.open();
            pdf417.setText(String.valueOf(boardingPass.getBoardingPassNumber()));
            Image img = pdf417.getImage();
            img.scalePercent(300, 300 * pdf417.getYHeight());
            //document.addTitle("Ticket");
            FontSelector selector = new FontSelector();
            Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30);
            f1.setColor(Color.blue);
            selector.addFont(f1);
            Phrase ph = selector.process("Ticket Information");
            Paragraph title = new Paragraph(ph);
            document.add(title);

            int i = 1;
            String line;
            Paragraph PLine = new Paragraph(ph);

            //line = " ";
            //PLine = new Paragraph(line);
            //document.add(PLine);
            //document.add(PLine);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            while (myReader.hasNextLine()){
                switch (i){
                    case 1:
                        f1.setSize(13);
                        f1.setColor(Color.BLACK);
                        selector.addFont(f1);
                        ph = selector.process("Passenger Information: ");
                        PLine = new Paragraph(ph);
                        document.add(PLine);
                        document.add(Chunk.NEWLINE);
                        line = "Passenger Name: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 2:
                        line = "Passenger Gender:";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 3:
                        line = "Passenger Age: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 4:
                        line = "Passenger Email:";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 5:
                        line = "Passenger Phone Number: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 6:
                        line = "Boarding Pass Number: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 7:
                        document.add(Chunk.NEWLINE);
                        document.add(Chunk.NEWLINE);
                        ph = selector.process("Travel Information: ");
                        PLine = new Paragraph(ph);
                        document.add(PLine);
                        document.add(Chunk.NEWLINE);
                        line = "From: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 8:
                        line = "Departure Time: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 9:
                        line = "To: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 10:
                        line = "Arrival Time: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 13:
                        line = "ETA: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 14:
                        line = "Fare: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        String test = "";
                        break;
                }

                line = myReader.nextLine();
                Paragraph paragraph = new Paragraph(line);
                paragraph.setIndentationRight(50);
                document.add(paragraph);
                i++;
            }
            myReader.close();

            /*
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

             */
            document.add(img);


            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}