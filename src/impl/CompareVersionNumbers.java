package impl;

import java.math.BigInteger;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author Mohamed Sherif.
 *
 */
public class CompareVersionNumbers {
	
	public static int compareVersion2(String version1, String version2) {
	    String[] v1List = version1.split("\\."); //"\\." it used instead of "." because it is a Regex;
	    String[] v2List = version2.split("\\.");
	    
	    int length = Math.max(v1List.length, v2List.length);
	    
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < v1List.length ? Integer.parseInt(v1List[i]) : 0;
	    	Integer v2 = i < v2List.length ? Integer.parseInt(v2List[i]) : 0;
	    	
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
	}
	
	public static int compareVersion3(String version1, String version2) {
	    
	    String[] v1 = version1.split("\\.");
	    String[] v2 = version2.split("\\.");
	    
	    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
	    	int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
	    	int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
	        
	    	if(num1 > num2){
	    		return 1;
	    	}else if (num1 < num2){
	    		return -1;
	    	}
	    } 
	    
	    return 0;
	}
	
	
	/**
	 * The Correct answer. 
	 * 
	 * BigInteger Class is used instead of Integer to handle the case of the very large Input Strings.
	 * 
	 * This Test Case not exist on LeetCode, I faced it on InterviewBit.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compareVersion(String a, String b) {
	    String[] v1 = a.split("\\.");
	    String[] v2 = b.split("\\.");
	    
	    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
	        BigInteger num1 = i < v1.length ? new BigInteger(v1[i]) : new BigInteger("0");
	        BigInteger num2 = i < v2.length ? new BigInteger(v2[i]) : new BigInteger("0");
	        
	        int compare = num1.compareTo(num2);
	    	if (compare != 0) {
	    		return compare;
	    	}

	    } 
	    
	    return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(compareVersion("3", "4.12345"));
		System.out.println(compareVersion2("3", "4.12345"));
		System.out.println(compareVersion3("3", "4.12345"));
	}
	
	
	/**
	 * Wrong Answer;
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
//	public static int compareVersion_Wrong(String version1, String version2) {
//		
//        String v1Left = version1.substring(0, version1.indexOf("."));
//        String v2Left = version2.substring(0, version2.indexOf("."));
//        
//        String v1Right = version1.substring(version1.indexOf(".")+1);
//        String v2Right = version2.substring(version2.indexOf(".")+1);
//        
//        while (v1Right.length() != v2Right.length()) {
//        	if(v1Right.length() < v2Right.length()){
//        		v1Right = v1Right + "0";
//        	}
//        	if(v2Right.length() < v2Right.length()){
//        		v2Right = v2Right + "0";
//        	}
//		}
//        
//        int v1b = Integer.parseInt(v1Left);
//        int v2b = Integer.parseInt(v2Left);
//        
//        int v1a = Integer.parseInt(v1Right);
//        int v2a = Integer.parseInt(v2Right);
//        
//        if(v1b > v2b){
//        	return 1;
//        }else if(v2b > v1b){
//        	return -1;
//        }else{
//        	if(v1a > v2a){
//        		return 1;
//        	}else if(v2a > v1a){
//        		return -1;
//        	}else{
//        		return 0;
//        	}
//        }
//    }
	
	
}
