package labs;

import java.util.Arrays;

public class Knapsack1 {
    public static void main(String args[]) {
        int w = 10;
        int n = 4;
        int[] val = {90, 40, 30, 50};
        int[] wt = {1, 2, 6, 3};

        // Case where row=0 and column=0
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }
        
        // Main logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) { 
                int maxValWithoutCurr = mat[item - 1][capacity];   // max value from previous row-without current items price
                int maxValWithCurr = 0;                             // We initialize this value to 0
                
                int weightOfCurr = wt[item - 1];                    //  item -1 to for the extra row at the top
                if (capacity >= weightOfCurr) {                     // check if the knapsack can fit the current item
                    maxValWithCurr = val[item - 1];                 // If so, maxValWithCurr is at least the value of the current item
                    
                    int remainingCapacity = capacity - weightOfCurr;    // remainingCapacity must be at least 0
                    maxValWithCurr += mat[item - 1][remainingCapacity]; //  maximum value that can be obtained with a remaining capacity  by looking at the row above, at column remaining capacity.
                }
                
                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
            }
        }
        
        System.out.println("Maximum profit "+mat[n][w]); // Final answer
       
        for (int i = 0; i < mat.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < mat[i].length; j++) { //this equals to the column in each row.
               System.out.print(mat[i][j] + "  ");
              
            }
            System.out.println();
        }
       
        System.out.println(); 
        //BackTracking
        while (n != 0) {
    		if (mat[n][w] != mat[n - 1][w]) {
    			System.out.println(" Item " + n + " with W = " + wt[n - 1] + " and Value = " + val[n - 1]);
    			
    			w = w- wt[n-1];
    		}
    		n--;
    	}
    }
}