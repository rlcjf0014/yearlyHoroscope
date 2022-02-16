import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * YearlyHoroscope.java
 * Joshua Song, Carleton College, 2021-09-23
 *
 * A class that takes the horoscope text file via input file path from the 
 * command line and takes console input to determine zodiac sign and print
 * the relevant horoscope. There are two horoscope text files that contain 
 * horoscopes for twelve zodiac signs. 
 * 
 * The program can be run like: 
 * java YearlyHoroscope CareerHoroscope.txt 
 * 
 * After the program runs, it can give horoscopes as many times as you want 
 * until you put in the necessary console input. Once you exit the program, 
 * the number of times you got a horoscope will be displayed on console.  
 */

public class YearlyHoroscope {
    /**
     * These are the instance variables. 
     * ZODIACSIGN is a constant variable because its value will not change. 
     */
    private final String[] ZODIACSIGN = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio",
            "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
    private int userBirthDate;
    private String userZodiacSign;
    private String horoscopeGenre;
    private static int horoscopeFrequency = 0;

    // Constructor defined
    public YearlyHoroscope() {
        userBirthDate = 0;
        userZodiacSign = "";
        horoscopeGenre = "";
    }

    /**
     * Sets the genre of horoscope to be displayed
     * @param filePath the file path put in via command line
     */
    public void setHoroscopeGenre(String filePath) {
        // Gets rid of .txt from file path by cutting the string within bound
        horoscopeGenre = filePath.substring(0, filePath.length() - 4);
    }

    /**
     * Sets the zodiac sign of user after calculation
     * @param birthDate the birth date of user
     */
    public void setUserZodiacSign(int birthDate) {
        // Use birth date as number to determine the zodiac sign of user
        if (birthDate >= 321 && birthDate <= 419) {
            userZodiacSign = ZODIACSIGN[0];
        } else if (birthDate >= 420 && birthDate <= 520) {
            userZodiacSign = ZODIACSIGN[1];
        } else if (birthDate >= 521 && birthDate <= 620) {
            userZodiacSign = ZODIACSIGN[2];
        } else if (birthDate >= 621 && birthDate <= 722) {
            userZodiacSign = ZODIACSIGN[3];
        } else if (birthDate >= 723 && birthDate <= 822) {
            userZodiacSign = ZODIACSIGN[4];
        } else if (birthDate >= 823 && birthDate <= 922) {
            userZodiacSign = ZODIACSIGN[5];
        } else if (birthDate >= 923 && birthDate <= 1022) {
            userZodiacSign = ZODIACSIGN[6];
        } else if (birthDate >=1023 && birthDate <= 1121) {
            userZodiacSign = ZODIACSIGN[7];
        } else if (birthDate >= 1122 && birthDate <= 1221) {
            userZodiacSign = ZODIACSIGN[8];
        } else if (birthDate >= 120 && birthDate <= 218) {
            userZodiacSign = ZODIACSIGN[10];
        } else if (birthDate >= 219 && birthDate <= 320) {
            userZodiacSign = ZODIACSIGN[11];
        } else {
            userZodiacSign = ZODIACSIGN[9];
        }
    }

    /**
     * Sets the user's birth date
     * @param birthMonth birth month of user
     * @param birthDay birthday of user
     */
    public void setUserBirthDate(String birthMonth, String birthDay) {
        // When birthday is one digit, add a 0 in front of the day.
        String checkDay = birthDay.length() == 1 ? "0" + birthDay : birthDay;
        // Combine birth month and birthday together and turn it into an integer
        userBirthDate = Integer.parseInt(birthMonth+checkDay); 
    }

    /**
     * Returns a string that represents the user's zodiac sign
     * @return string representing user's zodiac sign
     */
    public String getUserZodiacSign() {
        return userZodiacSign;
    }

    /**
     * Returns an integer that represents the user's birth date.
     * @return int representing user's birth date.
     */
    public int getUserBirthDate() {
        return userBirthDate;
    }

    /**
     * Finds a horoscope by the user's zodiac sign from the given file
     * and returns a string that represents the user's horoscope.
     * @param fileScanner instace of class Scanner
     * @param zodiacSign user's zodiac sign
     * @return
     */
    public String getHoroscopeLine(Scanner fileScanner, String zodiacSign) {
        String horoscope = "";
        // Find the line that contains the user's zodiac sign in the text file via for loop. 
        for (int i = 0; i< 12; i++) {
            try {
                String line = fileScanner.nextLine();
                if (line.contains(zodiacSign)){
                    horoscope = line;
                    break;
                }
            } catch (NoSuchElementException e) {
                horoscope = "";
            }
        }
        return horoscope;
    }

    /**
     * Sets the number of times user got horoscope. 
     */
    public void setHoroscopeFrequency() {
        horoscopeFrequency += 1;
    }

    public static void main(String[] args) {
        // Check whether a file was put in as part of command line
        if (args.length == 0) {
            System.err.println("Please put in a txt file to read");
            System.exit(1);
        }
        String inputFilePath = args[0];

        File inputFile = new File(inputFilePath);
        Scanner fileScanner = null;
        
        // Set condition for while loop so horoscope can be given as many times as user wants.
        Boolean runAgain = true;
        while (runAgain) {
        try {
            // Create scanner with input file so it can be read again.
            fileScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        // Print message for the start of program to user
        System.out.println("\nWelcome to Yearly Horoscope! \n\nPlease enter your birth month in number. (MM)");
            
        // Create an instance of the class for methods
        YearlyHoroscope newHoroscope = new YearlyHoroscope();
        // Designate the type of horoscope
        newHoroscope.setHoroscopeGenre(inputFilePath);
        
        // Create Scanner for user's console input
        Scanner inputScanner = new Scanner(System.in);
        int userInput=0;
        try {
            // Read user's console input as integer
            userInput = inputScanner.nextInt();
        } catch (InputMismatchException e) {
            // Exit program if user does not enter a number
            System.err.println("\nRestart Program and Please enter a number");
            System.exit(1);
        }
        
        // Check if user's birth month is less than 12 and repeat until the number is in bounds.
        while (userInput <= 0 || userInput > 12) {
            System.err.println("\n*Please enter birth month in a correct format in the boundary of 1 to 12 (MM)*");
            try{
                userInput = inputScanner.nextInt();
            } catch (InputMismatchException e) {
                // Exit program if user does not enter a number
                System.err.println("\nRestart Program and Please enter a number");
                System.exit(1);
            }
        }

        // Hold value for birth month
        String userBirthMonth = String.valueOf(userInput);

        System.out.println("\nPlease enter your birth day in number.");

        // Use the existing scanner
        try{
            userInput = inputScanner.nextInt();
        } catch (InputMismatchException e) {
            // Exit program if user does not enter a number
            System.err.println("\nRestart Program and Please enter a number");
            System.exit(1);
        }

        // Check if user's birth day is less than 31 and repeat until the number is in bounds.
        while (userInput <= 0 || userInput > 31) {
            System.err.println("*Please enter birth day in a correct format in the boundary of 1 to 31 (DD)*");
            try{
                userInput = inputScanner.nextInt();
            } catch (InputMismatchException e) {
                // Exit program if user does not enter a number
                System.err.println("\nRestart Program and Please enter a number");
                System.exit(1);
            }
        }

        // Hold value for birth day
        String userBirthDay = String.valueOf(userInput);
        // Set birth date and zodiac sign of user
        newHoroscope.setUserBirthDate(userBirthMonth, userBirthDay);
        newHoroscope.setUserZodiacSign(newHoroscope.userBirthDate);

        // Get horoscope line of user.
        String horoscopeForUser = newHoroscope.getHoroscopeLine(fileScanner, newHoroscope.userZodiacSign);

        // Print exception in case the horoscope does not exist
        if (horoscopeForUser.length() == 0) {
            String zodiac = newHoroscope.userZodiacSign;
            System.out.format("Sorry, we do not yet have a horoscope for your zodiac sign %s", zodiac);
        }

        // Print result
        System.out.format("\nYour zodiac sign is %s! \n\nYour %s is \n\n%s", newHoroscope.userZodiacSign, newHoroscope.horoscopeGenre, horoscopeForUser);
        System.out.println("\n\nDo you want to try again with a different birth date for someone else?");
        System.out.println("\nType Yes or Exit");

        // Format so console input string can be read in both lower and upper case. 
        String finalInput = inputScanner.next().toLowerCase();
        // Receive user console input until the input is exit or yes. 
        while (!finalInput.equals("exit") && !finalInput.equals("yes")){
            System.out.println("\nPlease Type Yes or Exit");
            finalInput = inputScanner.next();
        }

        // Break out of loop if user inputs exit.
        if (finalInput.equals("exit")) {
            newHoroscope.setHoroscopeFrequency();
            fileScanner.close();
            inputScanner.close();
            break;
        } else {
            // Increase horoscope frequency and go back to start of while loop. 
            newHoroscope.setHoroscopeFrequency();
        }
    }
    // Print how many times user got horoscopes. 
    System.out.format("\nThank you for using Yearly Horoscope. You received yearly horoscope %d time(s)", horoscopeFrequency);
}}

