package impl;

public class RotateArray {

	/**
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4].
	 * 
	 * Note: Try to come up as many solutions as you can, there are at least 3
	 * different ways to solve this problem.
	 * 
	 * Could you do it in-place with O(1) extra space?
	 * 
	 * @param nums
	 * @param k
	 */
	public static void rotate(int[] nums, int k) {
		int n = nums.length;

		int[] newNums = new int[n];

		for (int i = 0; i < nums.length; i++) {
			newNums[(i + k) % n] = nums[i];
		}

		for (int i = 0; i < newNums.length; i++) {
			if (i == 0) {
				System.out.print("[" + newNums[i] + ",");
			} else if (i == newNums.length - 1) {
				System.out.print(newNums[i] + "]");
			} else {
				System.out.print(newNums[i] + ",");
			}
		}
		System.arraycopy(newNums, 0, nums, 0, n);
	}

	/**
	 * Can we do this in O(1) space and in O(n) time? The following solution
	 * does.
	 * 
	 * Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
	 * 
	 * 1. Divide the array two parts: 1,2,3,4 and 5, 6 
	 * 2. Reverse first part: 4,3,2,1,5,6 
	 * 3. Reverse second part: 4,3,2,1,6,5 
	 * 4. Reverse the whole array: 5,6,1,2,3,4
	 * 
	 * @param arr
	 * @param order
	 */
	public static void rotate2(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (order > arr.length) {
			order = order % arr.length;
		}

		// length of first part
		int a = arr.length - order;

		reverse(arr, 0, a - 1);
		reverse(arr, a, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int[] nums = { 1, 2};
		rotate(nums, 1);
		
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				System.out.print("[" + nums[i] + ",");
			} else if (i == nums.length - 1) {
				System.out.print(nums[i] + "]");
			} else {
				System.out.print(nums[i] + ",");
			}
		}
	}
}
