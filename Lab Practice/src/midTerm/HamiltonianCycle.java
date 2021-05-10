package midTerm;

public class HamiltonianCycle
{
	final int V = 5;
	int path[];
	boolean canBeAdded(int v, int graph[][], int path[], int pos)
	{
		if (graph[path[pos - 1]][v] == 0)
			return false;

		for (int i = 0; i < pos; i++)
			if (path[i] == v)
				return false;

		return true;
	}


	boolean hamCycle(int graph[][], int path[], int pos)
	{

		if (pos == V)
		{
			if (graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}

		// included 0 as starting point in hamCycle() so v =1
		for (int v = 1; v < V; v++)
		{
			/* Check if this vertex can be added to Hamiltonian
			Cycle */
			if (canBeAdded(v, graph, path, pos))
			{
				path[pos] = v;

				if (hamCycle(graph, path, pos + 1) == true)
					return true;

				path[pos] = -1;
			}
		}

		return false;
	}
	
	

	int hamCycle(int graph[][])
	{
		path = new int[V];
		for (int i = 0; i < V; i++)
			path[i] = -1;

		path[0] = 0;
		if (hamCycle(graph, path, 1) == false)
		{
			System.out.println("\nHamiltonian Cycle does not exist");
			return 0;
		}

		printSolution(path);
		return 1;
	}

	void printSolution(int path[])
	{
		System.out.println("Hamiltonian Cycle Exists:");
		for (int i = 0; i < V; i++)
			System.out.print(" " + path[i] + "-> ");

		System.out.println(" " + path[0] + " ");
	}

	public static void main(String args[])
	{
		HamiltonianCycle hamiltonian =
								new HamiltonianCycle();
		int graph[][] = {{0, 1, 0, 1, 0},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 0, 1},
			{1, 1, 0, 0, 1},
			{0, 1, 1, 1, 0},
		};

		hamiltonian.hamCycle(graph);
		
		 int graph2[][] = {{0, 1, 0, 1, 0},
		            {1, 0, 1, 1, 1},
		            {0, 1, 0, 0, 1},
		            {1, 1, 0, 0, 0},
		            {0, 1, 1, 0, 0},
		        };
		  
		        hamiltonian.hamCycle(graph2);

		
	}
}