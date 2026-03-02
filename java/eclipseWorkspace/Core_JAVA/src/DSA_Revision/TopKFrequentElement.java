package DSA_Revision;

import java.util.*;

public class TopKFrequentElement {
	private static List<Integer> topK (int arr[], int k){
		HashMap<Integer, Integer> freq = new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> freq.get(o1) - freq.get(o2));
		for (int i = 0; i < arr.length; i++) {
			freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
			
			Set<Integer> keySet = freq.keySet();
			for (Integer  key: keySet) {
				queue.add(key);
				if (queue.size()>k) {
					queue.poll();				
				}
			}
		}
		return new ArrayList<>(queue);
	}
	public static void main(String[] args) {
		int arr[]= {1,2,2,1,3};
		int k=2;
		System.out.println(topK(arr, k));
	}
}
