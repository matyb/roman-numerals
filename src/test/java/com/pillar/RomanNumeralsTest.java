package com.pillar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralsTest {

	@Test
	public void number1IsNumeralI() throws Exception {
		assertEquals("I", new RomanNumerals().getNumeral(1));
	}
	
	@Test
	public void number3IsNumeralIII() throws Exception {
		assertEquals("III", new RomanNumerals().getNumeral(3));
	}
	
	@Test
	public void number9IsNumeralIX() throws Exception {
		assertEquals("IX", new RomanNumerals().getNumeral(9));
	}
	
	@Test
	public void number1066IsNumeralMLXVI() throws Exception {
		assertEquals("MLXVI", new RomanNumerals().getNumeral(1066));
	}
	
	@Test
	public void number1989IsNumeralMCMLXXXIX() throws Exception {
		assertEquals("MCMLXXXIX", new RomanNumerals().getNumeral(1989));
	}
	
}
