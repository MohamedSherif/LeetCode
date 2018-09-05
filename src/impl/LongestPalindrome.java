package impl;

public class LongestPalindrome {

	// private static int longestPalindrome(String s) {
	// // TODO Auto-generated method stub
	//
	// int len = s.length();
	// if(len == 0) return 0;
	// int[] chs = new int[256];
	// for(int i = 0; i < len; i++){
	// char c = s.charAt(i);
	// chs[c]++;
	// }
	//
	// int res = 0;
	// for(int i = 0; i < 256; i++){
	// if(chs[i] != 0){
	// //always add even value
	// if(chs[i] % 2 == 0){
	// res += chs[i];
	// }else{
	// res += (chs[i]-1);
	// }
	// }
	// }
	// // if the entire string is even length palindrome
	// if(res == len) return res;
	// else return res+1;
	// }

//	public static int longestPalindrome(String s) {
//		if (s == null || s.length() == 0) {
//			return 0;
//		}
//		int[] count = new int[256];
//		int sum = 0, odd = 0;
//		for (int i = 0; i < s.length(); i++) {
//			sum++;
//			if (count[s.charAt(i)] % 2 == 1) {
//				odd--;
//			} else {
//				odd++;
//			}
//			count[s.charAt(i)]++;
//		}
//		return sum - Math.max(0, odd - 1);
//	}
	
	public static int longestPalindrome(String s) {
	    int length = 0;
	    int[] charset = new int[58];
	    for (int i = 0; i < s.length(); i++) {
			charset[s.charAt(i) - 'A']++;
		}
	    int hasOdd = 0;
	    
	    for (int i = 0; i < charset.length; i++) {
			if(charset[i] % 2 == 0)
				length += charset[i];
			else{
				length += charset[i] - 1;
				
				hasOdd = 1;
			}
		}
	    return length + hasOdd;
	}


	public static void main(String[] args) {
//		System.out.println(longestPalindrome("abcccccdd"));
		
		System.out.println(longestPalindrome("xacbbbcax"));
	}
}
