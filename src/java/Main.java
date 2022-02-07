public class Main {

    public static void main(String[] args) {
	// write your code here
        CommandLineApp app = new CommandLineApp();
        Customer customer = new Customer();
        BoardingPass boardingPass = new BoardingPass();
        WritetoFile writetoFile = new WritetoFile();
        app.start(customer, boardingPass);
        writetoFile.ticketInfo(customer, boardingPass);
        writetoFile.pdf(boardingPass);
    }
}
