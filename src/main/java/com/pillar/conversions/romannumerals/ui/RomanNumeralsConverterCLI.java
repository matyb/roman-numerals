package com.pillar.conversions.romannumerals.ui;

import com.pillar.conversions.romannumerals.RomanNumeralsConverter;

/**
 * A Command line interface for Converter instances.
 */
public class RomanNumeralsConverterCLI {

	private RomanNumeralsConverter romanNumeralsConverter = new RomanNumeralsConverter();

	public static void main(String[] args) {
		String line = "";
		RomanNumeralsConverterCLI cli = new RomanNumeralsConverterCLI();
		while (!line.equals("Q")) {
			if (!"".equals(line)) {
				cli.input(line);
			}
			String info1 = "Enter a roman numeral to convert to an integer, or an integer to convert to a roman numeral.";
			String info2 = "Entering 'Q' without quotes will exit:";
			line = System.console().readLine(
					info1 + System.getProperty("line.separator") + info2 + System.getProperty("line.separator"));
		}
		System.out.println("Thanks! Bye!");
	}

	public String input(String line) {
		String output = "";
		try {
			if (line.matches("\\d+")) {
				output = romanNumeralsConverter.from(Integer.parseInt(line));
				System.out.println(
						String.format("For the number you entered: %s the numeral equivalent is: %s", line, output));
			} else {
				output = "" + romanNumeralsConverter.to(line);
				System.out.println(
						String.format("For the numeral you entered: %s the numeric equivalent is: %s", line, output));
			}
		} catch (NumberFormatException pe) {
			output = String.format("%s is not a valid arabic integer.", line);
		}
		return output;
	}

}
