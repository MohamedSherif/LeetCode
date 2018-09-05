package impl;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 
 * 2 -> B 
 * 3 -> C 
 * ... 
 * 26 -> Z 
 * 27 -> AA 
 * 28 -> AB
 * 
 * @author Mohamed Sherif
 *
 */
public class ExcelColumnTitle {

	public static String numberToTitle(int a) {
		String result = "";

		char[] alphabet = new char[26];

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			alphabet[ch - 'A'] = ch;
		}

		if (a < 26) {
			result += alphabet[a - 1];
			return result;
		}

		while (a > 0) {
			int index = a;
			if (a % 26 == 0) {
				index = 26;
				a = a - 26;
			} else {
				index = a % 26;
			}
			result = alphabet[index - 1] + result;

			a = a / 26;
		}

		return result;
	}

	/*
	 * Another Solution
	 */
	public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
	
}
