package pl.zielinska.numbers.languages;

import java.util.HashMap;

public class British extends English{
	public static final British INSTANCE = new British();
	
	private British() {
		super();
		
		currency = new HashMap<>();
		currency.put(SINGULAR, "pound");
		currency.put(PLURAL, "pounds");
		
		billions = new HashMap<>();
		billions.put(SINGULAR, "miliard, ");

		trillions = new HashMap<>();
		trillions.put(SINGULAR, "billion, ");

		quadrillions = new HashMap<>();
		quadrillions.put(SINGULAR, "billiard, ");

		sextillions = new HashMap<>();
		sextillions.put(SINGULAR, "trillion, ");

		cardinalNumbers = new HashMap<>();
		cardinalNumbers.put(1_000L, thousands);
		cardinalNumbers.put(1_000_000L, millions);
		cardinalNumbers.put(1_000_000_000L, billions);
		cardinalNumbers.put(1_000_000_000_000L, trillions);
		cardinalNumbers.put(1_000_000_000_000_000L, quadrillions);
		cardinalNumbers.put(1_000_000_000_000_000_000L, sextillions);
	}
}
