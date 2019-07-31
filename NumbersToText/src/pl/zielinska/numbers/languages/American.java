package pl.zielinska.numbers.languages;

import java.util.HashMap;

public class American extends English{
	public static final American INSTANCE = new American();
	
	private American() {
		super();
		
		currency = new HashMap<>();
		currency.put(SINGULAR, "dollar");
		currency.put(PLURAL, "dollars");

		billions = new HashMap<>();
		billions.put(SINGULAR, "billion, ");

		trillions = new HashMap<>();
		trillions.put(SINGULAR, "trillion, ");

		quadrillions = new HashMap<>();
		quadrillions.put(SINGULAR, "quadrillion, ");

		sextillions = new HashMap<>();
		sextillions.put(SINGULAR, "sextillion, ");

		cardinalNumbers = new HashMap<>();
		cardinalNumbers.put(1_000L, thousands);
		cardinalNumbers.put(1_000_000L, millions);
		cardinalNumbers.put(1_000_000_000L, billions);
		cardinalNumbers.put(1_000_000_000_000L, trillions);
		cardinalNumbers.put(1_000_000_000_000_000L, quadrillions);
		cardinalNumbers.put(1_000_000_000_000_000_000L, sextillions);
	}
	
}
