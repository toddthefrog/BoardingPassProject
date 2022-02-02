public class Main {

    public static void main(String[] args) {
	// write your code here
        CommandLineApp app = new CommandLineApp();
        Customer customer = new Customer();
        app.start(customer);
        System.out.println(customer.toString());
    }
}
