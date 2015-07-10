import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution
{
	static List<Character> listaTmp = new ArrayList<>();
	static List<String> wynikiLista = new ArrayList<>();
	static int index = 0, tmp = 0;
	static String odp = "";
		
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		List<String> slownik = new ArrayList<>(N);
		for (int i = 0; i < N; i++)	{
			String W = in.nextLine();
			if (W.length() < 8)
				slownik.add(W);
		}
		String LETTERS = in.nextLine();
		
		for (Character z : LETTERS.toCharArray())
			listaTmp.add(z);
		for (String tmp : slownik)
			wynikiSzukaj(tmp);
		for (String q : wynikiLista)
			if ((index = wartosc(q)) > tmp)
			{
				tmp = index;
				odp = q;
			}

		System.out.println(odp);
	}

	static void wynikiSzukaj(String tmp)
	{
		List<Character> listaSlowa = new ArrayList<>();
		for (Character z : tmp.toCharArray())
			listaSlowa.add(z);

		for (Character x : listaTmp)
			for (Character y : listaSlowa)
				if (x.equals(y)){
					listaSlowa.remove(x);
					break;
				}
			
		if (listaSlowa.size() == 0)
			wynikiLista.add(tmp);
	}

	static int wartosc(String q)
	{
		int wartos = 0;
		for (int i = 0; i < q.length(); i++)
		{
			switch (q.charAt(i))
			{
			default :   wartos++;       break;
			case 'd':
			case 'g':	wartos += 2;    break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':	wartos += 3;    break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':	wartos += 4;    break;
			case 'k':	wartos += 5;    break;
			case 'j':
			case 'x':	wartos += 8;    break;
			case 'q':
			case 'z':	wartos += 10;   break;
			}
		}
		return wartos;

	}
}