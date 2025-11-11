package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class optionalClassDemo {

	public static void main(String[] args) {

		// Creating an Optional object
		Optional<String> emptyOptional = Optional.empty();
		// Null values ko represent karta hai bina actual null value use kiye.
		// Direct null checks se bachne mein madad karta hai.

		Optional<String> name = Optional.of("John Doe");// handles non-null value,if null ->NPE exception throw karta
														// hai

		List<String> list = Arrays.asList("john", "merry");
		Optional<List<String>> name1 = Optional.ofNullable(list);// handles both null & non-null value,if null -> empty
																	// Optional return karta hai.

		System.out.println(emptyOptional);

		// 4.isPresent()
		if (name.isPresent()) {
			System.out.println(name.hashCode());
		}

		// 5. ifPresent(): executes a given action if the value is present.
		name.ifPresent(value -> System.out.println("Name is: " + value));

		Map<String, String> map = new HashMap<>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		Optional<Map<String, String>> nameMap = Optional.ofNullable(map);

		// Using Optional and forEach to mimic ifPresent on each map entry
		nameMap.ifPresent(m -> System.out.println("Found map: " + m));
		nameMap.ifPresent(m -> m.forEach((k, value) -> System.out.println("Found key: " + k + ", value: " + value)));

		// 6. orElse():If the Optional is empty, this method returns a default value.
		Object finalName = Optional.ofNullable(null).orElse("Default Name");
		System.out.println(finalName);

		// 7. orElseGet()
		String nameFromSupplier = name.orElseGet(() -> "Generated Name");
		System.out.println("Name (orElseGet): " + nameFromSupplier); // Output: Generated Name

		// 8. orElseThrow()
		try {
			String nameThrow = name.orElseThrow(() -> new IllegalArgumentException("No value present"));
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage()); // Output: No value present
		}

		// 10. flatMap()
		Optional<String> flatMappedName = name.flatMap(n -> Optional.of(n.toUpperCase()));
		flatMappedName.ifPresent(value -> System.out.println("FlatMapped name (flatMap): " + value)); // Output: JOHN

		// 11. filter()
		Optional<Integer> number = Optional.of(5);
		Optional<Integer> filtered = number.filter(n -> n > 10);

	}

}
