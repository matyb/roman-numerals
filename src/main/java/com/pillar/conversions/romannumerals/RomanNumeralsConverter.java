package com.pillar.conversions.romannumerals;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A class for converting to and from roman numerals and arabic integers.
 */
public class RomanNumeralsConverter {

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
	public String convertIntegerToRomanNumerals(Integer arabicInteger) {
		StringBuilder romanNumeralsBuilder = new StringBuilder();
		int remainder = arabicInteger;
		for (Entry<String, Integer> numeralKeyArabicValue : numberByNumeral.entrySet()) {
			while (remainder >= numeralKeyArabicValue.getValue()) {
				romanNumeralsBuilder.append(numeralKeyArabicValue.getKey());
				remainder -= numeralKeyArabicValue.getValue();
			}
		}
		return romanNumeralsBuilder.toString();
	}

	/**
	 * Convert a string of roman numerals into an arabic integer.
	 * 
	 * @param romanNumeralsString
	 *            roman numerals
	 * @return arabic integer
	 */
	public Integer convertRomanNumeralsToInteger(String romanNumeralsString) {
		Integer total = 0;
		String lastNumeral = "";
		char[] romanNumerals = romanNumeralsString.toUpperCase().toCharArray();
		for (int i = romanNumerals.length - 1; i > -1; i--) {
			String numeral = String.valueOf(romanNumerals[i]);
			total += getIntegerValueFromAdjacentNumerals(numeral, lastNumeral);
			lastNumeral = numeral;
		}
		return total;
	}

	/**
	 * Assumes traversal from Right to Left when totaling the arabic value of
	 * roman numerals, can resolve an arabic value from 2 adjacent numeral's.
	 * 
	 * @param leftNumeral
	 *            currently iterated numeral (left of)
	 * @param rightNumeralValue
	 *            last iterated numeral right and adjacent of
	 *            the currently iterated numeral
	 * @return negated value if currently iterated numeral is a lower value than
	 *         the previously iterated numeral or the positively signed value if
	 *         not.
	 */
	private Integer getIntegerValueFromAdjacentNumerals(String leftNumeral, String rightNumeral) {
		Integer leftNumeralIntegerValue = numberByNumeral.get(leftNumeral);
		Integer rightNumeralIntegerValue = "".equals(rightNumeral) ? 0 : numberByNumeral.get(rightNumeral);
		return rightNumeralIntegerValue > leftNumeralIntegerValue ? 
				-1 * leftNumeralIntegerValue : leftNumeralIntegerValue;
	}

}
