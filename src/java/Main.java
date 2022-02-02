public class Main {

    public static void main(String[] args) {
	// write your code here
        CommandLineApp app = new CommandLineApp();
        Customer customer = new Customer();
        BoardingPass boardingPass = new BoardingPass();
        app.start(customer, boardingPass);
    }
}
