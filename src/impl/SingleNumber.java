package impl;

import java.util.HashMap;

public class SingleNumber {

	/**
	 * O(n) Using Hashmap.
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				map.put(nums[i], (map.get(nums[i])+1));
			}else{
				map.put(nums[i], 1);
			}
		}
        
		for (int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) == 1){
				return nums[i];
			}
		}
        return 0;
    }
	
	/**
	 * O(1) using the ^ Bitwise XOR Operator.
	 * Binary XOR Operator copies the bit if it is set in one operand but not both.	 
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums){
		int result = 0;
        for(int i=0;i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,1,2};
		System.out.println(singleNumber1(nums));
	}
	
}
