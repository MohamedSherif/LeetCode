package impl;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
			if((i%3 == 0) && (i%5 == 0)){
				list.add("FizzBuzz");
			}else if(i%3 == 0){
				list.add("Fizz");
			}else if(i%5 == 0){
				list.add("Buzz");
			}else{
				list.add(""+i);
			}
		}
        
		return list;
    }
	
	public static void main(String[] args) {
		ArrayList<String> list = (ArrayList<String>) fizzBuzz(100);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
