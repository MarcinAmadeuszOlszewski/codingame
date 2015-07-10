import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static int XP, YP, XPP=0, YPP=0;

    static int delta(int c, int p){
        int w = (int) Math.ceil(Math.abs((p-c)/2.0));
        return w;
    }
    
    static int vv(int c, int m)
    {
        if(c>=m)
            return m-1;
        else
            return c<0? 0: c;
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        boolean pierwszy = true;
        int dX, dY; 

        // game loop
        while (true) {
            String BOMB_DIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            if(pierwszy)
            {
                if(BOMB_DIR.indexOf('U') >= 0)
                    YP=0;
                else
                    YP=(int) (H*1.0);
                    
                if(BOMB_DIR.indexOf('L') >= 0)
                    XP=0;
                else
                    XP=(int) (W*1.0);
                    
                pierwszy = false;
            }
            
            dX = delta(XP, X0);
            dY = delta(YP, Y0);
            
            XPP= XP;
            YPP= XP;
            XP = X0;
            YP = Y0;
            
            switch(BOMB_DIR)
            {
                case "U":                       Y0 = vv(Y0-dY, H)    ;break;
                case "UR":  X0 = vv(X0+dX, W);  Y0 = vv(Y0-dY, H)    ;break;
                case "R":   X0 = vv(X0+dX, W)                        ;break;
                case "DR":  X0 = vv(X0+dX, W);  Y0 = vv(Y0+dY, H)    ;break;
                case "D":                       Y0 = vv(Y0+dY, H)    ;break;
                case "DL":  X0 = vv(X0-dX, W);  Y0 = vv(Y0+dY, H)    ;break;
                case "L":   X0 = vv(X0-dX, W)                        ;break;
                case "UL":  X0 = vv(X0-dX, W);  Y0 = vv(Y0-dY, H)    ;break;
            }
            

            System.out.println(X0+" "+Y0); // the location of the next window Batman should jump to.
        }
    }
}