Feature: Number -> Numeral
  To allow a user to find the roman numeral equivalent of a number.
 
  Scenario: Convert a number into a string of roman numerals
	Given I have started the converter
	  | number | numeral   |
	  | 1      | I         |
	  | 3      | III       |
	  | 9      | IX        |
	  | 1066   | MLXVI     |
	  | 1989   | MCMLXXXIX |
	When I enter $number
	Then $numeral is returned