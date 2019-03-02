package pl.zielinska.library;

import java.util.HashMap;

abstract class English extends LanguageScheme {
	
	English() {
		units = new HashMap<>();
		units.put(0, "");
		units.put(1, "one ");
		units.put(2, "two ");
		units.put(3, "three ");
		units.put(4, "four ");
		units.put(5, "five ");
		units.put(6, "six ");
		units.put(7, "seven ");
		units.put(8, "eight ");
		units.put(9, "nine ");

		teens = new HashMap<>();
		teens.put(10, "ten ");
		teens.put(11, "eleven ");
		teens.put(12, "twelve ");
		teens.put(13, "thirteen ");
		teens.put(14, "fourteen ");
		teens.put(15, "fifteen ");
		teens.put(16, "sixteen ");
		teens.put(17, "seventeen ");
		teens.put(18, "eighteen ");
		teens.put(19, "nineteen ");

		tens = new HashMap<>();
		tens.put(0, "");
		tens.put(2, "twenty ");
		tens.put(3, "thirty ");
		tens.put(4, "fourty ");
		tens.put(5, "fifty ");
		tens.put(6, "sixty ");
		tens.put(7, "seventy ");
		tens.put(8, "eighty ");
		tens.put(9, "ninety ");

		hundreds = new HashMap<>();
		hundreds.put(0, "");
		hundreds.put(1, "one hundred ");
		hundreds.put(2, "two hundred ");
		hundreds.put(3, "three hundred ");
		hundreds.put(4, "four hundred ");
		hundreds.put(5, "five hundred ");
		hundreds.put(6, "six hundred ");
		hundreds.put(7, "seven hundred ");
		hundreds.put(8, "eight hundred ");
		hundreds.put(9, "nine hundred ");
	}
}
