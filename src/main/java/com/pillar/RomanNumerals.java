package com.pillar;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {

	final private Map<Integer, String> numeralByNumber;
	
	public RomanNumerals() {
		Map<Integer, String> numeralByNumber = new LinkedHashMap<Integer, String>();
		numeralByNumber.put(1, "I");
		numeralByNumber.put(5, "V");
		numeralByNumber.put(10, "X");
		numeralByNumber.put(50, "L");
		numeralByNumber.put(100, "C");
		numeralByNumber.put(1000, "M");
		this.numeralByNumber = numeralByNumber;
	}

	public String getNumeral(Integer number) {
		return numeralByNumber.get(number);
	}
	
}
