import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CommandLineApp {

    Scanner scanner = new Scanner(System.in);

    public void start(Customer customer){
        // get customer info
        askName(customer);
        requestEmail(customer);
        requestNumber(customer);
        requestGender(customer);
        requestAge(customer);
        // generate boarding pass
        
    }

    public void askName(Customer customer){
        // create scanner
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your full legal name? \n");
        String input = getInput.nextLine();
        try {
            customer.setName(input);
        } catch (Exception e){
            System.out.println("Something broke! \n");
        }
        // close scanner
//        getInput.close();
    }

    public void requestEmail(Customer customer){
        // create scanner
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your email? \n");
        String input = getInput.nextLine();
        customer.setEmail(input);
        // close scanner
//        getInput.close();
    }

    public void requestNumber(Customer customer){
        // create scanner
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your phone number? Format: 1234567890 \n");
        int input = getInput.nextInt();
        try {
            customer.setNumber(input);
        } catch (Exception e){
            slowPrint("Please use numbers only. \n");
            requestNumber(customer);
        }
        // close scanner
//        getInput.close();
    }

    public void requestGender(Customer customer){
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your gender? Format: 1-4 \n");
        slowPrint("(1) Male (2) Female (3) Other (4) Java Developer \n");
        int input;
        if(getInput.hasNextInt()){
            input = getInput.nextInt();
        } else {
            input = 5;
        }
        switch(input){
            case 1:
                customer.setGender("Male");
                break;
            case 2:
                customer.setGender("Female");
                break;
            case 3:
                customer.setGender("Other");
                break;
            case 4:
                customer.setGender("Java Developer");
                break;
            default:
                customer.setGender("Unknown");
        }
//        getInput.close();
    }

    public void requestAge(Customer customer){
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your age? Format: 18 \n");
        int input;
        if(getInput.hasNextInt()){
            input = getInput.nextInt();
            customer.setAge(input);
        } else {
            slowPrint("Please use numbers only. \n");
            requestAge(customer);
        }
//        getInput.close();
    }

    // the following method prints to the console with a delay between each character
    // shamelessly stolen from: https://replit.com/talk/learn/Slow-Print-tutorial-for-JAVA/51697
    // since I didn't write this I'm going to break down what I think is happening
    public static void slowPrint(String output) {
        // for loop that runs for each character in the method input string
        for (int i = 0; i < output.length(); i++) {
            // grab the character at position i
            char c = output.charAt(i);
            // print the single character
            System.out.print(c);
            // wrapped in a try catch statement
            try {
                // pause the for loop for X milliseconds
                TimeUnit.MILLISECONDS.sleep(15);
            }
            // catch exception
            catch (Exception e) {
                System.out.println("something broke \n");
            }
        }
    }
}
