import java.util.HashMap;
import java.util.Scanner;

class Player
{

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int nbFloors = in.nextInt(), width = in.nextInt(), nbRounds = in.nextInt(), exitFloor = in.nextInt(), exitPos = in.nextInt(), nbTotalClones = in
				.nextInt(), nbAdditionalElevators = in.nextInt(), nbElevators = in.nextInt();
		boolean[] stopniety = new boolean[nbElevators + 1];
		int[] aele = new int[nbElevators+1];
		for (int i = 0; i < nbElevators; i++)
		{
			int elevatorFloor = in.nextInt();
			int elevatorPos = in.nextInt();
			aele[elevatorFloor] = elevatorPos;
		}
		aele[nbElevators] = exitPos;

		while (true)
		{
			int cloneFloor = in.nextInt(), clonePos = in.nextInt();
			String direction = in.next(), W = "WAIT";
			if (cloneFloor != -1 && !stopniety[cloneFloor])
    			if ( (clonePos > aele[cloneFloor] && direction.equals("RIGHT")) || (clonePos < aele[cloneFloor] && direction.equals("LEFT")))
    			{	
    			    W = "BLOCK";
    			    stopniety[cloneFloor] = true;
		    	}

			System.out.println(W);
		}
	}

}
