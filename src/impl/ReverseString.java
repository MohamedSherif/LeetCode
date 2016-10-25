package impl;

public class ReverseString {
	
	public static String reverseString(String s) {
        String reverse = "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
//			reverse += s.charAt(i);
        	sb.append(s.charAt(i));
		}
		return sb.toString();
    }  
	
	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
}
