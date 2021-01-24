package impl;

/**
 * 
 * @author MSherif
 *
 */
public class HouseRobber {
	
	static int[] cache;
	
	/**
	 * Method1() - Recursive Solution 
	 * 
	 * Time Complexity is O(2^n)
	 * 
	 * @param A
	 * @param i
	 */
	public static int robM1(int[] A, int i) {
		if(A == null || A.length == 0) 
			return 0;
		
		if(A.length == 1)
			return A[0];
		
		if(i < 0)
			return 0;
		
		int ith_house_is_selected = robM1(A, i-2) + A[i];
		int ith_house_is_not_selected = robM1(A, i-1);
		
		return Math.max(ith_house_is_selected, ith_house_is_not_selected); 
	}
	
	
	/**
	 * Method2() Approach1 - Top Down Approach (Cache is declared global level) 
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param A
	 * @param i
	 */
	public static int robM2A1(int[] A, int i) {
		if(A == null || A.length == 0) 
			return 0;
		
		if(A.length == 1)
			return A[0];
		
		if(i < 0)
			return 0;
		
		if(cache[i] != 0)
			return cache[i];
		
		int ith_house_is_selected = robM2A1(A, i-2) + A[i];
		int ith_house_is_not_selected = robM2A1(A, i-1);
		
		return cache[i] = Math.max(ith_house_is_selected, ith_house_is_not_selected); 
	}
	
	/**
	 * Method2() Approach2 - Top Down Approach (Cache is passed as a method argument) 
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param A
	 * @param i
	 */
	public static int robM2A2(int[] A, int i, int[] cache) {
		if(A == null || A.length == 0) 
			return 0;
		
		if(A.length == 1)
			return A[0];
		
		if(i < 0)
			return 0;
		
		if(cache[i] != 0)
			return cache[i];
		
		int ith_house_is_selected = robM2A2(A, i-2, cache) + A[i];
		int ith_house_is_not_selected = robM2A2(A, i-1, cache);
		
		return cache[i] = Math.max(ith_house_is_selected, ith_house_is_not_selected); 
	}
	
	/**
	 * Method3() - Bottom Up Approach 
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * There is no recursion overhead.
	 * 
	 * @param A
	 * @param i
	 */
	public static int robM3(int[] A) {
		if(A == null || A.length == 0) 
			return 0;
		
		if(A.length == 1)
			return A[0];
		
		int[] cache = new int[A.length + 1];
		//	Base Case
		cache[0] = A[0];
		cache[1] = Math.max(A[0], A[1]);
		
		for(int i = 2; i < A.length; i++) {
			cache[i] = Math.max(cache[i-2] + A[i], cache[i-1]);
		}
		
		return cache[A.length - 1]; 
	}
	
	
	/**
	 * Method4() *** The Most Efficient Solution *** 
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param A
	 * @param i
	 */
	public static int robM4(int[] A) {
		if(A == null || A.length == 0) 
			return 0;
		
		if(A.length == 1)
			return A[0];
		
		//	Base Case
		int prev2 = A[0];
		int prev1 = Math.max(A[0], A[1]);
		
		for(int i = 2; i < A.length; i++) {
			int temp = prev1;
			
			prev1 = Math.max(prev2 + A[i], prev1);
			prev2 = temp;
		}
		
		return prev1; 
	}
	
	
	private static int[] memo;
	
	private static int robber2(int[] nums) {
		int n = nums.length;
		
		if(n == 0) 
			return 0;
		
		if(n == 1)
			return nums[0];
		
		memo[n-1] = nums[n-1];
        memo[n-2] = nums[n-2];
        
        if(n>=3)
            memo[n-3] = nums[n-3] + nums[n-1];
        
        for(int i=n-4; i>=0; i--)
            memo[i] = nums[i] + Math.max(memo[i+2], memo[i+3]);
        
        return Math.max(memo[0], memo[1]);
		
	}
	
	/**
	 * Iterative DP solution - Bottom up approach.
	 * 
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 * 
	 * Submitted and accepted.
	 * 
	 * @param nums
	 * @return
	 */
	private static int robber(int[] nums) {
		int[] memo = new int[nums.length];
		
		int n = nums.length;
		
		if(n == 0) 
			return 0;
		
		if(n == 1)
			return nums[0];
		
		memo[0] = nums[0];
        memo[1] = nums[1];
        
        if(n>=3)
            memo[2] = nums[2] + nums[0];
        
        for(int i=3; i < n; i++)
            memo[i] = nums[i] + Math.max(memo[i-2], memo[i-3]);
        
        return Math.max(memo[n-1], memo[n-2]);
		
	}
	
	static int rob(int[] nums) {
		memo = new int[nums.length];
		
		return robber(nums);
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		
		System.out.println(robM4(nums));
	}
}
