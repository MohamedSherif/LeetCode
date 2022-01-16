package impl;

import java.util.Arrays;
import java.util.Collections;

public class MinStepsToMakePilesEqualHeight {
	
	private static int minSteps(int[] piles) {
		int length = piles.length;
		
		if(length <= 1) return 0;
		
//		Arrays.sort(piles, Collections.reverseOrder());
		
		Arrays.sort(piles);
			
		int result = 0, distinctNums = 0;
		
		for(int i = 1; i<length; i++) {
			if(piles[i] == piles[i-1]) {
				result += distinctNums;
			} else {
				distinctNums++;
				result += distinctNums;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] piles = new int[3];
		piles[0] = 5;
		piles[1] = 2;
		piles[2] = 1;
		
		System.out.println(minSteps(piles));
	}
}
