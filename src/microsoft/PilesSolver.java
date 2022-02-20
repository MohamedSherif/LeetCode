package microsoft;

import java.util.Arrays;
import java.util.Collections;

public class PilesSolver {
	
	private static int minStepsToMakePilesEqualHeight(Integer[] piles) {
		if(piles == null || piles.length == 0) return 0;
		
		Arrays.sort(piles, Collections.reverseOrder());
		
		int noOfSteps = 0;
		
		for(int i = 0; i < piles.length - 1; i++) {
			if(piles[i] != piles[i+1]) {
				noOfSteps += i + 1;
			}
		}
		
		return noOfSteps;
	}
	
	public static void main(String[] args) {
		System.out.println(minStepsToMakePilesEqualHeight(new Integer[] {1,2,5}));
	}
}
