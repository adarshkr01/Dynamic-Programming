package Knapsack;

public class EqualSumPartition {
	
	public static boolean equalSumPartition(int arr[]) {
		int range = 0;
		for(int i = 0; i < arr.length; i++) 
			range += arr[i];
		
		// Return if a subset exits whose sum = Range/2
		if(range %2 != 0)
			return false; // If range is odd, it cannot be divided into two parts
		
		return subsetSum(arr, range/2);
	}
	
	public static boolean subsetSum(int arr[], int sum) {
		int N = arr.length;
		boolean t[][] = new boolean[N+1][sum+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= sum; j++) {
				if(i == 0 && j == 0)
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
		return t[N][sum];
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 11, 5};
		
		System.out.println(equalSumPartition(arr));

	}

}
