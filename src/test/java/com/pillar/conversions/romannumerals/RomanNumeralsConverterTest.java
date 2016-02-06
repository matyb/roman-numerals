package com.pillar.conversions.romannumerals;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsConverterTest {

	private Map<String, Integer> cases;

	@Before
	public void setup() throws Exception {
		this.cases = new LinkedHashMap<>();
		cases.put("I", 1);
		cases.put("III", 3);
		cases.put("IX", 9);
		cases.put("XLI", 41);
		cases.put("XCI", 91);
		cases.put("CDI", 401);
		cases.put("DI", 501);
		cases.put("CMLXXXIX", 989);
		cases.put("MLXVI", 1066);
		cases.put("MCMLXXXIX", 1989);
	}

	// TODO: enforce symmetry without testing more than one thing in a method!
	@Test
	public void testArabicIntegerToRomanNumeral() throws Exception {
		testConversion("ARABIC -> ROMAN", new ConversionTest() {
			public void test(RomanNumeralsConverter converter, String roman, Integer arabic) throws Exception {
				assertEquals(roman, converter.convertIntegerToRomanNumerals(arabic));
			}
		});
	}

	// TODO: enforce symmetry without testing more than one thing in a method!
	@Test
	public void testRomanNumeralToArabicInteger() throws Exception {
		testConversion("ROMAN -> ARABIC", new ConversionTest() {
			public void test(RomanNumeralsConverter converter, String roman, Integer arabic) throws Exception {
				assertEquals(arabic, converter.convertRomanNumeralsToInteger(roman));
			}
		});
	}
	
	void testConversion(String conversionDescription, ConversionTest test) throws Exception{
		for(Entry<String, Integer> numeralAndNumber : cases.entrySet()){
			try{
				test.test(new RomanNumeralsConverter(), numeralAndNumber.getKey(), numeralAndNumber.getValue());
			}catch(AssertionError|Exception x){
				throw new AssertionError(String.format("Converting %s failed. %s", conversionDescription, x.getMessage()), x);
			}
		}
	}

	interface ConversionTest {
		void test(RomanNumeralsConverter converter, String roman, Integer arabic) throws Exception;
	}
	
}
