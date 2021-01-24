package impl;

import java.util.Arrays;

public class RemoveElement {

	public static  int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i=0, j=0;
       
        while(j<nums.length){
            if(nums[i] == val && nums[j] == val){
                j++;
            }
            else{
                nums[i++] = nums[j++];
            }
            
        }
        return i;
    }
	
	public static  int removeElement2(int[] nums, int val) {
        int index = 0;
       
        for(int i : nums){
            if( i != val) {
            	nums[index] = i;
            	index++;
            }
        }
        return index;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int res = removeElement2(nums, 2);
		System.out.println(res);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
