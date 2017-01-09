package impl;

/**
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * @author Mohamed Sherif.
 *
 */
public class AddStrings {
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		
		int i1 = num1.length()-1;
		int i2 = num2.length()-1;
		int sumi = 0;
		int carryi = 0;
		
		while(i1>=0 && i2>=0){
			int n1 = (int)num1.charAt(i1) - 48;
			int n2 = (int)num2.charAt(i2) - 48;
			
			sumi = n1 + n2 + carryi;
			
			if (sumi > 10) {
				carryi = sumi/10;
				sumi = sumi%10;
			}else if(sumi == 10){
				sumi = 0;
				carryi = 1;
			}else{
				carryi = 0;
			}
			sb.insert(0, (char) (sumi+48));
			
			i1 --;
			i2 --;
		}
		
		if(i1 >= 0){
			for (int i = i1; i >= 0; i--) {
				int n1 = (int)num1.charAt(i) - 48;
				sumi = n1 + carryi;
				
				if (sumi > 10) {
					carryi = sumi/10;
					sumi = sumi%10;
				}else if(sumi == 10){
					sumi = 0;
					carryi = 1;
				}else{
					carryi = 0;
				}
				sb.insert(0, (char) (sumi+48));
			}
		}
		if(i2 >= 0){
			for (int i = i2; i >= 0; i--) {
				int n2 = (int)num2.charAt(i) - 48;
				sumi = n2 + carryi;
				
				if (sumi > 10) {
					carryi = sumi/10;
					sumi = sumi%10;
				}else if(sumi == 10){
					sumi = 0;
					carryi = 1;
				}else{
					carryi = 0;
				}
				sb.insert(0, (char) (sumi+48));
			}
		}
		
		if(carryi > 0){
			sb.insert(0, (char) (carryi+48));
		}
		return sb.toString();
	}
	
	/**
	 * The Same Solution but it is more clear and readable.
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings2(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		
		int i1 = num1.length()-1;
		int i2 = num2.length()-1;
		int sumi = 0;
		int carryi = 0;
		
		while(i1>=0 || i2>=0){
			int n1 = (i1<0)? 0 : num1.charAt(i1) - '0';
			int n2 = (i2<0)? 0 : num2.charAt(i2) - '0';
			
			sumi = (n1 + n2 + carryi);
			carryi = sumi / 10;
			
			sb.insert(0, sumi%10);
			
			i1 --;
			i2 --;
		}
		
		if(carryi > 0){
			sb.insert(0, carryi);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addStrings2("9", "99"));
	}
}
