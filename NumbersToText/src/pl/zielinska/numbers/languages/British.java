package pl.zielinska.numbers.languages;

import java.util.HashMap;

public class British extends English{
	
	public British() {
		super();
		
		currency = new HashMap<>();
		currency.put("singular", "pound");
		currency.put("plural", "pounds");
		currency.put("genitiveCase", "pounds");
		
		billions = new HashMap<>();
		billions.put("singular", "miliard ");
		billions.put("plural", "miliards ");
		billions.put("genitiveCase", "miliards ");

		trillions = new HashMap<>();
		trillions.put("singular", "billion ");
		trillions.put("plural", "billions ");
		trillions.put("genitiveCase", "billions ");

		quadrillions = new HashMap<>();
		quadrillions.put("singular", "billiard ");
		quadrillions.put("plural", "billiards ");
		quadrillions.put("genitiveCase", "billiards ");

		sextillions = new HashMap<>();
		sextillions.put("singular", "trillion ");
		sextillions.put("plural", "trillions ");
		sextillions.put("genitiveCase", "trillions ");

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
