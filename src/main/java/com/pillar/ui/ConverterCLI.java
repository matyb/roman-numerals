package com.pillar.ui;

import com.pillar.RomanNumerals;

public class ConverterCLI {

	private RomanNumerals romanNumeralsConverter = new RomanNumerals();
	
	public static void main(String[] args) {
		String line = "";
		ConverterCLI cli = new ConverterCLI();
		while(!line.equals("Q")){
			String info1 = "Enter a roman numeral to convert to an integer, or an integer to convert to a roman numeral.";
			String info2 = "Entering 'Q' without quotes will exit:";
			line = System.console().readLine(info1 + System.getProperty("line.separator") + info2 + System.getProperty("line.separator")).toUpperCase();
			System.out.println(String.format("For the number you entered: %s the numeral equivalent is: %s", line, cli.input(line)));
		}
		System.out.println("Thanks! Bye!");
	}
	
	public String input(String arabicNumber) {
		try{
			return input(Integer.parseInt(arabicNumber));
		}catch(NumberFormatException pe){
			return String.format("%s is not a valid arabic integer.", arabicNumber);
		}
	}
	
	public String input(Integer arabicNumber) {
		return romanNumeralsConverter.getNumeral(arabicNumber);
	}

}
