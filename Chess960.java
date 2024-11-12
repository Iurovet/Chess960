import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess960 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner (System.in);
        
        System.out.println("Enter 1 to type in an arrangement and get the position number.");
        System.out.println("Enter 2 to type in a position number and get its arrangement.");
        System.out.println("Enter 3 to generate a random position number and its arrangement.");

        int userChoice = scnr.nextInt();

        if (userChoice == 1) {
            FindNum.run();
        }
        else if (userChoice == 2) {
            FindPos.run();
        }
        else if (userChoice == 3) {
            RandNumPos.run();
        }
        else {
            System.out.println("Invalid choice.");
        }

        scnr.close();
    }
}