package microsoft;

import java.util.HashSet;
import java.util.Set;

public class JumpGame {

	/**
	 * 1306. Jump Game III ------------------- Given an array of non-negative
	 * integers arr, you are initially positioned at start index of the array. When
	 * you are at index i, you can jump to i + arr[i] or i - arr[i], check if you
	 * can reach to any index with value 0.
	 * 
	 * Notice that you can not jump outside of the array at any time.
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [4,2,3,0,3,1,2], start = 5 Output: true Explanation: All
	 * possible ways to reach at index 3 with value 0 are: index 5 -> index 4 ->
	 * index 1 -> index 3 index 5 -> index 6 -> index 4 -> index 1 -> index 3
	 * 
	 * @param arr
	 * @param start
	 * @return
	 */
	public static boolean canReach(int[] arr, int start) {
		Set<Integer> cache = new HashSet<Integer>();

		return canReach(arr, start, cache);
	}

	private static boolean canReach(int[] arr, int index, Set<Integer> cache) {
		if (arr[index] == 0) {
			return true;
		}

		cache.add(index);

		boolean foundInLeft = false, foundInRight = false;

		if ((index - arr[index]) >= 0 && !cache.contains(index - arr[index])) {
			foundInLeft = canReach(arr, index - arr[index], cache);
		}

		if (index + arr[index] < arr.length && !cache.contains(index + arr[index])) {
			foundInRight = canReach(arr, index + arr[index], cache);
		}

		return foundInLeft || foundInRight;
	}

	/**
	 * 55. Jump Game ------------- You are given an integer array nums. You are
	 * initially positioned at the array's first index, and each element in the
	 * array represents your maximum jump length at that position.
	 * 
	 * Return true if you can reach the last index, or false otherwise.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
	 * to 1, then 3 steps to the last index.
	 * 
	 * <<Correct but got Timeout exception>>
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		HashSet<Integer> cache = new HashSet<Integer>();

		return canJump(nums, 0, cache);
	}

	private static boolean canJump(int[] nums, int index, HashSet<Integer> cache) {
		if (index == (nums.length - 1))
			return true;

		cache.add(index);

		boolean canJump = false;

		for (int i = 1; i <= nums[index]; i++) {
			if (index + i < nums.length && !cache.contains(index + i)) {
				canJump = canJump(nums, index + i, cache);
			}
		}

		return canJump;
	}

	/**
	 * <<Correct and faster than 100%>>
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
		int goal = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= goal) {
				goal = i;
			}
		}
		return goal == 0;
	}

	public static void main(String[] args) {
//		int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
//		System.out.println(canReach(arr, 0));

		int[] nums = { 2, 0 };
		System.out.println(canJump2(nums));
	}
}
