import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution
{
	static int x = -9, y = -9, kier = 1;
	static List<String> wynik = new ArrayList<>(300);
	static boolean noBeer = true, inverter = false;
	static String[] arena;

	static void szukajStartu()
	{
		for (int i = 0; i < arena.length; i++)
		{
			if (arena[i].indexOf("@") > 0)
			{
				x = arena[i].indexOf("@");
				y = i;
			}
		}
	}

	static void nowaDroga()
	{
		int[] kierr = { 1, 10, -1, -10 };
		int[] kierunkiI = { -10, -1, 10, 1 };

		if (inverter)
			kierr = kierunkiI;

		for (int kk : kierr)
			if (!(przeszkoda(kk, true)))
			{
				kier = kk;
				break;
			}
	}

	static boolean przeszkoda(int kieru, boolean cos)
	{
		return (arena[y + kieru % 10].charAt(x + kieru / 10) == '#' || (arena[y + kieru % 10].charAt(x + kieru / 10) == 'X' && cos));
	}

	static void ruch()
	{
		switch (kier)
		{
		case 1:	    wynik.add("SOUTH"); y++; break;
		case 10:	wynik.add("EAST");  x++; break;
		case -1:	wynik.add("NORTH"); y--; break;
		case -10:   wynik.add("WEST");  x--; break;
		}
	}

	static void grunt(char literka)
	{
		switch (literka)
		{
		case 'B':   noBeer = !noBeer;       break;
		case 'I':   inverter = !inverter;   break;
		case 'S':   kier = 1;               break;
		case 'E':   kier = 10;              break;
		case 'N':   kier = -1;              break;
		case 'W':   kier = -10;             break;
		case 'X':   arena[y] = arena[y].substring(0, x) + " " + arena[y].substring(x + 1);  break;
		case 'T':   teleport();             break;
		}
	}

	static void teleport()
	{
		for (int i = 0; i < arena.length; i++)
			if (arena[i].indexOf("T") > 0 && (y != i || arena[i].indexOf("T") != x))
			{
				x = arena[i].indexOf("T");
				y = i;
				break;
			}
	}

	static void koniec()
	{
		if (wynik.size() > 298)
			System.out.println("LOOP");
		else
			for (String w : wynik)
				System.out.println(w);
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		in.nextLine();
		arena = new String[L];
		for (int i = 0; i < L; i++)
			arena[i] = in.nextLine();
		szukajStartu();

		while (wynik.size() < 300 && arena[y].charAt(x) != '$')
		{
			if (przeszkoda(kier, noBeer))
				nowaDroga();
			ruch();
			grunt(arena[y].charAt(x));
		}
		koniec();
	}
}