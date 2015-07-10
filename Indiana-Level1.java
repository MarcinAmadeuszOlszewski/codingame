import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        String[][] mapa = new String[H][];
        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            mapa[i] = LINE.split(" ");
        System.err.println(LINE);
        
            
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        in.nextLine();
    
        String odp = "";
        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            in.nextLine();
            
            System.err.println(XI+" "+YI+ " mapa "+ mapa[YI][XI]);
            
            String kier = gdzie(mapa[YI][XI], POS);
            System.err.println("kier "+ kier);
            switch(kier)
            {
                case "P":   odp = XI+1+" "+YI; break;
                case "L":   odp = XI-1+" "+YI; break;
                case "D":   odp = XI+" "+(YI+1); break;
                default:    System.err.println("ERROR");
            }
            
            System.out.println(odp); // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
        }
    }
    
    static String gdzie(String nr, String kier){
        String wyjscie = "";

        switch(nr)
        {
            case "1":
            case "3":   
            case "7":
            case "8":
            case "9":
            case "12":
            case "13":    wyjscie = "D";break;
            case "2":     if(kier.equals("LEFT")) wyjscie = "P"; else wyjscie = "L" ; break;
            case "4":     if(kier.equals("TOP")) wyjscie = "L"; else wyjscie = "D" ; break;
            case "5":     if(kier.equals("TOP")) wyjscie = "P"; else wyjscie = "D" ; break;
            case "6":     if(kier.equals("TOP")) wyjscie = "E"; else if(kier.equals("LEFT")) wyjscie = "P"; else wyjscie = "L" ; break;
            case "10":    if(kier.equals("TOP")) wyjscie = "L"; else wyjscie = "E" ; break;
            case "11":    if(kier.equals("TOP")) wyjscie = "P"; else wyjscie = "E" ; break;
            default:    wyjscie = "E" ; break;
        }
        
        return wyjscie;
    }
}