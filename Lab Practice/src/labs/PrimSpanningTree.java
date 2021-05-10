package labs;
import java.util.Arrays;

class PrimSpanningTree {

	int temp_123=0;

	public void Prim(int G[][], int V) {
		int INF = 999_999_999;

		int no_edge=0; 
		boolean[] selected = new boolean[V];

		// for filling the array prt 
		Arrays.fill(selected, false);
		//no_edge = 0;
		selected[0] = true;
		System.out.println("  E   :  W");

		while (no_edge < V - 1) {

			int min = INF;
			int x = 0; 
			int y = 0; 

			for (int i = 0; i < V; i++) {
				if (selected[i] == true) {
					for (int j = 0; j < V; j++) {

						if (!selected[j] && G[i][j] != 0) {
							if (min > G[i][j]) {
								min = G[i][j];
								x = i;
								y = j;
							}
						}
					}
				}
			}
			System.out.println(x + " - " + y + " :  " + G[x][y]);
			temp_123=G[x][y]+temp_123;
			selected[y] = true;
			no_edge++;
		}
	}

	public static void main(String[] args) {
		PrimSpanningTree g = new PrimSpanningTree();
		int V = 5;
		int[][] G = { { 0, 9, 5, 2, 0 }, { 9, 0, 0, 6, 5 }, { 5, 0, 0, 4, 5 }, { 2, 6, 4, 0, 4 }, { 0, 5, 5, 4, 0 } };

		g.Prim(G, V);
		System.out.println("min. cost is:"+g.temp_123);
	}
}