package PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		
		System.out.println(pq);
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		
	}
}
