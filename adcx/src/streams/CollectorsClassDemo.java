package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsClassDemo {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		
		
		List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
		 String joinedString1 = listOfStrings.stream().collect(Collectors.joining("| "));
        String joinedString = listOfStrings.stream().collect(Collectors.joining("| ", "[", "]"));
        System.out.println(joinedString);
	}

}
