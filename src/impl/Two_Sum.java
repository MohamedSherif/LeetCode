package impl;

import java.util.HashMap;

public class Two_Sum {
	//	O(n^2)
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if((nums[i] + nums[j]) == target){
					result[0] = i;
					result[1] = j;
				}
			}
		}
		
		return result;
    }
	
	/**
	 * O(n). Using the Hashmap
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSumOptimized(int[] nums, int target) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(m.containsKey(target - nums[i])&& m.get(target-nums[i])!=i){
				return new int[]{i, m.get(target - nums[i])};
			}
		}
		return new int[]{0};
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 100, 500};
				
		int target = 4; 
		int[] res = twoSumOptimized(nums, target);
		
		System.out.println("[" + res[0] + ", " + res[1] + "]");
	}
}
