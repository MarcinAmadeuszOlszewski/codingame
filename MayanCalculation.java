import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution
{

	public static Cyferka[] cyf = new Cyferka[20];
	public static Cyferka[] cyf1;
	public static Cyferka[] cyf2;
	
	public static Cyferka[] inicjacja(int max)
	{
		Cyferka[] cc = new Cyferka[max];
		for (int i = 0; i < max; i++)
			cc[i] = new Cyferka();
		return cc;
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int H = in.nextInt();
		
		cyf = inicjacja(20);
		for (int i = 0; i < H; i++){
			String numeral = in.next();
			for (int j = 0; j < 20; j++){
					cyf[j].add(numeral.substring(j * L, j * L + L));
					cyf[j].symbol = j;
			}
		}

		int S1 = in.nextInt();
		cyf1 = inicjacja(S1 / H);
		for (int i = 0; i < S1; i++)
			cyf1[i / H].add(in.next());

		int S2 = in.nextInt();
		cyf2 = inicjacja(S2 / H);
		for (int i = 0; i < S2; i++)
			cyf2[i / H].add(in.next());

		List<Long> w = konwersjaWyniku(obliczenie(wartosc(rozpoznanie(cyf1)), in.next(), wartosc(rozpoznanie(cyf2))));
		for (int i = w.size() - 1; i >= 0; i--)
			System.out.print(cyf[(int) (long) w.get(i)]);
	}

	static long obliczenie(int c1, String op, int c2)
	{
		switch (op)
		{
		case "*":
			return (long) c1 * (long) c2;
		case "/":
			return (long) c1 / (long) c2;
		case "+":
			return (long) c1 + (long) c2;
		case "-":
			return (long) c1 - (long) c2;
		default: 
			return 0L;
		}
	}

	static List<Long> konwersjaWyniku(Long cc)
	{
		List<Long> wyniki = new ArrayList<>();
		while (cc / 20 > 0)
		{
			wyniki.add(cc % 20);
			cc = cc / 20;
		}
		wyniki.add(cc);

		return wyniki;
	}

	static int wartosc(int[] lista)
	{
		int wynik = 0;
		int j = 0;
		for (int i = lista.length - 1; i >= 0; i--)
		{
			wynik += lista[i] * Math.pow(20, j);
			j++;
		}
		return wynik;
	}

	static int[] rozpoznanie(Cyferka[] cc)
	{
		int[] wynik = new int[cc.length];
		int i = 0;
		for (Cyferka sz : cc)
			for (Cyferka c : cyf)
				if (c.equals(sz.linie))
				{
					wynik[i] = c.symbol;
					i++;
				}

		return wynik;
	}
}

class Cyferka
{
	public int symbol;
	public List<String> linie = new ArrayList<>();

	public void add(String linia)
	{
		linie.add(linia);
	}

	@Override
	public boolean equals(Object arg0)
	{
		@SuppressWarnings("unchecked")
		List<String> arg = (ArrayList<String>) arg0;
		for (int i = 0; i < linie.size(); i++)
			if (!this.linie.get(i).equals(arg.get(i)))
				return false;
		return true;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public String toString()
	{
		String wynik = "";
		for (int i = 0; i < linie.size(); i++)
			wynik += (linie.get(i) + "\n");

		return (wynik);
	}
}