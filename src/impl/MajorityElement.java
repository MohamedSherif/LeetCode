package impl;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than n/2 times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * 
 * @author mohsherif
 *
 */
public class MajorityElement {
	public static int majorityElement(int[] nums) {

		HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(numsMap.containsKey(nums[i])){
				numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
			}else{
				numsMap.put(nums[i], 1);
			}
		}

		for(int i : numsMap.keySet()){
			if(numsMap.get(i) > (nums.length/2)){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		
		System.out.println(majorityElement(nums));
	}
}
