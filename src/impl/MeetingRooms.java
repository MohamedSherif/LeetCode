package impl;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval{
	int start;
	int end;
	
	Interval(){
		start = 0;
		end = 0;
	}
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class MeetingRooms {

	/**
	 * 253. Meeting Rooms II
	 * @param intervals
	 * @return
	 */
	public static int minMeetingRooms(Interval[] intervals) {
		
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>((a, b) -> a.end - b.end);
		
		minHeap.add(intervals[0]);
		
		for (int i = 1; i < intervals.length; i++) {
			Interval current = intervals[i];
			Interval earliestMeeting = minHeap.remove();
			
			if(current.start >= earliestMeeting.end) {
				earliestMeeting.end = current.end;
			} else {
				minHeap.add(current);
			}
			minHeap.add(earliestMeeting);
		}
		
		return minHeap.size();
	}
	
	public static void main(String[] args) {
//		Interval m1 = new Interval(0, 30);
//		Interval m2 = new Interval(5, 10);
//		Interval m3 = new Interval(15, 20);
		
//		Interval[] intervals = {m1, m2, m3};
		
		Interval m1 = new Interval(7, 10);
		Interval m2 = new Interval(2, 4);
		
		Interval[] intervals = {m1, m2};
		
		System.out.println(minMeetingRooms(intervals));
	}
}
