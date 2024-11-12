import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RandNumPos {
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
        Random rand = new Random();
        int foundNum = rand.nextInt(960);

        System.out.println("\nPosition number " + foundNum + " was randomly selected");
        System.out.println("The arrangemeent of pieces based off this number is:");
        System.out.println(readFile(foundNum));

        if (foundNum == 518) {
            System.out.println("This is the arrangement of pieces as in regular chess");
        }
    }
}