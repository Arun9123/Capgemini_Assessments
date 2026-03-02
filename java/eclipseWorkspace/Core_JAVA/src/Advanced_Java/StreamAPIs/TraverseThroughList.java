package Advanced_Java.StreamAPIs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TraverseThroughList {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1, 2, 3);
		
		for (int i=0; i<l.size(); i++) {
			System.out.print(l.get(i));
		}
		System.out.println();
		
		for (int a: l) {
			System.out.print(a);
		}
		System.out.println();
		
		Consumer<Integer> c = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.print(t);
			}
			
		};
		l.forEach(c);
		System.out.println();
		
		l.forEach(n -> System.out.print(n));
		System.out.println();
		
		l.forEach(System.out::print);
	}
}
