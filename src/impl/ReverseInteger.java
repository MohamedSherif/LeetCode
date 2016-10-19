package impl;

public class ReverseInteger {
	
	public static  int reverse(int x) {
		
		int sign = (x<0)?-1:1;
		x = Math.abs(x);
		
		long r = 0;
		
		while(x>0){
			r= r*10 + x%10;
			
			if (r>Integer.MAX_VALUE)
	    	    return 0;
			
			x=x/10;
		}
		
		return (int)r*sign;
	}
	
	public static void main(String[] args) {
		int res = reverse(-6531);
		System.out.println(res);
	}
	
}
