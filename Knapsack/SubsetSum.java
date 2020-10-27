package Knapsack;

public class SubsetSum {

	public static boolean subsetSum(int arr[], int sum) {
		int N = arr.length;
		boolean t[][] = new boolean[N+1][sum+1];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= sum; j++) {
				if(i == 0 && j== 0)
					t[i][j] = true;
				else if(i == 0)
					t[i][j] = false;
				else if(j == 0)
					t[i][j] = true;
				else {
					if(arr[i-1] <= j)
						t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
					else
						t[i][j] = t[i-1][j];
				}
			}
		}
// The array formed		
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= sum; j++) {
//				System.out.print(t[i][j] + " ");
//			} System.out.println();
//		}
		return t[N][sum];
		
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 8, 10};
		int sum = 11;
		
		System.out.println(subsetSum(arr, sum));
	}

}
