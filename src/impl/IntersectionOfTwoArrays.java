package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order
 * 
 * @author Mohamed Sherif.
 *
 */
public class IntersectionOfTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> nums1Map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> nums2Map = new HashMap<Integer, Integer>();
		
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		
		for (int i = 0; i < nums1.length; i++) {
			nums1Map.put(nums1[i], i);
		}
		for (int i = 0; i < nums2.length; i++) {
			nums2Map.put(nums2[i], i);
		}

		for (Integer key : nums1Map.keySet()) {
			if(nums2Map.containsKey(key)){
				intersect.add(key);
			}
		}
		
		int[] res = new int[intersect.size()];
		
		for (int i = 0; i < res.length; i++) {
			res[i] = intersect.get(i).intValue();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1}	;
		
		int[] res = intersection(nums1, nums2);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
}
