import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FindNum {
    public static boolean bishops (String[] chessPieces) {
        int bishop1 = -1;
        int bishop2 = -1;
        int counter = 0;

        for (int i = 0; i < 8; ++i) {
            if (chessPieces[i].equals("Bishop")) {
                if (counter == 0) {
                    bishop1 = i;
                    ++counter;
                }
                else if (counter == 1) {
                    bishop2 = i;
                }
            }
        }

        return (bishop1 % 2) != (bishop2 % 2);
    }

    public static boolean kingRooks (String[] chessPieces) {
        int rook1 = -1;
        int rook2 = -1;
        int king = -1;
        int counter = 0;

        for (int i = 0; i < 8; ++i) {
            if (chessPieces[i].equals("Rook")) {
                if (counter == 0) {
                    rook1 = i;
                    ++counter;
                }
                else if (counter == 1) {
                    rook2 = i;
                }
            }
            else if (chessPieces[i].equals("King")) {
                king = i;
            }
        }

        return (rook2 > king) && (king > rook1);
    }

    public static String readFile (String outputString) throws FileNotFoundException {
        FileInputStream posFile = new FileInputStream("positionList.txt");
        Scanner fileScnr = new Scanner(posFile);
        
        int posNo = -1;
        int i = 0;

        while (fileScnr.hasNextLine()) {
            if (outputString.equals(fileScnr.nextLine())) {
                posNo = i;
                fileScnr.close();
                break;
            }

            ++i;
        }
        
        if (posNo >= 0) {
            return Integer.toString(posNo);
        }
        else {
            return "Not a valid position";
        }
    }

    public static String toCamelCase (String userPiece) {
        userPiece = userPiece.toLowerCase();
        
        userPiece = userPiece.replace("b", "B");
        userPiece = userPiece.replace("r", "R");
        userPiece = userPiece.replace("q", "Q");
        userPiece = userPiece.replace("kn", "Kn");
        userPiece = userPiece.replace("ki", "Ki");

        return userPiece;
    }

    public static boolean valid (String userPiece) {
        ArrayList<String> validNames = new ArrayList<String>();

        validNames.add("Knight");
        validNames.add("Bishop");
        validNames.add("Rook");
        validNames.add("Queen");
        validNames.add("King");

        return validNames.contains(userPiece);
    }

    public static void run() throws FileNotFoundException {
        Scanner scnr = new Scanner (System.in);
        String[] chessPieces = new String[8];
        System.out.println("\nPlease enter the chess pieces");

        for (int i = 0; i < 8; ++i) {
            String userPiece = toCamelCase(scnr.nextLine());
        
            while (!valid(userPiece)) {
                System.out.println("Error: Please enter a valid chess piece name");
                userPiece = toCamelCase(scnr.nextLine());
            }

            chessPieces[i] = userPiece;
        }

        scnr.close();

        if (!bishops(chessPieces)) {
            System.out.println("Error: The bishops are on the same-coloured squares");
        }
        if (!kingRooks(chessPieces)) {
            System.out.println("Error: The king is not between the 2 rooks");
        }

        String outputString = "";
        for (int i = 0; i < 8; ++i) {
            outputString += (chessPieces[i] + " ");
        }

        System.out.println("\n" + outputString);
        System.out.println("\nThis is position number " + readFile(outputString));

        if (readFile(outputString).equals(Integer.toString(518))) {
            System.out.println("This just so happens to be the starting position of regular chess");
        }
    }
}