Feature: Numeral -> Number 
  To allow a user to find the arabic integer equivalent of a roman numberal.
 
  Scenario: Convert a string of roman numerals into a number 
	Given I have started the converter
	  | number | numeral   |
	  | 1      | I         |
	  | 3      | III       |
	  | 9      | IX        |
	  | 1066   | MLXVI     |
	  | 1989   | MCMLXXXIX |
	When I enter $numeral
	Then $number is returned