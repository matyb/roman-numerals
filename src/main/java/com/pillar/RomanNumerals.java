package com.pillar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanNumerals {

	private Map<Integer, String> numeralByNumber;
	
	public RomanNumerals() {
		Map<Integer, String> numeralByNumber = new LinkedHashMap<Integer, String>();
		numeralByNumber.put(1000, "M");
		numeralByNumber.put(900, "CM");
		numeralByNumber.put(500, "D");
		numeralByNumber.put(400, "CD");
		numeralByNumber.put(100, "C");
		numeralByNumber.put(90, "XC");
		numeralByNumber.put(50, "L");
		numeralByNumber.put(40, "XL");
		numeralByNumber.put(10, "X");
		numeralByNumber.put(9, "IX");
		numeralByNumber.put(5, "V");
		numeralByNumber.put(4, "IV");
		numeralByNumber.put(1, "I");
		this.numeralByNumber = numeralByNumber;
	}
	
	public String getNumeral(Integer number) {
		StringBuilder string = new StringBuilder();  
        int remainder = number;
        for (Entry<Integer, String> entry : numeralByNumber.entrySet()) {
           while (remainder >= entry.getKey()) {
              string.append(entry.getValue());
              remainder -= entry.getKey();
           }
        }
        return string.toString();
	}

}
