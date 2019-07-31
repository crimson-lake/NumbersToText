package pl.zielinska.numbers.languages;

import java.util.Map;

public class British extends English{
	public static final British INSTANCE = new British();
	
	private British() {
		super();
		
		currency = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "pound")
					.put(PLURAL, "pounds")
					.build();
		
		coins = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "pence")
					.put(PLURAL, "pences")
					.build();
		
		billions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "miliard, ")
					.build();

		trillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "billion, ")
					.build();

		quadrillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "billiard, ")
					.build();

		sextillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "trillion, ")
					.build();

		cardinalNumbers = new ImmutableMapBuilder<Long, Map<String, String>>()
					.put(1_000L, thousands)
					.put(1_000_000L, millions)
					.put(1_000_000_000L, billions)
					.put(1_000_000_000_000L, trillions)
					.put(1_000_000_000_000_000L, quadrillions)
					.put(1_000_000_000_000_000_000L, sextillions)
					.build();
	}
}
