package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamDemo {

	public static void main(String[] args) {
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);

		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);

		Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);

		// find frequency of each element in an array or a list?
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Note Book");
		Map<String, Long> stationeryCountMap = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(stationeryCountMap);

		// sort the given list of decimals in reverse order?
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);

		int max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Maximum Element : " + max);

		int min = listOfIntegers.stream().min(Integer::compare).get();
		System.out.println("Minimum Element : " + min);

		// merge two unsorted arrays into single sorted array
		int[] a = new int[] { 4, 2, 7, 1 };
		int[] b = new int[] { 8, 3, 9, 5 };
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(c));

		listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		listOfIntegers.stream().sorted().limit(3).findFirst();
		Integer secondLargestNumber = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();

		// anagrams
		String s1 = "RaceCar";
		String s2 = "CarRace";
		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		if (s1.equals(s2)) {
			System.out.println("Two strings are anagrams");
		} else {
			System.out.println("Two strings are not anagrams");
		}

//		longest string in a list of strings
		List<String> fruites = List.of("apple", "banana", "cherry", "watermelon");
		Optional<String> longest = fruites.stream().max(Comparator.comparingInt(String::length));
		longest.ifPresent(System.out::println);

		Optional<String> longest1 = fruites.stream().reduce((f1, f2) -> f1.length() >= f2.length() ? f1 : f2);

		Optional<String> longest2 = fruites.stream().sorted((f1, f2) -> Integer.compare(f2.length(), f1.length()))
				.findFirst();

	}

}
