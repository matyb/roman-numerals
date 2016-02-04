package com.pillar.conversions.romannumerals;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.pillar.conversions.utils.Converter;

/**
 * A class for converting to and from roman numerals and arabic integers.
 */
public class RomanNumeralsConverter implements Converter<Integer, String> {

	private final Map<String, Integer> numberByNumeral;

	/**
	 * Constructs an instance capable of converting from a string of roman
	 * numerals into an arabic integer, and vice versa.
	 */
	public RomanNumeralsConverter() {
		Map<String, Integer> numberByNumeral = new LinkedHashMap<String, Integer>();
		numberByNumeral.put("M", 1000);
		numberByNumeral.put("CM", 900);
		numberByNumeral.put("D", 500);
		numberByNumeral.put("CD", 400);
		numberByNumeral.put("C", 100);
		numberByNumeral.put("XC", 90);
		numberByNumeral.put("L", 50);
		numberByNumeral.put("XL", 40);
		numberByNumeral.put("X", 10);
		numberByNumeral.put("IX", 9);
		numberByNumeral.put("V", 5);
		numberByNumeral.put("IV", 4);
		numberByNumeral.put("I", 1);
		this.numberByNumeral = Collections.unmodifiableMap(numberByNumeral);
	}

	/**
	 * Convert an arabic integer into a string of roman numerals.
	 * 
	 * @param arabic
	 *            integer
	 * @return roman numerals
	 */
	public String from(Integer number) {
<<<<<<< HEAD
		StringBuilder string = new StringBuilder();
		int remainder = number;
		for (Entry<String, Integer> entry : numberByNumeral.entrySet()) {
			while (remainder >= entry.getValue()) {
				string.append(entry.getKey());
				remainder -= entry.getValue();
			}
		}
		return string.toString();
=======
            StringBuilder string = new StringBuilder();  
            int remainder = number;
            for (Entry<String, Integer> entry : numberByNumeral.entrySet()) {
               while (remainder >= entry.getValue()) {
                  string.append(entry.getKey());
                  remainder -= entry.getValue();
               }
            }
            return string.toString();
>>>>>>> 6995e3e77d6fb88bacdf04eb2b3655dc768720b6
	}

	/**
	 * Convert a string of roman numerals into an arabic integer.
	 * 
	 * @param roman
	 *            numerals
	 * @return arabic integer
	 */
	public Integer to(String roman) {
<<<<<<< HEAD
		Integer number = 0, lastValue = 0;
		char[] romanNumerals = roman.toUpperCase().toCharArray();
		for (int i = romanNumerals.length - 1; i > -1; i--) {
			String character = String.valueOf(romanNumerals[i]);
			Integer value = numberByNumeral.get(character);
			number += toNumber(value, lastValue);
			lastValue = value;
		}
		return number;
=======
            Integer number = 0, lastValue = 0;
            char[] romanNumerals = roman.toUpperCase().toCharArray();
            for (int i = romanNumerals.length - 1; i > -1 ; i--) {
                String character = String.valueOf(romanNumerals[i]);
                Integer value = numberByNumeral.get(character);
                number += toNumber(value, lastValue);
                lastValue = value;
            }
            return number;
>>>>>>> 6995e3e77d6fb88bacdf04eb2b3655dc768720b6
	}

	/**
	 * Assumes traversal from Right to Left when totaling the arabic value of
	 * roman numerals, can resolve an arabic value from 2 adjacent numeral's
	 * arabic values.
	 * 
	 * @param value
	 *            arabic value of currently iterated numeral (left of)
	 * @param lastValue
	 *            arabic value of last iterated numeral right and adjacent of
	 *            the currently iterated numeral
	 * @return negated value if currently iterated numeral is a lower value than
	 *         the previously iterated numeral or the positively signed value if
	 *         not.
	 */
<<<<<<< HEAD
	private Integer toNumber(Integer value, Integer lastValue) {
		return lastValue > value ? -1 * value : value;
=======
	private Integer toNumber(Integer value, Integer lastValue){
            return lastValue > value ? -1 * value : value;
>>>>>>> 6995e3e77d6fb88bacdf04eb2b3655dc768720b6
	}

}
