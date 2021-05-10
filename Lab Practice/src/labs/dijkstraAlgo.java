package labs;

public class dijkstraAlgo {		


	static int V = 5; 
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 

		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) { 
				min = dist[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 


	void printSolution(int dist[]) 
	{ 
		System.out.println("Vertex : : : Distance from Source"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t\t " + dist[i]); 
	} 


	void dijkstra(int graph[][], int src) 
	{ 
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V]; 


		for (int i = 0; i < V; i++) { 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		dist[src] = 0; 


		for (int count = 0; count < V - 1; count++) { 

			int u = minDistance(dist, sptSet); 


			sptSet[u] = true; 


			for (int v = 0; v < V; v++) 


				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
					dist[v] = dist[u] + graph[u][v]; 
		} 

		// printing pqrt
		printSolution(dist); 
	} 


	public static void main(String[] args) 
	{ 

		int graph[][] = new int[][] {{ 0, 3, 0, 0, 5}, 
									{ 0, 0, 8, 5, 3 }, 
									{ 0, 0, 0, 0, 0 }, 
									{ 0, 2, 0, 0, 0 }, 
									{ 0, 0, 0, 4, 0 },  };
			dijkstraAlgo t = new dijkstraAlgo(); 
			t.dijkstra(graph, 0); 
	} 

}