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
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
				nums[current] = nums[i];
				current ++;
			}
		}
		
		while(current < nums.length){
			nums[current] = 0;
			current ++;
		}
		
		return nums;
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
