package microsoft;

public class ReverseWords {

	public static char[] reverseWords(char[] str) {
		int startIndex = 0;

		int n = str.length;

		reverseString(str, 0, n - 1);
		
//		System.out.println(String.valueOf(str));
		
		for (int i = 0; i < n; i++) {
			if (str[i] == ' ' || i == n - 1) {
				reverseString(str, startIndex, i - 1);
				startIndex = i + 1;
			}
		}
		
		return str;
	}

	private static void reverseString(char[] str, int startIndex, int endIndex) {
		int i = startIndex;
		int j = endIndex;

		while (i < j) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;

			i++;
			j--;
		}
	}

	
	public static String reverseWords(String str) {
		String[] words = str.split(" ");
		
		int count = words.length;
		
		String ans = "";
		
		for(int i = count - 1; i >= 0; i--) {
			ans += words[i] + " ";
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		String str = "I like this program very much";

		char[] chars = reverseWords(str.toCharArray());

		System.out.println(String.valueOf(chars));
		
		System.out.println(reverseWords(str));

	}

}
