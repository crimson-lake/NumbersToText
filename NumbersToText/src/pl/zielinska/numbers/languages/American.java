package pl.zielinska.numbers.languages;

import java.util.HashMap;

public class American extends English{
	
	public American() {
		super();
		
		currency = new HashMap<>();
		currency.put(SINGULAR, "dollar");
		currency.put(PLURAL, "dollars");

		billions = new HashMap<>();
		billions.put(SINGULAR, "billion ");
		billions.put(PLURAL, "billions ");

		trillions = new HashMap<>();
		trillions.put(SINGULAR, "trillion ");
		trillions.put(PLURAL, "trillions ");

		quadrillions = new HashMap<>();
		quadrillions.put(SINGULAR, "quadrillion ");
		quadrillions.put(PLURAL, "quadrillions ");

		sextillions = new HashMap<>();
		sextillions.put(SINGULAR, "sextillion ");
		sextillions.put(PLURAL, "sextillions ");

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
