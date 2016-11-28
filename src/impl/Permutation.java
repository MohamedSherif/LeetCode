package impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: 
 * [ 
 * 	 [1,2,3], 
 *   [1,3,2],
 *   [2,1,3], 
 *   [2,3,1], 
 *   [3,1,2], 
 *   [3,2,1] 
 * ]
 * 
 * @author Mohamed Sherif.
 *
 */
public class Permutation {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> res = permute(nums);

		for (List<Integer> list : res) {
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}

	}
}
