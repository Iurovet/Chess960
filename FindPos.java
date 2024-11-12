import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FindPos {
    public static String readFile (int userInput) throws FileNotFoundException{
        FileInputStream numFile = new FileInputStream("positionList.txt");
        Scanner scnr = new Scanner (numFile);

        String arrangement = "";
        for (int i = 0; i <= userInput; ++i) {
            arrangement = scnr.nextLine();
        }

        if (arrangement == "") {
            arrangement = "An arrangement does not exist for your entered position number";
        }

        scnr.close();
        return arrangement;
    }
    
    public static void run() throws FileNotFoundException {
        Scanner scnr = new Scanner (System.in);
        
        System.out.println("\nPlease enter a position number from 0 to 959");
        int userInput = scnr.nextInt();

        while ((userInput < 0) || (userInput > 959)) {
            System.out.println("\nInvalid number entered.");
            userInput = scnr.nextInt();
        }
        scnr.close();
        
        System.out.println("\nThe arrangemeent of pieces based off your entered position number is:");
        System.out.println(readFile(userInput));

        if (userInput == 518){
            System.out.println("This is the arrangement of pieces as in regular chess");
        }
    }
}