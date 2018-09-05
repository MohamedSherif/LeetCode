package impl;

public class FindTheDuplicateNumber {

	public static int findDuplicate2(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i] == nums[j])
					return nums[i];
			}
		}
		
		return 0;
	}
	
	
	
	public static int findDuplicate(int[] nums) {
		
		int low = 1;
		int high = nums.length-1;
		int mid = 0;
		
		while(low < high){
			mid = low + (high-low)/2;
			
			int count = 0;
			
			for(int i : nums){
				if(i <= mid){
					count++;
				}
			}
			
			if(count > mid){
				high = mid;
			}else{
				low = mid+1;
			}
					
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,4,3,6,5};
	
		System.out.println(findDuplicate(nums));
		
//		System.out.println(findDuplicate2(nums));
	}

	
}
