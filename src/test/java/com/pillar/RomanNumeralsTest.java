package com.pillar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralsTest {

	@Test
	public void number1IsNumeralI() throws Exception {
		assertEquals("I", new RomanNumerals().getNumeral(1));
	}
	
}
