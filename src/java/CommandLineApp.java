import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CommandLineApp {

    // create scanner
    Scanner getInput = new Scanner(System.in);
    int distance;
    int speedOfPlaneInKilometersPerHour;

    public void start(Customer customer, BoardingPass boardingPass) {
        // get customer info
        requestName(customer);
        requestEmail(customer);
        requestNumber(customer);
        requestGender(customer);
        requestAge(customer);
        // copy customer number to boarding pass number
        boardingPass.setBoardingPassNumber(customer.getCustomerNumber());
        // generate boarding pass
        generateBPNumber(boardingPass);
        requestDepartureLocation(boardingPass);
        requestDestinationLocation(boardingPass);
        httpCallForDistanceAndFlightTime(boardingPass);
        // ask for dates then generate options
        generateFlightsToDestination(3, boardingPass);
        setArrivalTime(boardingPass);
        generateTicketPrice(customer,boardingPass);
        generateBPNumber(customer, boardingPass);
        System.out.println(boardingPass.getTicketPrice());
//        generateFlightsToOrigin(3, boardingPass);
        System.out.println(customer);
        System.out.println(boardingPass);
        // close scanner
        getInput.close();
    }

    public void requestName(Customer customer) {
        slowPrint("What is your full legal name? \n");
        String input = getInput.nextLine();
        customer.setName(input);
    }

    public void requestEmail(Customer customer) {
        slowPrint("What is your email? \n");
        String input = getInput.nextLine();
        customer.setEmail(input);
    }

    public void requestNumber(Customer customer) {
        slowPrint("What is your phone number? Format: 1234567890 \n");
        String input = getInput.nextLine();
        customer.setNumber(input);
    }

    public void requestGender(Customer customer) {
        slowPrint("What is your gender? Format: 1-4 \n");
        int i = 1;
        for (Customer.Genders gender : Customer.Genders.values()) {
            System.out.println(i + " " + gender + "\t");
            i++;
        }
        int input;
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
        } else {
            input = 5;
        }
        switch (input) {
            case 1:
                customer.setGender(Customer.Genders.Male);
                break;
            case 2:
                customer.setGender(Customer.Genders.Female);
                break;
            case 3:
                customer.setGender(Customer.Genders.Other);
                break;
            case 4:
                customer.setGender(Customer.Genders.Java_Developer);
                break;
        }
    }


    public void generateBPNumber(BoardingPass boardingPass){
        int boardingPassHashCode = Math.abs(boardingPass.hashCode());
        boardingPass.setBoardingPassNumber(boardingPassHashCode);
    }

    public void requestAge(Customer customer) {
        slowPrint("What is your age? Format: 18 \n");
        int input;
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
            customer.setAge(input);
        } else {
            slowPrint("Please use numbers only. \n");
            requestAge(customer);
        }
    }

    public void requestDepartureLocation(BoardingPass boardingPass) {
        slowPrint("What is your departure city?\n");
        int i = 1;
        for (BoardingPass.Locations location : BoardingPass.Locations.values()) {
            System.out.println(i + " " + location + "\t");
            i++;
        }
        int input;
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
            if (input >= 1 && input <= 20) {
                switch (input) {
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

    public void requestDestinationLocation(BoardingPass boardingPass) {
        slowPrint("What is your arrival city?\n");
        int i = 1;
        for (BoardingPass.Locations location : BoardingPass.Locations.values()) {
            System.out.println(i + " " + location + "\t");
            i++;
        }
//        System.out.println("\n");
        int input;
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
            if (input >= 1 && input <= 20) {
                switch (input) {
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

    public void httpCallForDistanceAndFlightTime(BoardingPass boardingPass) {
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
                distance = Integer.parseInt(ja.get(0).toString()); // distance in km
                speedOfPlaneInKilometersPerHour = 865; // speed of boeing 777 in kilometers per hour
                int timeToCruisingAltitudePenalty = 3600;  // 1 hour in seconds
                int tripTimeInSeconds = ((((distance / speedOfPlaneInKilometersPerHour) * 60) * 60) + timeToCruisingAltitudePenalty);// trip time in seconds
//                System.out.println("\ntrip time in seconds: " + tripTimeInSeconds);
                double milliseconds = tripTimeInSeconds * 1000.0; // trip time in milliseconds
//                System.out.println("\ntrip time in milliseconds: " + milliseconds);
//                System.out.println("\nDistance in kilometers: " + distance);
                // date test
                Calendar calendar = Calendar.getInstance();
                Date today = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
//                System.out.println("\nCurrent time: " + sdf.format(today));
                // add milliseconds to date
                calendar.add(Calendar.MILLISECOND, (int) milliseconds);
                Date addMilliSeconds = calendar.getTime();
//                System.out.println("\nTime after" + tripTimeInSeconds + " seconds: " + sdf.format(addMilliSeconds));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String requestYearLeaving() {
        String year = "";
        String date = null;
        // request year leaving

        slowPrint("What year would you like to leave?\n");
        // old
//        slowPrint("Example: 2022\n");
//        if (getInput.hasNextInt()) {
//            input = getInput.nextInt();
//        }
        // new
        slowPrint("1 - 2022\n");
        slowPrint("2 - 2023\n");
        if (getInput.hasNextInt()){
            int input = getInput.nextInt();
            if (input == 1){
                year = "2022";
            } else if (input == 2){
                year = "2023";
            }
            else {
                slowPrint("please choose 1 or 2");
                requestYearLeaving();
            }
        }

        date = String.valueOf(year + "-");
        return date;
    }

    public String requestMonthLeaving(String date) {
        int input;
        // request month leaving
        slowPrint("\nWhat month would you like to leave?\n");
        int i = 1;
        for (BoardingPass.Months month : BoardingPass.Months.values()) {
            System.out.println(i + " " + month + "\t");
            i++;
        }
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
            if (input >= 1 && input <= 12) {
                switch (input) {
                    // use fallthrough for input month 1 or 01
                    case 1:
                        date += "01-";
                        break;
                    case 2:
                        date += "02-";
                        break;
                    case 3:
                        date += "03-";
                        break;
                    case 4:
                        date += "04-";
                        break;
                    case 5:
                        date += "05-";
                        break;
                    case 6:
                        date += "06-";
                        break;
                    case 7:
                        date += "07-";
                        break;
                    case 8:
                        date += "08-";
                        break;
                    case 9:
                        date += "09-";
                        break;

                    case 10:
                        date += "10-";
                        break;
                    case 11:
                        date += "11-";
                        break;
                    case 12:
                        date += "12-";
                        break;
                }
            }
        }
        return date;
    }

    public Date requestDateLeaving(String date) {
        int input;
        // request day leaving
        slowPrint("\n What day would you like to leave?\n");
        if (getInput.hasNextInt()) {
            input = getInput.nextInt();
            if (input >= 1 && input <= 9) {
                date += "0" + input;
            }
            if (input >= 10 && input <= 31) {
                date += input;
            }
        }
        // create date from input
        Date newDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            newDate = formatter.parse(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    public Date setDateDepartingOrigin(){
        String tempDate = requestYearLeaving();
        tempDate = requestMonthLeaving(tempDate);
        return requestDateLeaving(tempDate);
    }

    public Date setDateDepartingDestination(){
        String tempDate = requestYearLeaving();
        tempDate = requestMonthLeaving(tempDate);
        return requestDateLeaving(tempDate);
    }

    public void generateFlightsToDestination(int numberOfFlightsToGenerate, BoardingPass boardingPass){
        Date date = setDateDepartingDestination();
        // generate 3 flights, Morning, Afternoon and Evening from incoming Date
        int randomMorningHour = ThreadLocalRandom.current().nextInt(0,  11);
        int randomAfternoonHour = ThreadLocalRandom.current().nextInt(12,  + 16);
        int randomEveningHour = ThreadLocalRandom.current().nextInt(16,  + 24);
        int randomMorningMinutes = ThreadLocalRandom.current().nextInt(0,  60);
        int randomAfternoonMinutes = ThreadLocalRandom.current().nextInt(0,  60);
        int randomEveningMinutes = ThreadLocalRandom.current().nextInt(0,  60);
        ArrayList<Date> dates = new ArrayList<Date>();
        Calendar one = Calendar.getInstance();
        one.setTime(date);
        one.add(Calendar.HOUR_OF_DAY, randomMorningHour);
        one.add(Calendar.MINUTE, randomMorningMinutes);
        dates.add(one.getTime());
        Calendar two = Calendar.getInstance();
        two.setTime(date);
        two.add(Calendar.HOUR_OF_DAY, randomAfternoonHour);
        two.add(Calendar.MINUTE, randomAfternoonMinutes);
        dates.add(two.getTime());
        Calendar three = Calendar.getInstance();
        three.setTime(date);
        three.add(Calendar.HOUR_OF_DAY, randomEveningHour);
        three.add(Calendar.MINUTE, randomEveningMinutes);
        dates.add(three.getTime());
        slowPrint("\nWhich flight would you like? Example: 1\n");
        int i = 1;
        for (Date flightDate : dates) {
            System.out.println(i + " - " + flightDate + "\n");
            i++;
        }
        if (getInput.hasNextInt()){
            int input = getInput.nextInt();
            boardingPass.setDepartureTime(dates.get(input - 1));
        }
    }

    public void generateFlightsToOrigin(int numberOfFlightsToGenerate, BoardingPass boardingPass){
        Date date = setDateDepartingDestination();
        // generate 3 flights, Morning, Afternoon and Evening from incoming Date
        int randomMorningHour = ThreadLocalRandom.current().nextInt(0,  11 + 1);
        int randomAfternoonHour = ThreadLocalRandom.current().nextInt(12,  + 16 + 1);
        int randomEveningHour = ThreadLocalRandom.current().nextInt(16,  + 24 + 1);
        int randomMorningMinutes = ThreadLocalRandom.current().nextInt(0,  60 + 1);
        int randomAfternoonMinutes = ThreadLocalRandom.current().nextInt(0,  60 + 1);
        int randomEveningMinutes = ThreadLocalRandom.current().nextInt(0,  60 + 1);
        ArrayList<Date> dates = new ArrayList<Date>();
        Calendar one = Calendar.getInstance();
        one.setTime(date);
        one.add(Calendar.HOUR_OF_DAY, randomMorningHour);
        one.add(Calendar.MINUTE, randomMorningMinutes);
        dates.add(one.getTime());
        Calendar two = Calendar.getInstance();
        two.setTime(date);
        two.add(Calendar.HOUR_OF_DAY, randomAfternoonHour);
        two.add(Calendar.MINUTE, randomAfternoonMinutes);
        dates.add(two.getTime());
        Calendar three = Calendar.getInstance();
        three.setTime(date);
        three.add(Calendar.HOUR_OF_DAY, randomEveningHour);
        three.add(Calendar.MINUTE, randomEveningMinutes);
        dates.add(three.getTime());
        slowPrint("\nWhich flight would you like? Example: 1\n");
        int i = 1;
        for (Date flightDate : dates) {
            System.out.println(i + " - " + flightDate + "\n");
            i++;
        }
        if (getInput.hasNextInt()){
            int input = getInput.nextInt();
            boardingPass.setArrivalTime(dates.get(input - 1));
        }
    }

    public void setArrivalTime(BoardingPass boardingPass){
        Date departureTime = boardingPass.getDepartureTime();
        long departureLong = departureTime.getTime();
        int timeInHours = distance / speedOfPlaneInKilometersPerHour;
        // convert to seconds
        long timeInMilliseconds = timeInHours * 3600000L;
        Date ETA = new Date(departureLong + timeInMilliseconds);
        boardingPass.setArrivalTime(ETA);
        boardingPass.setEta(getDurationBreakdown(timeInMilliseconds));
    }

    public static String getDurationBreakdown(long millis) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(days);
        sb.append(" Days ");
        sb.append(hours);
        sb.append(" Hours ");
        sb.append(minutes);
        sb.append(" Minutes ");
        sb.append(seconds);
        sb.append(" Seconds");

        return(sb.toString());
    }

    public void generateTicketPrice(Customer customer, BoardingPass boardingPass){
        double standardPrice = (distance / 18.8);
        // less than 12 = 50% off
        if (customer.getAge() <= 12){
            boardingPass.setTicketPrice(standardPrice * 0.5);
        }
        // greater than 12 && < 60 = normal price
        if(customer.getAge() > 12 && customer.getAge() < 60){
            boardingPass.setTicketPrice(standardPrice);
            // check if female
            if (customer.getGender() == Customer.Genders.Female){
                boardingPass.setTicketPrice(standardPrice * 0.75);
            }
        }
        // if customer is over 60
        if (customer.getAge() >= 60){
            boardingPass.setTicketPrice(standardPrice * 0.40);
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
