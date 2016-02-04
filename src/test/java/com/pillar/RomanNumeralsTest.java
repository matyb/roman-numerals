package com.pillar;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsTest {
	
	private Map<String, Integer> cases;
	
	@Before
	public void setup() throws Exception {
		this.cases = new LinkedHashMap<String, Integer>();
		cases.put("I", 1);
		cases.put("III", 3);
		cases.put("IX", 9);
		cases.put("MLXVI", 1066);
		cases.put("CMLXXXIX", 989);
		cases.put("MCMLXXXIX", 1989);
	}
	
	@Test
	public void testNumberToNumeral() throws Exception {
		RomanNumerals romanNumerals = new RomanNumerals();
		for(Entry<String, Integer> entry : cases.entrySet()){
			assertEquals(entry.getKey(), romanNumerals.getNumeral(entry.getValue()));
		}
	}
	
	@Test
	public void testNumeralToNumber() throws Exception {
		RomanNumerals romanNumerals = new RomanNumerals();
		for(Entry<String, Integer> entry : cases.entrySet()){
			assertEquals(entry.getValue(), romanNumerals.getNumber(entry.getKey()));
		}
	}
	
}
