package pl.zielinska.numbers.languages;

import java.util.Map;

public class American extends English{
	public static final American INSTANCE = new American();
	
	private American() {
		super();
		
		currency = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "dollar")
					.put(PLURAL, "dollars")
					.build();
		
		coins = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "cent")
					.put(PLURAL, "cents")
					.build();

		billions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "billion, ")
					.build();

		trillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "trillion, ")
					.build();

		quadrillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "quadrillion, ")
					.build();

		sextillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "sextillion, ")
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
