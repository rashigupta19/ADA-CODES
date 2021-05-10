package midTerm;

public class NQueen {
	public final static int N = 8;
	public static int[] x = new int[N + 1];
	public static boolean place(int k) {
		for(int i = 1; i < k; i++) {
			if(x[i] == x[k] || Math.abs(x[i] - x[k]) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}
	public static void nqueen(int n) {
		int k = 1;
		x[k] = 0;
		while(k > 0) {
			x[k] = x[k] + 1;
			while(x[k] <= n && !place(k)) {
				//System.out.print("===" + k + "==== ");
				x[k] = x[k] + 1;
			}
			if(x[k] <= n) {
				if(k == n) {
					for(int i = 1; i<= N; i++) {
						System.out.print(x[i] + " ");
					}
					System.out.println();
					//break;
				} else {
					k++;
					x[k] = 0;
				}
			} else {
				k--;
			}
		}
	}
	public static void main(String[] args) {
		nqueen(N);
	}
}	