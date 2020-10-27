package Knapsack;

public class Knapsack01 {
	/* Pure Recursion */
	public static int knapsack(int wt[], int val[], int W, int n) {
		if(W == 0 || n == 0)
			return 0;
		
		if(wt[n-1] <= W)
			return Math.max(val[n-1] + knapsack(wt, val, W-wt[n-1], n-1), knapsack(wt, val, W, n-1));
		
		else 
			return knapsack(wt, val, W, n-1);
	}

	/* Top Down / Memoization */
//	public static int topDown(int wt[], int val[], int W, int n) {
//		return 0;
//	}
	
	/* Bottom Up */
	public static int bottomUp(int wt[], int val[], int W, int n) {
		int t[][] = new int[n+1][W+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < W+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}
				
				else if(wt[i-1] <= j)
					t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[n][W];
	}
	
	public static void main(String[] args) {
		int value[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		int W = 50;
		System.out.println(knapsack(weight, value, W, value.length));
		
//		System.out.println(topDown(weight, value, W, value.length));
		
		System.out.println(bottomUp(weight, value, W, value.length));
	}

}
