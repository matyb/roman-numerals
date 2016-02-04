package com.pillar;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.pillar.ui.ConverterCLI;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NumberToNumeralSteps { 

	private ConverterCLI converter;
	private DataTable data;
	private List<String> output;
	
	@Given("^I have started the converter$")
	public void i_have_started_the_converter(DataTable arg1) throws Throwable {
		converter = new ConverterCLI();
		data = arg1;
		output = new ArrayList<String>(data.getGherkinRows().size() - 1);
	}

	@When("^I enter \\$number$")
	public void i_enter_$number() throws Throwable {
	    for(int i = 1; i < data.getGherkinRows().size(); i++){
	    	output.add(converter.input(data.getGherkinRows().get(i).getCells().get(0)));
	    }
	}

	@Then("^\\$numeral is returned$")
	public void $numeral_is_returned() throws Throwable {
		for(int i = 1; i < data.getGherkinRows().size(); i++){
	    	assertEquals(output.get(i - 1), data.getGherkinRows().get(i).getCells().get(1));
	    }
	}
	
}
