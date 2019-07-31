package pl.zielinska.numbers.languages;

import java.util.HashMap;
import java.util.Map;

abstract class English extends LanguageScheme {
	
	English() {
		units = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(1, "one ")
					.put(2, "two ")
					.put(3, "three ")
					.put(4, "four ")
					.put(5, "five ")
					.put(6, "six ")
					.put(7, "seven ")
					.put(8, "eight ")
					.put(9, "nine ")
					.build();

		teens = new ImmutableMapBuilder<Integer, String>()
					.put(10, "ten ")
					.put(11, "eleven ")
					.put(12, "twelve ")
					.put(13, "thirteen ")
					.put(14, "fourteen ")
					.put(15, "fifteen ")
					.put(16, "sixteen ")
					.put(17, "seventeen ")
					.put(18, "eighteen ")
					.put(19, "nineteen ")
					.build();

		tens = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(2, "twenty ")
					.put(3, "thirty ")
					.put(4, "fourty ")
					.put(5, "fifty ")
					.put(6, "sixty ")
					.put(7, "seventy ")
					.put(8, "eighty ")
					.put(9, "ninety ")
					.build();

		hundreds = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(1, "one hundred and ")
					.put(2, "two hundred and ")
					.put(3, "three hundred and ")
					.put(4, "four hundred and ")
					.put(5, "five hundred and ")
					.put(6, "six hundred and ")
					.put(7, "seven hundred and ")
					.put(8, "eight hundred and ")
					.put(9, "nine hundred and ")
					.build();
		
		thousands = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "thousand, ")
					.build();

		millions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "million, ")
					.build();

		positions = new ImmutableMapBuilder<Integer, Map<Integer, String>>()
					.put(2, hundreds)
					.put(1, tens)
					.put(0, units)
					.build();
	}
	
	@Override
	public String getCardinalNumbers(long i, String form) {
		return cardinalNumbers.get(i).get(SINGULAR);
	}
	
	@Override
	public String getCurrency(String s) {
		switch (s) {
			case SINGULAR:
			case PLURAL:
				return currency.get(s);
			case GENITIVE_CASE:
				return currency.get(PLURAL);
			default:
				return null;
		}
	}
}
