package com.pillar.conversions.romannumerals.ui;

import java.io.IOException;
import java.util.Scanner;

import com.pillar.conversions.romannumerals.RomanNumeralsConverter;

/**
 * A Command line interface for Converter instances.
 */
public class RomanNumeralsConverterCLI {

	public static final String EXIT_CHAR = "Q";
	
	private final Printline printer = new Printline();
	
	private RomanNumeralsConverter romanNumeralsConverter = new RomanNumeralsConverter();

	public static void main(String... args) throws IOException {
		new RomanNumeralsConverterCLI().start();
	}

	public void start() {
		String line = "";
		Scanner scanner = new Scanner(System.in);
		try{
			while (!line.equals(EXIT_CHAR)) {
				if (!"".equals(line)) {
					inputFromUser(line);
				}
				String info1 = "Enter a roman numeral to convert to an integer, or an integer to convert to a roman numeral.";
				String info2 = "Entering '" + EXIT_CHAR + "' without quotes will exit:";
				String newline = System.getProperty("line.separator");
				System.out.println(newline + info1 + newline + info2);
				line = scanner.nextLine();
			}
		}finally{
			scanner.close();
		}
		System.out.println("Thanks! Bye!");
	}

	public String inputFromUser(String line) {
		String output = "";
		try {
			if (line.matches("\\d+")) {
				output = romanNumeralsConverter.convertIntegerToRomanNumerals(Integer.parseInt(line));
			} else {
				output = "" + romanNumeralsConverter.convertRomanNumeralsToInteger(line);
			}
			System.out.print(line + "=");
			printConversionOutput(output);
		} catch (NumberFormatException pe) {
			output = String.format("%s is not a valid arabic integer.", line);
		}
		return output;
	}

	public void printConversionOutput(String output) {
		printer.print(output);
	}

	public static class Printline {
		public void print(String output){
			System.out.println(output);
		}
	}
	
}
