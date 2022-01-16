package impl;

import java.util.HashMap;

public class DayOfTheWeek {
	
	public static String solution(String day, int k) {
		if(day == null || day.trim().length() == 0)
			return null;
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		HashMap<String, Integer> daysMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < days.length; i++) {
			daysMap.put(days[i], i);
		}
		
		return days[(daysMap.get(day) + k) % 7];
		
	}
	
	public static void main(String[] args) {
		System.out.println(solution("Monday", 7));
	}
}
