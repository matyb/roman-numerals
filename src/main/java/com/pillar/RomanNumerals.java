package com.pillar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		Entry<Integer, String> lower = null, upper = null;
		for(Entry<Integer, String> entry : numeralByNumber.entrySet()){
			if(number > entry.getKey()){
				lower = entry;
			}else if(number < entry.getKey()){
				upper = entry;
				break;
			}else{
				return entry.getValue();
			}
		}
		if(upper.getKey() - lower.getKey() == number){
			return lower.getValue() + upper.getValue();
		}else{
			return String.format("%s%s%s", lower.getValue(),lower.getValue(),lower.getValue());
		}	
	}
	
}
