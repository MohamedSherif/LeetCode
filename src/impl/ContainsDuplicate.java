package impl;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * 
 * @author Mohamed Sherif
 *
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		boolean containsDuplicate = false;

		HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		int occurs = 0;
		for (int i = 0; i < nums.length; i++) {
			if (numsMap.containsKey(nums[i])) {
				occurs = numsMap.get(nums[i]);

				numsMap.put(nums[i], occurs + 1);
			} else {
				numsMap.put(nums[i], 1);
			}
		}

		for (int key : numsMap.keySet()) {
			if (numsMap.get(key) > 1) {
				containsDuplicate = true;
			}
		}

		return containsDuplicate;
	}

	public boolean containsDuplicate2(int[] nums) {

		HashSet<Integer> map = new HashSet<Integer>();

		for (int i : nums) {
			if (!map.add(i)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicate3(int[] nums) {

		int xor = 0;

		for (int i : nums) {
			xor = xor & i;
		}

		if (xor == 0)
			return true;

		return false;
	}

	public static int searchWithXOR(int[] array) {
		int dup = 0;
		int offset = 1;
		for (int i = 0; i < array.length; i++) {
			dup = dup ^ (array[i] + offset) ^ i;
		}
		return dup - offset;
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// find iterative
		System.out.println("duplicate = " + searchWithXOR(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 4, 9 }));

	}

}
