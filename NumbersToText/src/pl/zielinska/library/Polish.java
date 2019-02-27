package pl.zielinska.library;

import java.util.HashMap;

public class Polish extends LanguageScheme {
	public Polish() {
		units = new HashMap<>();
		units.put(0, "");
		units.put(1, "jeden ");
		units.put(2, "dwa ");
		units.put(3, "trzy ");
		units.put(4, "cztery ");
		units.put(5, "pięć ");
		units.put(6, "sześć ");
		units.put(7, "siedem ");
		units.put(8, "osiem ");
		units.put(9, "dziewięć ");

		teens = new HashMap<>();
		teens.put(10, "dziesięć ");
		teens.put(11, "jedynaście ");
		teens.put(12, "dwanaście ");
		teens.put(13, "trzynaście ");
		teens.put(14, "czternaście ");
		teens.put(15, "piętnaście ");
		teens.put(16, "szesnaście ");
		teens.put(17, "siedemnaście ");
		teens.put(18, "osiemnaście ");
		teens.put(19, "dziewiętnaście ");

		tens = new HashMap<>();
		tens.put(0, "");
		tens.put(2, "dwadzieścia ");
		tens.put(3, "trzydzieści ");
		tens.put(4, "czterdzieści ");
		tens.put(5, "pięćdziesiąt ");
		tens.put(6, "sześćdziesiąt ");
		tens.put(7, "siedemdziesiąt ");
		tens.put(8, "osiemdziesiąt ");
		tens.put(9, "dziewięćdziesiąt ");

		hundreds = new HashMap<>();
		hundreds.put(0, "");
		hundreds.put(1, "sto ");
		hundreds.put(2, "dzwieście ");
		hundreds.put(3, "trzysta ");
		hundreds.put(4, "czterysta ");
		hundreds.put(5, "pięćset ");
		hundreds.put(6, "sześćset ");
		hundreds.put(7, "siedemset ");
		hundreds.put(8, "osiemset ");
		hundreds.put(9, "dziewięćset ");

		currency = new HashMap<>();
		currency.put("singular", "złoty");
		currency.put("plural", "złote");
		currency.put("genitiveCase", "złotych");

		thousands = new HashMap<>();
		thousands.put("singular", "tysiąc ");
		thousands.put("plural", "tysiące ");
		thousands.put("genitiveCase", "tysięcy ");

		millions = new HashMap<>();
		millions.put("singular", "milion ");
		millions.put("plural", "milliony ");
		millions.put("genitiveCase", "milionów ");

		billions = new HashMap<>();
		billions.put("singular", "miliard ");
		billions.put("plural", "miliardy ");
		billions.put("genitiveCase", "miliardów ");

		trillions = new HashMap<>();
		trillions.put("singular", "bilion ");
		trillions.put("plural", "biliony ");
		trillions.put("genitiveCase", "bilionów ");

		quadrillions = new HashMap<>();
		quadrillions.put("singular", "biliard ");
		quadrillions.put("plural", "biliardy ");
		quadrillions.put("genitiveCase", "biliardów ");

		sextillions = new HashMap<>();
		sextillions.put("singular", "trylion ");
		sextillions.put("plural", "tryliony ");
		sextillions.put("genitiveCase", "trylionów ");

		cardinalNumbers = new HashMap<>();
		cardinalNumbers.put(1L, currency);
		cardinalNumbers.put(1_000L, thousands);
		cardinalNumbers.put(1_000_000L, millions);
		cardinalNumbers.put(1_000_000_000L, billions);
		cardinalNumbers.put(1_000_000_000_000L, trillions);
		cardinalNumbers.put(1_000_000_000_000_000L, quadrillions);
		cardinalNumbers.put(1_000_000_000_000_000_000L, sextillions);

		positions = new HashMap<>();
		positions.put(1, hundreds);
		positions.put(2, tens);
		positions.put(3, units);

	}
}
