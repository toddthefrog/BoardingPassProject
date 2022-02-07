import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BarcodePDF417;
import com.lowagie.text.pdf.FontSelector;
import com.lowagie.text.pdf.PdfWriter;

import java.util.Scanner;

public class WritetoFile {
    public void ticketInfo(Customer customer, BoardingPass boardingPass) {
        {
            try {
                File write = new File("ticketInfo.txt");
                FileOutputStream fos = new FileOutputStream(write);
                BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));

                fw.write(customer.getName());
                fw.newLine();
                fw.write(customer.getGender().toString());
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

                //locations
                fw.write(String.valueOf(boardingPass.getOriginLocation()));
                fw.newLine();
                //date
                fw.write(String.valueOf(boardingPass.getDepartureTime()));
                fw.newLine();
                //enum
                fw.write(String.valueOf(boardingPass.getDestinationLocation()));
                fw.newLine();
                //date
                fw.write(String.valueOf(boardingPass.getArrivalTime()));
                fw.newLine();
                //double
                fw.write(String.valueOf(boardingPass.getEta()));
                fw.newLine();
                //long
                fw.write("$"+ boardingPass.getTicketPrice());

                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void pdf(BoardingPass boardingPass){
        try {
            FileReader fr = new FileReader("ticketInfo.txt");
            Scanner myReader = new Scanner(fr);
            BarcodePDF417 pdf417 = new BarcodePDF417();
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Ticket.pdf"));
            document.open();
            pdf417.setText(String.valueOf(boardingPass.getBoardingPassNumber()));
            Image img = pdf417.getImage();
            img.scalePercent(300, 300 * pdf417.getYHeight());

            FontSelector selector = new FontSelector();
            Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30);
            selector.addFont(f1);
            Phrase ph = selector.process("Ticket Information");
            Paragraph title = new Paragraph(ph);
            title.setAlignment("center");
            document.add(title);

            int i = 1;
            String line;
            Paragraph PLine = new Paragraph(ph);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            while (myReader.hasNextLine()){
                switch (i){
                    case 1:
                        f1.setSize(13);
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
                    case 11:
                        line = "ETA: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                    case 12:
                        line = "Fare: ";
                        PLine = new Paragraph(line);
                        document.add(PLine);
                        break;
                }
                line = myReader.nextLine();
                Paragraph paragraph = new Paragraph(line);
                paragraph.setIndentationLeft(100.0f);
                document.add(paragraph);
                i++;
            }
            myReader.close();
            document.add(Chunk.NEWLINE);
            document.add(img);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}