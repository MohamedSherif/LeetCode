package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

public class Solutions {
	/**
	 * Definition for singly-linked list.
	 */
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while(fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if(fastPointer == slowPointer) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This function returns true if all characters in 
	 * str[i..j] are distinct, otherwise returns false
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */ 
	public static Boolean areDistinct(String str, int i, int j) { 
	    // Note : Default values in visited are false 
	    boolean[] visited = new boolean[26]; 
	  
	    for(int k = i; k <= j; k++) 
	    { 
	        if (visited[str.charAt(k) - 'a'] == true) 
	            return false;
	              
	        visited[str.charAt(k) - 'a'] = true; 
	    } 
	    return true; 
	} 
	
	/**
	 * Method 1 (Simple : O(n3)) We can consider all
	 * substrings one by one and check for each substring whether it contains all
	 * unique characters or not. There will be n*(n+1)/2 substrings. Whether a
	 * substring contains all unique characters or not can be checked in linear time
	 * by scanning it from left to right and keeping a map of visited characters.
	 * Time complexity of this solution would be O(n^3). Returns length of the
	 * longest substring with all distinct characters
	 * 
	 * @param str
	 * @return
	 */
	public static int lengthOfLongestSubstring(String str) {
		int n = str.length(); 
	     
	    int res = 0;  
	      
	    for(int i = 0; i < n; i++) {
	    	for(int j = i; j < n; j++) {
	    		if (areDistinct(str, i, j)) {
	    			res = Math.max(res, j - i + 1);
	    		}
	    	}
	    }
	                  
	    return res; 
	}
	
	/**
	 * Method 2 (Better : O(n2)) The idea is to use window sliding. Whenever we see
	 * repetition, we remove the previous occurrance and slide the window.
	 * 
	 * @param str
	 * @return
	 */
	public static int longestUniqueSubstring(String str) 
	{ 
	    int n = str.length(); 
	      
	    // Result 
	    int res = 0; 

        // Note : Default values in visited are false 
        boolean[] visited = new boolean[256]; 
        
	    for(int i = 0; i < n; i++) 
	    { 
	        for(int j = i; j < n; j++) 
	        { 
	            // If current character is visited Break the loop 
	            if (visited[str.charAt(j)] == true) {
	            	break;
	            } else {
	            	// Else update the result if this window is larger, and mark current character as visited.
	                res = Math.max(res, j - i + 1); 
	                visited[str.charAt(j)] = true; 
	            } 
	        } 
	  
	        // Remove the first character of previous window 
	        visited[str.charAt(i)] = false; 
	    } 
	    return res; 
	} 
	
	static final int NO_OF_CHARS = 256; 
	
	/**
	 * Method 3 (Linear Time): Let us talk about the linear time solution now. This
	 * solution uses extra space to store the last indexes of already visited
	 * characters. The idea is to scan the string from left to right, keep track of
	 * the maximum length Non-Repeating Character Substring seen so far in res. When
	 * we traverse the string, to know the length of current window we need two
	 * indexes. 1) Ending index ( j ) : We consider current index as ending index.
	 * 2) Starting index ( i ) : It is same as previous window if current character
	 * was not present in the previous window. To check if the current character was
	 * present in the previous window or not, we store last index of every character
	 * in an array lasIndex[]. If lastIndex[str[j]] + 1 is more than previous start,
	 * then we updated the start index i. Else we keep same i.
	 * 
	 * @param str
	 * @return
	 */
    static int longestUniqueSubsttr(String str) { 
        int n = str.length(); 
  
        int res = 0; // result 
  
        // last index of all characters is initialized as -1 
        int [] lastIndex = new int[NO_OF_CHARS]; 
        Arrays.fill(lastIndex, -1); 
  
        // Initialize start of current window 
        int i = 0; 
  
        // Move end of current window 
        for (int j = 0; j < n; j++) { 
  
            // - Find the last index of str[j] 
            // - Update i (starting index of current window) as maximum of current value of i and last index plus 1 
            i = Math.max(i, lastIndex[str.charAt(j)] + 1); 
  
            // Update result if we get a larger window
            int windowSize = j - i + 1;
            res = Math.max(res, windowSize); 
  
            // Update last index of j. 
            lastIndex[str.charAt(j)] = j; 
        } 
        return res; 
    } 
    
    public static int lengthOfLongestSubstring2(String s) {
    	int maxLength = 0;
    	
    	int start = 0;
    	int i = 0;
    	
    	int[] freq = new int[256];
    	
    	while(i < s.length()) {
    		int iChar = s.charAt(i);
    		freq[iChar] ++;
    		
    		while(freq[iChar] > 1) {
    			int sChar = s.charAt(start);
    			freq[sChar] --;
    			start++;
    		}
    		int currentLen = i - start + 1;
    		maxLength = Math.max(maxLength, currentLen);
    		i++;
    	}
    	return maxLength;
    }
	
    /**
     * 26. Remove Duplicates from Sorted Array
     * Two Pointers Technique. (Equi Directional Apporach)
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
    	int index = 0;
        
        for(int i=1; i < nums.length; i++)
        {
            if(nums[index] != nums[i])
            {
                nums[index + 1] = nums[i];
                index ++;
            }
        }        
        return index+1;
        
    }
    
    
    /**
     * 387. First Unique Character in a String
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i = 0; i < s.length(); i++) {
    		Character current = s.charAt(i);
    		
    		if(!map.containsKey(current)) {
    			map.put(current, i);
    		} else {
    			map.put(current, -1);
    		}
    	}
    	int min = Integer.MAX_VALUE;
    	
    	for(Character c : map.keySet()) {
    		if(map.get(c) != -1 && map.get(c) < min) {
    			min = map.get(c);
    		}
    	}
    	
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public static int firstUniqueChar(String s) {
    	for(int i = 0; i < s.length(); i++) {
    		char current = s.charAt(i);
    		if(s.indexOf(current) == s.lastIndexOf(current)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    /**
     * 	136. Single Number
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
    }
    
    public int singleNumber2(int[] nums) {
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
    
    public static int singleNumber3(int[] nums) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(set.contains(nums[i])) {
    			set.remove(nums[i]);
    		} else {
    			set.add(nums[i]);
    		}
    	}
    	
    	for (Integer i : set) {
			return i;
		}
    	
    	return -1;
    }
    
    /**
     * Robot Return to Origin
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int originX = 0;
        int originY = 0;
        
    	for(int i = 0; i < moves.length(); i++) {
        	char curMove = moves.charAt(i);
        	
        	switch(curMove) {
        		case 'D':
        			originY ++;
        			break;
        		case 'U':
        			originY --;
        			break;
        		case 'R':
        			originX ++;
        			break;
        		case 'L':
        			originX --;
        			break;
        	}
        }
    	return (originX == 0 && originY == 0);
    }
    
    public boolean judgeCircle2(String moves) {
        
        int originX = 0;
        int originY = 0;
        
    	for(int i = 0; i < moves.length(); i++) {
        	char curentMove = moves.charAt(i);
        	
        	if(curentMove == 'D'){
                originY ++;
            }else if (curentMove == 'U'){
        		originY --;
            }else if (curentMove == 'R'){
        		originX ++;
            }else if(curentMove == 'L'){
        		originX --;
        	}
        }
    	return (originX == 0 && originY == 0);
    
    }
    
    
    /**
     * 268. The missing number
     * 
     * O(n log n)  Solution
     * 
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - i != 0)
                return i;
        }
        
        return nums.length;
    }
    
    /**
     * Solution using extra space Hashset.
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for(int i : nums) {
    		set.add(i);
    	}
    	
    	for (int i = 0; i <= nums.length; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
    	
    	return -1;
    }
    
    /**
     * O(n) Solution - Linear runtime. / No extra space used.
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
    	int sum = 0;
    	
    	for (int i : nums) {
			sum += i;
		}
    	
    	int n = nums.length + 1;
    	
    	return (n * (n - 1) / 2) - sum;
    }
    
    /**
     * 122. Best Time to Buy and Sell Stock II
     * 
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
			int currStockMaxProfit = 0;
        	for(int j = i + 1; j < prices.length; j++) {
				int currentProfit = prices[j] - prices[i];
				
				currStockMaxProfit = Math.max(currStockMaxProfit, currentProfit);
			}
        	maxProfit += currStockMaxProfit;
		}
        return maxProfit;
    }
    // The correct answer
    // Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
			if(prices[i+1] > prices[i]) {
				maxProfit += prices[i+1] - prices[i];
			}
		}
        return maxProfit;
    }
    
    
    /**
     * 27. Remove Element
     * 
     * Optimal solution 
     * 
     * Time Complexity - O(n) 
     * 
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
    	int newIndex = 0;
    	for (int i : nums) {
			if( i != val ) {
				nums[newIndex] = i;
				newIndex ++;
			}
		}
    	
    	return newIndex;
    }
    /**
     * Using the sliding window technique
     * 
     * Time Complexity O(n log n) because of the Sorting step.
     * 
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
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
    /**
     * 70. Climbing Stairs
     * 
     * Recursive Solutions.
     * 
     * Time Complexity - O(2 ^ n) Caused Time Limit Exceeded on Leetcode online Judge.
     * 
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n < 0) {
        	return 0;
        } else if(n == 0) {
        	return 1;
        }
    	return climbStairs(n-1) + climbStairs(n - 2); 
    }
    
    /**
     * DP Solution Bottom Up Approach
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * 
     * @param n
     * @return
     */
    public static int climbStairsDP(int n) {
    	int[] dp = new int[n + 1];
    	// Base Cases
    	dp[0] = 1;
    	dp[1] = 1;
    	
    	for(int i = 2; i <= n; i++) {
    		dp[i] = dp[i-1] + dp[i - 2];
    	}
    	
    	return dp[n];
    }
    
    /**
     * Most Effecient Solution
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * 
     * @param n
     * @return
     */
    public static int climbStairsDP2(int n) {
    	int prev1 = 1;
    	int prev2 = 1;
    	
    	if(n < 2) {
    		return n;
    	}
    	int sum = 0;
    	
    	for(int i = 2; i <= n; i++) {
    		sum = prev1 + prev2;
    		
    		prev2 = prev1;
    		prev1 = sum;
    	}
    	
    	return sum;
    }
    
    /**
     * 17. Letter Combinations of a Phone Number
     * 
     * @param digits
     * @return
     */
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
       
        if(digits == null || digits.length() == 0) {
        	return result;
        }
        
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        letterCombinationsRecursive(result, digits, "", 0, mapping);
        
        return result;
    }
    
    public void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mapping) {
    	// Base Case (When to stop)
    	if(index == digits.length()) {
    		result.add(current);
    		return;
    	}
    	//Converting a Digit as a character into Integer.
    	int currentDigit = digits.charAt(index) - '0';
    	
    	String letters = mapping [currentDigit];
    	
    	for (int i = 0; i < letters.length(); i++) {
			letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
		}
    }
    
    /**
     * Function to return a vector that contains all the generated letter combinations
     * 
     * Iteratively using a Queue.
     * 
     * @param digits
     * @param n
     * @param mappingTable
     * @param resultList
     */
    static void letterCombinationsUtil(String digits, int n, String[] mappingTable, List<String> resultList) {
        // To store the generated letter combinations
        Queue<String> q = new LinkedList<String>();
        q.add("");
 
        while (!q.isEmpty()) {
            String s = q.remove();
 
            // If complete word is generated
            // push it in the list
            if (s.length() == n) {
                resultList.add(s);
            } else {
                String mappedLetters = mappingTable[digits.charAt(s.length()) - '0'];
                
                for (int i = 0; i < mappedLetters.length(); i++) {
                    q.add(s + mappedLetters.charAt(i));
                }
            }
        }
    }
 
    static List<String> letterCombinationsIterative(String digits) {
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        List<String> resultList = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return resultList;
        }
        String[] mappingTable
            = { "0",   "1",   "abc",  "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
 
        letterCombinationsUtil(digits, digits.length(), mappingTable, resultList);
 
        return resultList;
    }
    
    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * @param root
     * @param p
     * @param q
     * @return
     */
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        }
        
        return (left == null? right : left);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(p.val < root.val && q.val < root.val) { // Both Nodes are in the left subtree so we will continue searching the left subtree
    		return lowestCommonAncestor(root.left, p, q);
    	} else if(p.val > root.val && q.val > root.val) { // Both Nodes are in the right subtree so we will continue searching the right subtree
    		return lowestCommonAncestor(root.right, p, q);
    	} else {
    		return root; //LCA found.
    	}
    }
 
    /**
     * 771. Jewels and Stones
     * 
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
    	int count = 0;
    	
    	HashMap<Character, Integer> stonesMap = new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < stones.length(); i++) {
			char currentStone = stones.charAt(i);
			stonesMap.put(currentStone, stonesMap.getOrDefault(currentStone, 0) + 1);
		}
    	
    	for (int i = 0; i < jewels.length(); i++) {
			char currentJewel = jewels.charAt(i);
			
			count += stonesMap.getOrDefault(currentJewel, 0);
		}
    	
    	return count;
    }
    
    public static int numJewelsInStones2(String jewels, String stones) {
    	HashSet<Character> jewelsSet = new HashSet<Character>();
    	
    	for (char c : jewels.toCharArray()) {
			jewelsSet.add(c);
		}
    	
    	int jewelsCount = 0;
    	
    	for(char c : stones.toCharArray()) {
    		if(jewelsSet.contains(c)) {
    			jewelsCount ++;
    		}
    	}
    	
    	return jewelsCount;
    }
    
    /**
     * Hacker Rank Problem (Largest Rectangle)
     * @param height
     * @return
     */
    public int largestRectangle(int[] height) {
        int maxArea = 0;
        
        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> indexes = new Stack<Integer>();
        
        for (int i = 0; i < height.length; i++) {
			if(heights.isEmpty() || height[i] > heights.peek()) {
				heights.push(height[i]);
				indexes.push(i);
			} else if(height[i] < heights.peek()) {
				int lastIndex = 0;
				
				while(!heights.isEmpty() && height[i] < heights.peek()) {
					lastIndex = indexes.pop();
					int tempAreaSize = heights.pop() * (i - lastIndex);
					
					if(maxArea < tempAreaSize) {
						maxArea = tempAreaSize;
					}
				}
				
				heights.push(height[i]);
				indexes.push(lastIndex);
			}
		}
        
        while(!heights.isEmpty()) {
        	int tempAreaSize = heights.pop() * (height.length - indexes.pop());
			
			if(maxArea < tempAreaSize) {
				maxArea = tempAreaSize;
			} 
        }
        
        return maxArea;
    }
    /**
     * 11. Container With Most Water
     * 
     * Time Complexity O(n^2)
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
    	int maxArea = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int minHeight = Math.min(height[i], height[j]);
				int tempAreaSize = minHeight * (j - i);
				maxArea = Math.max(maxArea, tempAreaSize);
			}
		}
    	
    	return maxArea;
    }
    
    /**
     * Using the two pointer technique Opposite direction
     * 
     * Time Complexity O(n)
     * 
     * Run time reduced from  650 ms to just 2 ms.
     * 
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
    	int maxArea = Integer.MIN_VALUE;
    	
    	int i = 0;
    	int j = height.length - 1;
    	
    	while(i < j) {
    		int minHeight = Math.min(height[i], height[j]);
    		
    		int tempArea = minHeight * (j - i);
    		
    		maxArea = Math.max(maxArea, tempArea);
    		
    		if(height[i] < height[j]) {
    			i++;
    		} else {
    			j--;
    		}
    	}
    	
    	return maxArea;
    }
    
    /**
     * 733. Flood Fill
     * 
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        
        fillPixels(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void fillPixels(int[][] image, int row, int col, int newColor, int srcColor) {
        if(image[row][col] != srcColor){
            return;
        }
        image[row][col] = newColor;
        
        if(row > 0){
            fillPixels(image, row-1, col, newColor, srcColor);
        }
        
        if(row < image.length - 1){
            fillPixels(image, row+1, col, newColor, srcColor);
        }
        
        if(col > 0){
            fillPixels(image, row, col-1, newColor, srcColor);
        }
        
        if(col < image[row].length - 1){
            fillPixels(image, row, col+1, newColor, srcColor);
        }
    }
    
    /**
     * 206. Reverse Linked List
     * 
     * @param head
     * @return
     */
    /*
    private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}*/
    // Recursive solution
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
			return head;
		
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(head.next);
		
		nextNode.next = head;
		
		head.next = null;
		
		return newHead;
    }
    
    public ListNode reverseList2(ListNode head) {
    	Stack<ListNode> nodeStack = new Stack<ListNode>();
    	while(head != null) {
    		nodeStack.push(head);
    		head = head.next;
    	}
    	
    	ListNode dummyNode = new ListNode(-1);
    	head = dummyNode;
    	
    	while(!nodeStack.isEmpty()) {
    		ListNode currentNode = nodeStack.pop();
    		head.next = new ListNode(currentNode.val);
    		head = head.next;
    	}
		return dummyNode.next;
    }
    
    /**
     * 3 Pointers Solution Iteratively
     * 
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    /**
     * 819. Most Common Word
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<String>();
        
        for (String word : banned) {
			bannedWords.add(word);
		}
        
        paragraph = paragraph.toLowerCase();
        
        paragraph = paragraph.replaceAll(  "[^a-zA-Z0-9]", " ");
        
        String[] paragraphArr = paragraph.split(" ");
        HashMap<String, Integer> occurrence = new HashMap<String, Integer>();
        
        for (String string : paragraphArr) {
			if(!string.equalsIgnoreCase("") && !bannedWords.contains(string)) {
				occurrence.put(string, occurrence.getOrDefault(string, 0) + 1);
			}
		}
        
        int maxOccurrence = Integer.MIN_VALUE;
        String maxOccurred = "";
        
        for (String string : occurrence.keySet()) {
        	int currentOccurrence = occurrence.get(string);
			if( currentOccurrence > maxOccurrence) {
				maxOccurrence = currentOccurrence;
				maxOccurred = string;
			}
		}
        
        return maxOccurred;
    }
    
    public String mostCommonWord2(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<String>();
        
        for (String word : banned) {
			bannedWords.add(word);
		}
        
        HashMap<String, Integer> occurrence = new HashMap<String, Integer>();
        
        for (String word : paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().split(" ")) {
			if(!word.equalsIgnoreCase("") && !bannedWords.contains(word)) {
				occurrence.put(word, occurrence.getOrDefault(word, 0) + 1);
			}
		}
        
        String result = "";
        for (String key : occurrence.keySet()) {
			if( result.equals("") || occurrence.get(key) > occurrence.get(result)) {
				result = key;
			}
		}
        
        return result;
    
    }
    
    /**
     * 929. Unique Email Addresses
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        
        HashSet<String> uniqueEmails = new HashSet<String>();
        
        for (String email : emails) {
			String[] splittedEmail = email.split("@"); 
        	String local = splittedEmail[0];
			String domain = splittedEmail[1];
			
			if(local.contains("+")) {
				local = local.substring(0, local.indexOf("+"));
			}
			
			local = local.replaceAll("\\.", "");
			
			uniqueEmails.add(local + "@" + domain);
		}
        
        return uniqueEmails.size();
    }
    
    
    public static int numUniqueEmails2(String[] emails) {
        
        HashSet<String> uniqueEmails = new HashSet<String>();
        
        for (String email : emails) {
			StringBuilder address = new StringBuilder();
			
			for(int i = 0; i < email.length(); i++) {
				char c = email.charAt(i);
				
				if(c == '.') {
					continue;
				} else if(c == '+'){
					while(email.charAt(i) != '@') {
						i++;
					}
					
					address.append(email.substring(i));
					break;
				} else if(c == '@'){
					address.append(email.substring(i));
					break;
				} else {
					address.append(c);
				}
			}
			uniqueEmails.add(address.toString());
		}
        for (String string : uniqueEmails) {
			System.out.println(string);
		}
        return uniqueEmails.size();
    }
    // Driver code
	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring("pwwkew"));
//		System.out.println(longestUniqueSubstring("pwwkew"));
//		System.out.println(longestUniqueSubsttr("pwwkew"));
//		System.out.println(lengthOfLongestSubstring2("pwwkew"));
		
//		int [] nums = {0,0,1,1,1,2,2,3,3,4};
//		int len = removeDuplicates(nums);
//		System.out.println(len);
//		for(int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + " ");
//		}
//		System.out.println();
		
//		System.out.println(firstUniqueChar("loveleetcode"));
		
		
//		int[] nums = {7,1,5,3,6,1000};
//		
//		System.out.println(maxProfit2(nums));
		
		
//		int[] nums = {3, 2, 2, 3, 1};
//		int newLen = removeElement2(nums, 3);
//		System.out.println(newLen);
//		
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < newLen; i++) {
//			System.out.print(nums[i]+ " ");
//		}
		
//		System.out.println(climbStairsDP2(44));
		
//		String paragraph = "Bob. hIt, baLl";
//		String[] banned = {"bob", "hit"};
//		
//		System.out.println(mostCommonWord(paragraph, banned));
		
		String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
//		String[] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
		System.out.println(numUniqueEmails2(emails));
	}
}
