package String;

import java.util.Arrays;

public class AnagramCheck {

	public static void main(String[] args) {
		String str1 = "INTEGER";
		String str2 = "TEGERNI";

		System.out.println(areAnagrams(str1, str2)); 
		System.out.println(checkAnagrams(str1, str2));
	}

	public static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}

	public static String SortString(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static boolean checkAnagrams(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		str1 = SortString(str1);
		str2 = SortString(str2);

		return str1.equals(str2);
	}
}
