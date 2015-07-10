import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    static int[] dane, tmp;
    static int n;
    static int suma = 0;
    static Scanner in;
    static void inicjacja(){
        n = in.nextInt();
        dane = new int[n];
        tmp = new int[n];
    }
    
    static void wynik()
    {
        for (int i = 0; i < n; i++) 
            System.out.println(tmp[i]);
    }

    public static void main(String args[]) {
        in = new Scanner(System.in);
        inicjacja();
        int C = in.nextInt();
        for (int i = 0; i < n; i++) {
            dane[i]= in.nextInt();;
            suma += dane[i];
        }
        if(suma<C)
        {
            System.out.println("IMPOSSIBLE");
            return;
        }
        else
        {
            suma = 0;
            Arrays.sort(dane);
            while(suma<C)
                for(int i=n-1; i>=0; i--)
                    if(suma<C && tmp[i]<dane[i])
                    {
                        tmp[i]++;
                        suma++;
                    }
        }
        wynik();


    }
}