import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CommandLineApp {

    Scanner scanner = new Scanner(System.in);

    public void start(Customer customer, BoardingPass boardingPass){
        // get customer info
        askName(customer);
        requestEmail(customer);
        requestNumber(customer);
        requestGender(customer);
        requestAge(customer);
        // generate boarding pass
        requestOriginLocation(boardingPass);
    }

    public void askName(Customer customer){
        // create scanner
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your full legal name? \n");
        String input = getInput.nextLine();
        customer.setName(input);
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
        String input = getInput.nextLine();
        customer.setNumber(input);
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

    public void requestOriginLocation(BoardingPass boardingPass){
        Scanner getInput = new Scanner(System.in);
        slowPrint("What is your departure city? \n\n");
        int i = 1;
        for(BoardingPass.Locations location : BoardingPass.Locations.values()){
            System.out.println(i + " " + location + "\t");
            i++;
        }
//        System.out.println("\n");
        int input;
        if(getInput.hasNextInt()){
            input = getInput.nextInt();
            if(input >= 1 && input <= 20){
                switch(input){
                    case 1:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Atlanta);
                        break;
                    case 2:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Amsterdam);
                        break;
                    case 3:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Amsterdam);
                        break;
                    case 4:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Boston);
                        break;
                    case 5:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Cancun);
                        break;
                    case 6:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Dublin);
                        break;
                    case 7:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Hong_Kong);
                        break;
                    case 8:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Las_Vegas);
                        break;
                    case 9:
                        boardingPass.setOriginLocation(BoardingPass.Locations.London);
                        break;
                    case 10:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Los_Angeles);
                        break;
                    case 11:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Melbourne);
                        break;
                    case 12:
                        boardingPass.setOriginLocation(BoardingPass.Locations.New_Zealand);
                        break;
                    case 13:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Orlando);
                        break;
                    case 14:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Paris);
                        break;
                    case 15:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Rome);
                        break;
                    case 16:
                        boardingPass.setOriginLocation(BoardingPass.Locations.San_Francisco);
                        break;
                    case 17:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Singapore);
                        break;
                    case 18:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Tokyo);
                        break;
                    case 19:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Vancouver);
                        break;
                    case 20:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Washington_DC);
                        break;
                    default:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Unknown);
                        break;
                }
            }
        }
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
