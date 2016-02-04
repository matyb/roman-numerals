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
			line = System.console().readLine(info1 + System.getProperty("line.separator") + info2 + System.getProperty("line.separator"));
			cli.input(line);
		}
		System.out.println("Thanks! Bye!");
	}
	
	public String input(String line) {
		String output = "";
		try{
			if(line.matches("\\d+")){
				output = romanNumeralsConverter.getNumeral(Integer.parseInt(line));
				System.out.println(String.format("For the number you entered: %s the numeral equivalent is: %s", line, output));
			}else{
				output = "" + romanNumeralsConverter.getNumber(line);
				System.out.println(String.format("For the numeral you entered: %s the numeric equivalent is: %s", line, output));
			}
		}catch(NumberFormatException pe){
			output = String.format("%s is not a valid arabic integer.", line);
		}
		return output;
	}

}
