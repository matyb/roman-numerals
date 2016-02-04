package com.pillar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanNumerals {

	private Map<String, Integer> numberByNumeral;
	
	public RomanNumerals() {
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
		this.numberByNumeral = numberByNumeral;
	}
	
	public String getNumeral(Integer number) {
		StringBuilder string = new StringBuilder();  
        int remainder = number;
        for (Entry<String, Integer> entry : numberByNumeral.entrySet()) {
           while (remainder >= entry.getValue()) {
              string.append(entry.getKey());
              remainder -= entry.getValue();
           }
        }
        return string.toString();
	}

	public Integer getNumber(String roman) {
		Integer number = 0, lastValue = 0;
	    char[] romanNumerals = roman.toUpperCase().toCharArray();
	    for (int i = romanNumerals.length - 1; i > -1 ; i--) {
	    	String character = String.valueOf(romanNumerals[i]);
	    	Integer value = numberByNumeral.get(character);
	    	number = toNumber(value, lastValue, number);
	    	lastValue = value;
	    }
	    return number;
	}
	
	private Integer toNumber(Integer value, Integer lastValue, Integer lastNumber){
		return lastValue > value ? lastNumber - value : lastNumber + value;
	}

}
