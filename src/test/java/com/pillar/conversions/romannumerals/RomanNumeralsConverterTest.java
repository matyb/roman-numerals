package com.pillar.conversions.romannumerals;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import com.pillar.conversions.romannumerals.RomanNumeralsConverter;

public class RomanNumeralsConverterTest {
	
	private Map<String, Integer> cases;
	
	@Before
	public void setup() throws Exception {
		this.cases = new LinkedHashMap<>();
		cases.put("I", 1);
		cases.put("III", 3);
		cases.put("IX", 9);
		cases.put("MLXVI", 1066);
		cases.put("CMLXXXIX", 989);
		cases.put("MCMLXXXIX", 1989);
	}
	
	/**
	 * <b>TODO: I KNOW THIS IS GENERALLY A BAD IDEA TO TEST > 1 THING IN ONE
	 * UNIT TEST! but enforcing symmetry between conversions felt more valuable.<b>
	 * oh and comments in tests are usually a code smell, but - i wanted to explain.
	 */
	@Test
	public void testNumberToNumeral() throws Exception {
		RomanNumeralsConverter romanNumerals = new RomanNumeralsConverter();
		for(Entry<String, Integer> entry : cases.entrySet()){
			assertEquals(entry.getKey(), romanNumerals.from(entry.getValue()));
		}
	}
	
	/**
	 * <b>TODO: I KNOW THIS IS GENERALLY A BAD IDEA TO TEST > 1 THING IN ONE
	 * UNIT TEST! but enforcing symmetry between conversions felt more valuable.<b>
	 * oh and comments in tests are usually a code smell, but - i wanted to explain.
	 */
	@Test
	public void testNumeralToNumber() throws Exception {
		RomanNumeralsConverter romanNumerals = new RomanNumeralsConverter();
		for(Entry<String, Integer> entry : cases.entrySet()){
			assertEquals(entry.getValue(), romanNumerals.to(entry.getKey()));
		}
	}
	
}
