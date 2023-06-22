package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.testng.annotations.Test;

public class StreamFilters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		streamCollect();
		streamFilter();
		streamMap();
				
	}

	@Test
	public static void streamFilter() {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		names.add("Dass");
		names.add("Bhagavan");
		//	 	int count = 0;
		// 		for(int i=0; i<names.size(); i++) {
		// 		String name = names.get(i);
		// 	if(name.startsWith("A")) {
		// 		count++;
		// 		}
		// 	}
		// 		System.out.println(count);

		Long count1 = names.stream().filter(s -> s.startsWith("A")).count();
			System.out.println(count1);

		Long count2 = Stream.of("Abhijeet", "Don", "Alekshya", "Adam", "Ram", "Bhagavan").filter(s -> {
			return s.startsWith("A");
		}).count();
			System.out.println(count2);
		// print all the names of ArrayList
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	@Test
	public static void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		names.add("Dass");
		names.add("Bhagavan");
		// print names which have last letter as "a" with uppercase
		Stream.of("Abhijeet", "Don", "Alekshya", "Adam", "Ram", "Bhagavan").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// print names which have first letter as a with uppercasse and sorted
		String[] arr = { "Abhijeet", "Don", "Alekshya", "Adam", "Ram", "Bhagavan" };
		List<String> namesList = Arrays.asList(arr);
		namesList.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s)); // Stream<String> newStream = Stream.of(namesList).filter(s -> s.);
		// merge lists into one list output
		Stream<String> newStream = Stream.concat(names.stream(), namesList.stream());
			// newStream.sorted().forEach(s -> System.out.println(s));
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}

	@Test
	public static void streamCollect() {
		List<String> list = Stream.of("Abhijeet", "Don", "Alekshya", "Adam", "Ram", "Bhagavan")
				.filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		String firstName = list.get(0);
			System.out.println("The first name on list is: "+firstName);
			
		int[] nums = {3,2,4,7,5,1,9,0};
 		List<Integer> numberList = Arrays.stream(nums).boxed().collect(Collectors.toList());
 		numberList.stream().distinct().forEach(s -> System.out.println(s));
 		List<Integer> sortedList = numberList.stream().distinct().sorted().collect(Collectors.toList());
 			System.out.println("The sorted value is: "+sortedList.get(0));
	}

}
