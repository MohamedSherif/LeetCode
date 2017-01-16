package impl;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1: 
 * 	Input: [1,1,0,1,1,1] 
 * 	Output: 3 
 * 	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3. 
 * 
 * 	Note: 
 * 		The input array will only contain 0 and 1. The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 * @author Mohamed Sherif.
 *
 */
public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxConsecutiveOnes = 0;
		int numOfOnes = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (maxConsecutiveOnes < numOfOnes) {
					maxConsecutiveOnes = numOfOnes;
				}
				numOfOnes = 0;
			} else {
				numOfOnes++;
				if (i == nums.length - 1) {
					if (maxConsecutiveOnes < numOfOnes) {
						maxConsecutiveOnes = numOfOnes;
					}
				}
			}
		}
		return maxConsecutiveOnes;
	}

	public static int findMaxConsecutiveOnes2(int[] nums) {
		int max = 0;
		int currentMax = 0;

		for (int n : nums) {
			currentMax = (n == 0)? 0 : (currentMax + 1);
			max = Math.max(max,  currentMax);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 0 };
		System.out.println(findMaxConsecutiveOnes2(nums));
	}
}
