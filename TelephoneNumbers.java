import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashSet<String> wyniki = new HashSet<>(6000);
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            for(int j=1; j<=telephone.length(); j++)
                wyniki.add(telephone.substring(0, j));
            }
        System.out.println(wyniki.size()); // The number of elements (referencing a number) stored in the structure.
    }
}