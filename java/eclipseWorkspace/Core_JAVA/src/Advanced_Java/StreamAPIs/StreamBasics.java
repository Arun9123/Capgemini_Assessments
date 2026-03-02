package Advanced_Java.StreamAPIs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 50, 30, 75, 90);
		list.stream();
		Stream<Integer> s = list.stream();
		s.forEach(System.out::print);
		
		System.out.println();
		
		//Print elements greater than 50
		Stream<Integer> s2 = list.stream().filter(n -> n>50);
		s2.forEach(System.out::print);
		System.out.println();
		
		//
		Stream<Integer> s3 = list.stream().filter(n -> n%2==0).sorted();
		s3.forEach(System.out::print);
		
		System.out.println();
		
		list.stream().filter(n -> n%2==0).sorted().forEach(System.out::print);
		System.out.println()
		;
		System.out.print("Size of the stream is :");
		System.out.println(list.stream().count());
		
		list.stream().map(n -> n+10).forEach(System.out::print);
		
		System.out.println();
		
		Set<Integer> collected = list.stream().collect(Collectors.toSet());
		collected.forEach(System.out::print);
		
	}
}
