package feature;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.pillar.conversions.romannumerals.ui.RomanNumeralsConverterCLI;
import com.pillar.conversions.romannumerals.ui.RomanNumeralsConverterCLI.Printline;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RomanNumeralsConversionSteps {

	private static final int INTEGER_CELL = 0;
	private static final int NUMERAL_CELL = 1;
	
	private DataTable data;
	private List<String> output;
	
	private InputStream in;
	private Printline fakeStdOut;
	private RomanNumeralsConverterCLI cli;

	@Before
	public void store_stdio() throws Throwable {
		in = System.in;
	}
	
	@Given("^I have started the converter$")
	public void i_have_started_the_converter(DataTable arg1) throws Throwable {
		data = arg1;
		output = new ArrayList<>(data.getGherkinRows().size() - 1);
		fakeStdOut = new Printline(){
			public void print(String outputString){
				System.out.println(outputString);
				output.add(outputString);
			}
		};
		cli = new RomanNumeralsConverterCLI(){
			public void printConversionOutput(String output) {
				fakeStdOut.print(output);
			};
		};
	}

	@When("^I enter \\$number$")
	public void i_enter_$number() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			input(i, INTEGER_CELL);
		}
	}

	@When("^I enter \\$numeral$")
	public void i_enter_$numeral() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			input(i, NUMERAL_CELL);
		}
	}

	@Then("^\\$number is returned$")
	public void $number_is_returned() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			assertEquals(output.get(i - 1), data.getGherkinRows().get(i).getCells().get(INTEGER_CELL));
		}
	}

	@Then("^\\$numeral is returned$")
	public void $numeral_is_returned() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			assertEquals(output.get(i - 1), data.getGherkinRows().get(i).getCells().get(NUMERAL_CELL));
		}
	}
	
	@After
	public void restore_stdio() throws Throwable {
		System.setIn(in);
	}

	private void input(int row, int column) throws IOException {
        String cell = data.getGherkinRows().get(row).getCells().get(column);
		String newline = System.getProperty("line.separator");
		String input = String.format("%s%s%s%s", 
				cell, newline, RomanNumeralsConverterCLI.EXIT_CHAR, newline);
		System.setIn(new ByteArrayInputStream(input.getBytes("UTF-8")));
		cli.start();
	}
	
}
