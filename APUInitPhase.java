import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    static String[] mapa;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        mapa = new String[height];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            mapa[i] = line;
            System.err.println(line);
        }

        ArrayList<String> wyniki = new ArrayList<>(); 
        String tmp = "";
        
        for(int y=0; y<height; y++)
        {
            for(int x=0; x<width; x++)
            {
                if(mapa[y].charAt(x) == '0'){
                    tmp =x+" "+y;
                    tmp += szukajR(x, y);
                    tmp += szukajD(x, y);
                    wyniki.add(tmp);
                }
                
                
            }
        }
        
        for(String w : wyniki)
            System.out.println(w);
    }
    
    static String szukajR(int x, int y)
    {
        int tmp = mapa[y].indexOf('0', x+1);
        if(tmp == -1)
        {
            return " -1 -1";
        }
        else
        {
            return " "+tmp+" "+y;    
        }
        
    }
    
    static String szukajD(int x, int y)
    {
        for(int i=y+1; i<mapa.length ; i++)
        {
            if(mapa[i].charAt(x) == '0')
            {
                return " "+x+" "+i;
            }
        }
        return " -1 -1";
    }
    
}