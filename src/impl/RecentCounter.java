package impl;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
	Queue<Integer> queue;
	
	public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        
        while(queue.peek() < t - 3000) {
        	queue.poll();
        }
        
        return queue.size();
    }
    
    public static void main(String[] args) {
		RecentCounter r = new RecentCounter();
		
		System.out.println(r.ping(1));
		
		System.out.println(r.ping(100));
		
		System.out.println(r.ping(3001));
		
		System.out.println(r.ping(3002));
		
	}
}
