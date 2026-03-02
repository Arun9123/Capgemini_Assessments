package ABC_DSA_training;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
 
public class Reverse_Queue {
 
    static void revQueue(Queue<Integer> q) {
 
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            st.push(q.poll());
        }
 
        // Step 2: Move all elements back to queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }
 
    public static void main(String[] args) {
 
        Queue<Integer> q = new LinkedList<>();
 
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println("Original queue: "+q);
        revQueue(q);
        System.out.println("Modified queue: "+q);
    }
}