package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FindDisappearedNumbersInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> res = new ArrayList<Integer>();

		for (int i = 1; i <= nums.length; i++) {
			res.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			res.remove((Integer) (nums[i]));
		}

		return res;
	}

	public List<Integer> findDisappearedNumbers2(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }
        
        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;
		
	}
	
	
	public List<Integer> findDisappearedNumbers3(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put((i+1), 0);
		}
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.get(nums[i])+1);
		}
		
		for (int i = 1; i <= nums.length; i++) {
			if(map.get(i) == 0){
				res.add(i);
			}
		}
		return res;
	}
}
