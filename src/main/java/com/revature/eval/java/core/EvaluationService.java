package com.revature.eval.java.core;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.HashSet;

public class EvaluationService {
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		String newString = "";
		int count = 1;
		while(newString.length() < string.length()) {
			newString += string.charAt(string.length() - count);
			//System.out.println(newString);
			count++;
		}
		return newString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] split = phrase.split(" |\\-");
		String acronym = "";
		for(int i = 0; i < split.length; i++) {
			acronym += split[i].toUpperCase().charAt(0);
		}
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;
		/*static double side1;
		static double side2;
		static double side3;*/
		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			this.sideOne = getSideOne();
			this.sideTwo = getSideTwo();
			this.sideThree = getSideThree();
			if(sideOne == sideTwo && sideOne == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			this.sideOne = getSideOne();
			this.sideTwo = getSideTwo();
			this.sideThree = getSideThree();
			if(sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			this.sideOne = getSideOne();
			this.sideTwo = getSideTwo();
			this.sideThree = getSideThree();
			if(sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0;
		String[] playedLetters = string.split("(?!^)");
		for(int i = 0; i < playedLetters.length; i++) {
			switch(playedLetters[i].toLowerCase()) {
			case "a" :
			case "e" :
			case "i" :
			case "o" :
			case "u" :
			case "l" :
			case "n" :
			case "r" :
			case "s" :
			case "t" :
				score += 1;
				break;
			case "d" :
			case "g" :
				score += 2;
				break;
			case "b" :
			case "c" :
			case "m" :
			case "p" :
				score += 3;
				break;
			case "f" :
			case "h" :
			case "v" :
			case "w" :
			case "y" :
				score += 4;
				break;
			case "k" :
				score += 5;
				break;
			case "j" :
			case "x" :
				score += 8;
				break;
			case "q" :
			case "z" :
				score += 10;
				break;
			default:
				score += 0;
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		StringBuilder phoneNumber = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				phoneNumber.append(string.charAt(i));
			} else {
				switch(string.charAt(i)) {
				case '(':
				case ')':
				case '.':
				case ' ':
				case '-' :
					continue;
				default:
					throw new IllegalArgumentException("Invalid entry");
				}
				//
			}
		}
			if(phoneNumber.length() > 11) {
				throw new IllegalArgumentException("Your number is too long");
			}
		return phoneNumber.toString();
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		Map<String, Integer> wordNumber = new HashMap<>();
		String[] words = string.split("\\W+");
		for(int i = 0; i < words.length; i++) {
			if(wordNumber.containsKey(words[i])) {
				wordNumber.put(words[i], wordNumber.get(words[i]) + 1);
			} else {
				wordNumber.put(words[i], 1);
			}
		}
		return wordNumber;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			int leftNode = 0;
			int centerNode = sortedList.size() / 2;
			int rightNode = sortedList.size() - 1;
			while(rightNode != leftNode) {
				if(String.valueOf(sortedList.get(centerNode)).compareTo(String.valueOf(t)) == 0){
					return centerNode;
				} else if (Integer.parseInt(String.valueOf(sortedList.get(centerNode))) >  Integer.parseInt(String.valueOf(t))) {
					rightNode = centerNode - 1;
					centerNode = ((rightNode - leftNode) / 2) + leftNode;
				} else {
					leftNode = centerNode + 1;
					centerNode = ((rightNode - leftNode) / 2) + leftNode;
				}
			}
			return leftNode;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		StringBuilder pigLatin = new StringBuilder();
		String[] words = string.split(" ");
		StringBuilder currentShift = new StringBuilder("");
			for(int i = 0; i < words.length; i++) {
				for( int j = 0; j < words[i].length(); j++) {
					if((words[i].charAt(j) == 'q') && words[i].charAt(j + 1) == 'u') {
						currentShift.append(words[i].charAt(j) + "" + words[i].charAt(j + 1));
					}else  if((words[i].charAt(j) == 'a' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'i') || words[i].charAt(j) == 'o'||
							words[i].charAt(j) == 'u') {
						break;

					} else {
						currentShift.append(words[i].charAt(j));
					}
				}
				pigLatin.append(words[i]);
				pigLatin.append(currentShift + "ay ");
				if(currentShift.length() > 0) {
					if(i == 0) {
						pigLatin.delete(0,  currentShift.length());
					} else {
						if(words[i - 1].length() <= pigLatin.length()) {
							pigLatin.delete(pigLatin.length() - (words[i - 1].length() + 3), (pigLatin.length() - (words[i - 1].length() + 3)) + currentShift.length());
						} else {
							pigLatin.delete(((words[i - 1].length() + 3)- pigLatin.length()), (words[i - 1].length() + 3) - pigLatin.length() + currentShift.length());
						}
					}
				}
				currentShift.delete(0, currentShift.length());
			}
		pigLatin.delete(pigLatin.length() - 1, pigLatin.length());
		return pigLatin.toString();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int number = input;
		int total = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (number > 0) {
			stack.push(number % 10);
			number = number / 10;
		}
		int power = stack.size();
		while(!stack.isEmpty()) {
			total += Math.pow(stack.pop(), power);
		}
		
		if(total == input) {
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		//ArrayList<Long> factors = new ArrayList<>();
		long count = 2;
		ArrayList<Long> primeFactors = new ArrayList<>();
		//System.out.println(l);
		/*while(count <= l) {
			if(l % count == 0) {
				factors.add(count);
				count++;
			}
		}*/
		
		if(l < 2) {
			return primeFactors;
		} else if(l == 2) {
			primeFactors.add(l);
			return primeFactors;
		} else {
			while(count < l && l % count != 0) {
				count++;
			}
			primeFactors.add(count);
			primeFactors.addAll(calculatePrimeFactorsOf(l / count));
		}
		
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String[] letters = string.split("(?!^)");
			char[] alphaL = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			char[] alphaC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			char letter;
			int index;
			int count = 0;
			StringBuilder cipherText = new StringBuilder();
			for(int i = 0; i < letters.length; i++) {
				letter = letters[i].charAt(0);
				//System.out.println(letter);
				if(Character.isLetter(letter)) {
					//System.out.println("Is Letter, true");
					if(Character.isUpperCase(letter)) {
						count = 0;
						while(alphaC[count] != letter) {
							count++;
						}
						index = count;	
						index += this.key;
						//System.out.println(index);
						//System.out.println(this.key);
						if(index > 25) {
							index -= 26;
							cipherText.append(alphaC[index]);
							//System.out.println(cipherText);
						} else {
							cipherText.append(alphaC[index]);
							//System.out.println(cipherText);
						}
					} else {
						count = 0;
						while(alphaL[count] != letter) {
							count++;
						}
						index = count;	
						index += this.key;
						//System.out.println(index);
						//System.out.println(this.key);
						if(index > 25) {
							index -= 26;
							cipherText.append(alphaL[index]);
						} else {
							cipherText.append(alphaL[index]);
						}
					}
				} else {
					cipherText.append(letter);
				}
			}
			return cipherText.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int primeCount = 0;
		int currentNum = 2;
		if(i == 0) {
			throw new IllegalArgumentException();
		}
		while(primeCount < i) {
			if(currentNum == 2) {
				primeCount++;
			} else {
				for(int j = 2; j < currentNum; j++) {
					if(currentNum % j == 0) {
						break;
					} else if(j == (currentNum - 1)) {
						primeCount++;
					} else {
						continue;
					}
				}
			}
			if(primeCount == i) {
				break;
			}
			currentNum++;
		}
		return currentNum;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		static char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		static char[] reverseAlpha = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
		static String[] words;
		static ArrayList<Character> letters = new ArrayList<>();
		//static StringBuilder finalCode = new StringBuilder();
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			ArrayList<Character> coded  = new ArrayList<>();
			StringBuilder finalCode = new StringBuilder();
			letters.clear();
			words = string.toLowerCase().split("\\W");
			for (int i = 0; i < words.length; i++) {
				for(int j = 0; j <words[i].length(); j++) {
					letters.add(words[i].charAt(j));
				}
			}
			
			for (int i = 0; i < letters.size(); i++) {
				if(Character.isDigit(letters.get(i))) {
					coded.add(letters.get(i));
				} else if(!(Character.isDigit(letters.get(i)))) {
					coded.add(reverseAlpha[new String(alpha).indexOf(letters.get(i))]);
				} else {
					
				}
			}
			
			for(int i = 0; i < coded.size(); i++) {
				if((i + 1) % 5 == 0) {
					finalCode.append(coded.get(i) + " ");
				} else {
					finalCode.append(coded.get(i));
				}
			}
			if(finalCode.charAt(finalCode.length() - 1) == ' ') {
				finalCode.deleteCharAt(finalCode.length() - 1);
			}
			return finalCode.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			letters.clear();
			// TODO Write an implementation for this method declaration
			ArrayList<Character> decoded  = new ArrayList<>();
			String finalDecryption = "";
			letters.clear();
			words = string.toLowerCase().split("\\W");
			for (int i = 0; i < words.length; i++) {
				for(int j = 0; j <words[i].length(); j++) {
					letters.add(words[i].charAt(j));
				}
			}
			
			for (int i = 0; i < letters.size(); i++) {
				if(Character.isDigit(letters.get(i))) {
					decoded.add(letters.get(i));
				} else if(!(Character.isDigit(letters.get(i)))) {
					decoded.add(alpha[new String(reverseAlpha).indexOf(letters.get(i))]);
				} else {
					
				}
			}
			
			for (int i = 0; i < letters.size(); i++) {
				finalDecryption += decoded.get(i);
			}
			return finalDecryption;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		String[] numbers = string.split("\\W");
		Queue<Integer> digits = new LinkedList<>();
		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length(); j++) {
				if(numbers[i].charAt(j) == 'X') {
					digits.offer(10);
				} else if(Character.isDigit(numbers[i].charAt(j))) {
					digits.offer(Character.getNumericValue((numbers[i].charAt(j))));
				} else {
					return false;
				}
			}
		}
		while(!digits.isEmpty()) {
			total += (digits.size() * digits.poll());
		}
		//System.out.println(total);
		if(total % 11 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		Set<Character> letters = new HashSet<>();
		String[] words = string.toLowerCase().split("(?!^)");
		for(int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				letters.add(words[i].charAt(j));
			}
		}
		
		if(letters.contains(' ')) {
			letters.remove(' ');
		}
		//System.out.println(letters);
		//System.out.println(letters.size());
		if(letters.size() == 26) {
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		String date = given.getClass().getSimpleName();
		LocalDateTime ldt = null;
		System.out.println(date);
		if(date.equals("LocalDateTime")) {
			return ((LocalDateTime)given).plusSeconds(1000000000);
		} else if(date.equals("LocalDate")){
			return ((LocalDate)given).atTime(0, 0, 0).plusSeconds(1000000000);
		}
		return ldt;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		ArrayList<Integer> totalArr = new ArrayList<Integer>();
		int total = 0;
		int count;
		int product = 0;
		for(int j = 0; j < set.length; j++) {
			count = 1;
			product = 0;
			while(product < i) {
				product = count * set[j];
				if (product < i) {
					 if(!totalArr.contains(product)) {
						 totalArr.add(product); 
					 }
					 count++;
				}
			}
		}
		for(int j = 0; j < totalArr.size(); j++) {
			total += totalArr.get(j);
		}
		return total;
}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		String[] numbers = string.split("\\s");
		ArrayList<Integer> digits = new ArrayList<>();
		char temp;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length(); j++) {
				temp = numbers[i].charAt(j);
				if(Character.isDigit(temp)) {
					digits.add(Character.getNumericValue(temp));
				} else {
					return false;
				}
			}
		}
		//System.out.println(digits);
		Queue<Integer> doublesBefore = new LinkedList<>();
		//Queue<Integer> doublesAfter = new LinkedList<>();
 		Queue<Integer> singles = new LinkedList<>();
		int total = 0;
		if(string.length() <= 1) {
			return false;
		} else {
			for(int i = digits.size() - 1; i > 0; i--) {
				if(i % 2 == 0) {
					singles.offer(digits.get(i));
				} else {
					doublesBefore.offer(digits.get(i));
				}
		
			}
			//System.out.println(singles + " " + doublesBefore);
			for(int i = 0; i < doublesBefore.size(); i++) {
				if((doublesBefore.peek() * 2) > 9) {
					doublesBefore.offer((doublesBefore.poll() * 2) - 9);
				} else {
					doublesBefore.offer(doublesBefore.poll() * 2);
				}
			}
			//System.out.println(doublesBefore);
		
			while(!doublesBefore.isEmpty() || !singles.isEmpty()) {
				if (!doublesBefore.isEmpty()) {
					total += doublesBefore.poll();
				}
			
				if(!singles.isEmpty()) {
					total += singles.poll();
				}
			}
			//System.out.println(total);
			if(total % 10 == 0) {
				return true;
			}
			return false;
		}
	}
	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] sentence = string.split("[\\s|?]");
		String operator = "";
		int operand1 = 0;
		int operand2 = 0;
			for (int i = 0; i < sentence.length; i++) {
				//System.out.println(sentence[i]);
				if(sentence[i].matches(("-?\\d+(\\.\\d+)?"))) {
					operand1 = Integer.parseInt(sentence[i]);
					operator = sentence[i + 1];
					//System.out.println(operand1 + "" + operator);
					if(operator.equals("divided") || operator.equals("multiplied")) {
						operator += " " + sentence[i + 2];
						operand2 = Integer.parseInt(sentence[i + 3]);
						break;
					} else {
						operand2 =Integer.parseInt(sentence[i + 2]);
						break;
					}
				}
				continue;
			}
			//System.out.println(operand1 + "" + operator + "" + operand2);
			switch(operator) {
			case "plus":
				return operand1 + operand2;
			case "minus":
				return operand1 - operand2;
			case "multiplied by":
				return operand1 * operand2;
			case "divided by":
				return operand1 / operand2;
			default:
				return 0;
			}
			//System.out.println(operand1 + " " + operator + " " + operand2);
	}

}
