package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * 
 * @author Mohamed Sherif
 *
 */
public class MaximumGap {

	/**
	 * 17 / 17 test cases passed. 
	 * Status: Accepted 
	 * Runtime: 19 ms
	 * @param nums
	 * @return
	 */
	public int maximumGap1(int[] nums) {
		int n = nums.length;

		if (n <= 1)
			return 0;

		Arrays.sort(nums);

		ArrayList<Integer> gaps = new ArrayList<Integer>();

		for (int i = n - 1; i > 0; i--) {
			gaps.add(nums[i] - nums[i - 1]);
		}

		Collections.sort(gaps);

		return gaps.get(gaps.size() - 1);
	}

	/**
	 * 17 / 17 test cases passed. 
	 * Status: Accepted 
	 * Runtime: 3 ms
	 * 
	 * @param nums
	 * @return
	 */
	public int maximumGap(int[] nums) {
		int n = nums.length;

		if (n <= 1)
			return 0;

		Arrays.sort(nums);

		int maxGap = 0;
		for (int i = n - 1; i > 0; i--) {
			if (maxGap < (nums[i] - nums[i - 1])) {
				maxGap = nums[i] - nums[i - 1];
			}
		}
		return maxGap;
	}

}
