/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed"); 
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		while(str1.indexOf(' ') != -1) str1 = removeCharFromString(str1, ' ');
		while(str2.indexOf(' ') != -1) str2 = removeCharFromString(str2, ' ');
		if(str1.length() != str2.length()) return false;
		while (str1.length() != 0 && str2.length() != 0) {
			int rnd = (int) (Math.random()*str1.length());
			char ch = str1.charAt(rnd);
			if(str2.indexOf(ch)== -1) return false;
			str1 = removeCharFromString(str1, ch);
			str2 = removeCharFromString(str2, ch);
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "" , check = "abcdefghijklmnopqrstuvwxyz ";
		str = str.toLowerCase();
		for(int i = 0 ; i < str.length() ; i ++) {
			if(check.indexOf(str.charAt(i)) != -1) {
				newStr += str.charAt(i);
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";
		int originLength = str.length();
		for(int i = 0 ; i < originLength ; i ++) {
			int rnd = (int) (Math.random()*(str.length()));
			newStr += str.charAt(rnd);
			str = removeCharFromString(str, rnd);
		}
		return newStr;
	}

	public static String removeCharFromString(String str , int index) {
		// Removes a char from a string by an index
		String newStr = "";
		for(int i = 0 ; i < index ; i ++) {
			newStr += str.charAt(i);
		}
		for(int i = index + 1 ; i < str.length() ; i ++) {
			newStr += str.charAt(i);
		}
		return newStr;
	}

	public static String removeCharFromString(String str , char ch) {
		// Removes a char from a string by the char itself
		int index = str.indexOf(ch);
		String newStr = "";
		for(int i = 0 ; i < index ; i ++) {
			newStr += str.charAt(i);
		}
		for(int i = index + 1 ; i < str.length() ; i ++) {
			newStr += str.charAt(i);
		}
		return newStr;
	}

}
