package com.pillar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
		List<Entry<Integer,String>> tuple = findAdjacentNumerals(number); 
		return toNumeral(number, tuple);	
	}

	private String toNumeral(Integer number, List<Entry<Integer, String>> tuple) {
		Entry<Integer, String> lower = tuple.get(0);
		if(tuple.size() == 1){
			return lower.getValue();
		} else {
			Entry<Integer, String> upper = tuple.get(1);
			if(upper.getKey() - lower.getKey() == number){
				return lower.getValue() + upper.getValue();
			}else if(upper.getKey() - number < lower.getKey()){
				tuple = findAdjacentNumerals(lower.getKey() - 1);
				return toNumeral(number, Arrays.asList(tuple.get(0), upper));
			}else{
				return String.format("%s%s%s", lower.getValue(),lower.getValue(),lower.getValue());
			}
		}
	}

	private List<Entry<Integer, String>> findAdjacentNumerals(Integer number) {
		Entry<Integer, String> lower = null, upper = null;
		for(Entry<Integer, String> entry : numeralByNumber.entrySet()){
			if(number > entry.getKey()){
				lower = entry;
			}else if(number < entry.getKey()){
				upper = entry;
				break;
			}else{
				return Arrays.asList(entry);
			}
		}
		return Arrays.asList(lower, upper);
	}
	
}
