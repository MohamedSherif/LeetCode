package impl;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: 
 * 1. You must do this in-place without making a copy of the array. 
 * 2. Minimize the total number of operations.
 * 
 * @author MohamedSherif
 *
 */
public class MoveZeroes {
	public static int[] moveZeroes(int[] nums) {
		int maxNonZeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
				nums[maxNonZeroIndex++] = nums[i];
			}
		}
		
		for(int i = maxNonZeroIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		return nums;
	}
	
	public static int[] moveZeroes2(int[] nums) {
		int maxNonZeroIndex = 0;
		
		for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
			if(nums[currentIndex] != 0){
				swap(nums, currentIndex, maxNonZeroIndex++);
			}
		}
		return nums;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,0,1};
		nums = moveZeroes(nums);
		
		for (int i = 0; i < nums.length; i++) {
			if(i == 0){
				System.out.print("[" + nums[i]);
			}else if(i == (nums.length-1)){
				System.out.print("," + nums[i] + "]");
			}else{
				System.out.print("," + nums[i]);
			}
		}
	}
}
