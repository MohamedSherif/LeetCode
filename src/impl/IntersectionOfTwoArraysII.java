package impl;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: 
 * - Each element in the result should appear as many times as it shows in both arrays. 
 * - The result can be in any order.
 * 
 * @author Mohamed Sherif.
 *
 */
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		
		while(i<nums1.length&&j<nums2.length){
			if (nums1[i] < nums2[j]) {
				i++;
			}else{
				if(nums1[i] > nums2[j]){
					j++;
				}else{
					res.add(nums1[i]);
					i++;
					j++;
				}
			}
		}
		int[] arr = new int[res.size()];
		for (int k = 0; k < res.size(); k++) {
			arr[k] = res.get(k);
		}
		
		return arr;
	}
}
