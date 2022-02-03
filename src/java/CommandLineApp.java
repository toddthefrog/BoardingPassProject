import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CommandLineApp {

    // create scanner
    Scanner getInput = new Scanner(System.in);

    public void start(Customer customer, BoardingPass boardingPass){
        // get customer info
//        requestName(customer);
//        requestEmail(customer);
//        requestNumber(customer);
//        requestGender(customer);
//        requestAge(customer);
        // generate boarding pass
//        requestDepartureLocation(boardingPass);
//        requestDestinationLocation(boardingPass);
        // close scanner
//        httpCallForDistanceAndFlightTime(boardingPass);
        requestDateLeaving();
        System.out.println(customer);
        System.out.println(boardingPass);
        getInput.close();
    }

    public void requestName(Customer customer){
        slowPrint("What is your full legal name? \n");
        String input = getInput.nextLine();
        customer.setName(input);
    }

    public void requestEmail(Customer customer){
        slowPrint("What is your email? \n");
        String input = getInput.nextLine();
        customer.setEmail(input);
    }

    public void requestNumber(Customer customer){
        slowPrint("What is your phone number? Format: 1234567890 \n");
        String input = getInput.nextLine();
        customer.setNumber(input);
    }

    public void requestGender(Customer customer){
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
    }

    public void requestAge(Customer customer){
        slowPrint("What is your age? Format: 18 \n");
        int input;
        if(getInput.hasNextInt()){
            input = getInput.nextInt();
            customer.setAge(input);
        } else {
            slowPrint("Please use numbers only. \n");
            requestAge(customer);
        }
    }

    public void requestDepartureLocation(BoardingPass boardingPass){
        slowPrint("What is your departure city? \n\n");
        int i = 1;
        for(BoardingPass.Locations location : BoardingPass.Locations.values()){
            System.out.println(i + " " + location + "\t");
            i++;
        }
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
                        boardingPass.setOriginLocation(BoardingPass.Locations.Boston);
                        break;
                    case 4:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Cancun);
                        break;
                    case 5:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Dublin);
                        break;
                    case 6:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Hong_Kong);
                        break;
                    case 7:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Las_Vegas);
                        break;
                    case 8:
                        boardingPass.setOriginLocation(BoardingPass.Locations.London);
                        break;
                    case 9:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Los_Angeles);
                        break;
                    case 10:
                        boardingPass.setOriginLocation(BoardingPass.Locations.Melbourne);
                        break;
                    case 11:
                        boardingPass.setOriginLocation(BoardingPass.Locations.New_York);
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

    public void requestDestinationLocation(BoardingPass boardingPass){
        slowPrint("What is your arrival city? \n\n");
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
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Atlanta);
                        break;
                    case 2:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Amsterdam);
                        break;
                    case 3:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Boston);
                        break;
                    case 4:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Cancun);
                        break;
                    case 5:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Dublin);
                        break;
                    case 6:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Hong_Kong);
                        break;
                    case 7:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Las_Vegas);
                        break;
                    case 8:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.London);
                        break;
                    case 9:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Los_Angeles);
                        break;
                    case 10:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Melbourne);
                        break;
                    case 11:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.New_York);
                        break;
                    case 12:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.New_Zealand);
                        break;
                    case 13:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Orlando);
                        break;
                    case 14:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Paris);
                        break;
                    case 15:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Rome);
                        break;
                    case 16:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.San_Francisco);
                        break;
                    case 17:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Singapore);
                        break;
                    case 18:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Tokyo);
                        break;
                    case 19:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Vancouver);
                        break;
                    case 20:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Washington_DC);
                        break;
                    default:
                        boardingPass.setDestinationLocation(BoardingPass.Locations.Unknown);
                        break;
                }
            }
        }
    }

    public void httpCallForDistanceAndFlightTime(BoardingPass boardingPass){
        // reference material https://www.geeksforgeeks.org/parse-json-java/
        // url
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                // api documentation
                // https://www.distance24.org/api.xhtml
                .url("https://www.distance24.org/route.json?stops=" + boardingPass.getOriginLocation() + "%7C" + boardingPass.getDestinationLocation())
                .get()
                .addHeader("content-type", "text/html;charset=UTF-8")
                .addHeader("vary", "Accept-Encoding")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            try {
                Object obj = new JSONParser().parse(response.body().string());
                JSONObject jo = (JSONObject) obj;
                JSONArray ja = (JSONArray) jo.get("distances");
                double distance = Double.parseDouble(ja.get(0).toString()); // distance in km
                double speedOfPlaneInKilometersPerHour = 865.0; // speed of boeing 777 in kilometers per hour
                double timeToCruisingAltitudePenalty = 3600.0;  // 1 hour in seconds
                double tripTimeInSeconds = ((((distance / speedOfPlaneInKilometersPerHour) * 60.0) * 60.0) + timeToCruisingAltitudePenalty);// trip time in seconds
                System.out.println("\ntrip time in seconds: " + tripTimeInSeconds);
                double milliseconds = tripTimeInSeconds * 1000.0; // trip time in milliseconds
                System.out.println("\ntrip time in milliseconds: " + milliseconds);
                System.out.println("\nDistance in kilometers: " + distance);
                // date test
                Calendar calendar = Calendar.getInstance();
                Date today = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
                System.out.println("\nCurrent time: " + sdf.format(today));
                // add milliseconds to date
                calendar.add(Calendar.MILLISECOND, (int) milliseconds);
                Date addMilliSeconds = calendar.getTime();
                System.out.println("\nTime after" + tripTimeInSeconds + " seconds: " + sdf.format(addMilliSeconds));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestDateLeaving(){
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        slowPrint("\nWhat date would you like to leave?");
        slowPrint("\nExample: " + sdf.format(today) +"\n");
        String requestedDate = getInput.nextLine();
        // create date from input
        String pattern = "yyyy-MM-dd";
        int amOrPM;
        int hour;
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 60);
        slowPrint("\nWhen would you like to depart?");
        slowPrint("\n1 - AM");
        slowPrint("\n2 - PM\n");
        if (getInput.hasNextInt()){
            amOrPM = getInput.nextInt();
            if (amOrPM == 1){
                slowPrint("What time would you like to leave?\n  1 would be 1 AM \n11 would be 11 AM\n");
                if (getInput.hasNextInt()){
                    hour = getInput.nextInt();
                }
            } else {
                slowPrint("What time would you like to leave?\n 1 would be 1 PM \n11 would be 11 PM\n");
                if (getInput.hasNextInt()){
                    hour = getInput.nextInt();
                }
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(requestedDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
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
