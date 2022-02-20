package microsoft;

import java.util.Arrays;

public class LargestNumWithNegPair {
	private static int getLargestNumWithNegPair(int[] A) {
		Arrays.sort(A);
		
		int i = 0, j = A.length - 1;
		
		while(i < j) {
			if(Math.abs(A[i]) == Math.abs(A[j])) {
				return Math.abs(A[i]);
			} else if(Math.abs(A[i]) < Math.abs(A[j])){
				j--;
			} else {
				i++;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(getLargestNumWithNegPair(new int[] {3, 2, -2, 5, -3}));
	}
}
