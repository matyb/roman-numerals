package feature;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.pillar.conversions.romannumerals.ui.RomanNumeralsConverterCLI;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RomanNumeralsConversionSteps {

	private RomanNumeralsConverterCLI converter;
	private DataTable data;
	private List<String> output;

	@Given("^I have started the converter$")
	public void i_have_started_the_converter(DataTable arg1) throws Throwable {
		converter = new RomanNumeralsConverterCLI();
		data = arg1;
		output = new ArrayList<>(data.getGherkinRows().size() - 1);
	}

	@When("^I enter \\$number$")
	public void i_enter_$number() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			output.add(converter.input(data.getGherkinRows().get(i).getCells().get(0)));
		}
	}

	@When("^I enter \\$numeral$")
	public void i_enter_$numeral() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			output.add(converter.input(data.getGherkinRows().get(i).getCells().get(1)));
		}
	}

	@Then("^\\$numeral is returned$")
	public void $numeral_is_returned() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			assertEquals(output.get(i - 1), data.getGherkinRows().get(i).getCells().get(1));
		}
	}

	@Then("^\\$number is returned$")
	public void $number_is_returned() throws Throwable {
		for (int i = 1; i < data.getGherkinRows().size(); i++) {
			assertEquals(output.get(i - 1), data.getGherkinRows().get(i).getCells().get(0));
		}
	}

}
