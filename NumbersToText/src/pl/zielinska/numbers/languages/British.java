package pl.zielinska.numbers.languages;

import java.util.HashMap;

public class British extends English{
	
	public British() {
		super();
		
		currency = new HashMap<>();
		currency.put(SINGULAR, "pound");
		currency.put(PLURAL, "pounds");
		currency.put(GENITIVE_CASE, "pounds");
		
		billions = new HashMap<>();
		billions.put(SINGULAR, "miliard ");
		billions.put(PLURAL, "miliards ");
		billions.put(GENITIVE_CASE, "miliards ");

		trillions = new HashMap<>();
		trillions.put(SINGULAR, "billion ");
		trillions.put(PLURAL, "billions ");
		trillions.put(GENITIVE_CASE, "billions ");

		quadrillions = new HashMap<>();
		quadrillions.put(SINGULAR, "billiard ");
		quadrillions.put(PLURAL, "billiards ");
		quadrillions.put(GENITIVE_CASE, "billiards ");

		sextillions = new HashMap<>();
		sextillions.put(SINGULAR, "trillion ");
		sextillions.put(PLURAL, "trillions ");
		sextillions.put(GENITIVE_CASE, "trillions ");

		cardinalNumbers = new HashMap<>();
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