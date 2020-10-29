package Knapsack;

public class CountOfSubsetSum {
	public static int countOfSubsetSum(int arr[], int sum) {
		int N = arr.length;
		int t[][] = new int[N+1][sum+1];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= sum; j++) {
				if(i == 0 && j == 0)
					t[i][j] = 1;
				else if(i == 0)
					t[i][j] = 0;
				else {
					if(arr[i-1] <= j)
						t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
					else
						t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[N][sum];
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 8, 10};
		int sum = 10;
		
		System.out.println(countOfSubsetSum(arr, sum));

	}

}
