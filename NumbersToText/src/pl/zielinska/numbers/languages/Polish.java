package pl.zielinska.numbers.languages;

import java.util.Map;

public class Polish extends LanguageScheme {
	public static final Polish INSTANCE = new Polish();
	
	private Polish() {
		units = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(1, "jeden ")
					.put(2, "dwa ")
					.put(3, "trzy ")
					.put(4, "cztery ")
					.put(5, "pięć ")
					.put(6, "sześć ")
					.put(7, "siedem ")
					.put(8, "osiem ")
					.put(9, "dziewięć ")
					.build();

		teens = new ImmutableMapBuilder<Integer, String>()
					.put(10, "dziesięć ")
					.put(11, "jedynaście ")
					.put(12, "dwanaście ")
					.put(13, "trzynaście ")
					.put(14, "czternaście ")
					.put(15, "piętnaście ")
					.put(16, "szesnaście ")
					.put(17, "siedemnaście ")
					.put(18, "osiemnaście ")
					.put(19, "dziewiętnaście ")
					.build();
		

		tens = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(2, "dwadzieścia ")
					.put(3, "trzydzieści ")
					.put(4, "czterdzieści ")
					.put(5, "pięćdziesiąt ")
					.put(6, "sześćdziesiąt ")
					.put(7, "siedemdziesiąt ")
					.put(8, "osiemdziesiąt ")
					.put(9, "dziewięćdziesiąt ")
					.build();

		hundreds = new ImmutableMapBuilder<Integer, String>()
					.put(0, "")
					.put(1, "sto ")
					.put(2, "dwieście ")
					.put(3, "trzysta ")
					.put(4, "czterysta ")
					.put(5, "pięćset ")
					.put(6, "sześćset ")
					.put(7, "siedemset ")
					.put(8, "osiemset ")
					.put(9, "dziewięćset ")
					.build();

		currency = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "złoty")
					.put(PLURAL, "złote")
					.put(GENITIVE_CASE, "złotych")
					.build();

		thousands = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "tysiąc ")
					.put(PLURAL, "tysiące ")
					.put(GENITIVE_CASE, "tysięcy ")
					.build();

		millions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "milion ")
					.put(PLURAL, "milliony ")
					.put(GENITIVE_CASE, "milionów ")
					.build();

		billions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "miliard ")
					.put(PLURAL, "miliardy ")
					.put(GENITIVE_CASE, "miliardów ")
					.build();

		trillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "bilion ")
					.put(PLURAL, "biliony ")
					.put(GENITIVE_CASE, "bilionów ")
					.build();

		quadrillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "biliard ")
					.put(PLURAL, "biliardy ")
					.put(GENITIVE_CASE, "biliardów ")
					.build();

		sextillions = new ImmutableMapBuilder<String, String>()
					.put(SINGULAR, "trylion ")
					.put(PLURAL, "tryliony ")
					.put(GENITIVE_CASE, "trylionów ")
					.build();

		cardinalNumbers = new ImmutableMapBuilder<Long, Map<String, String>>()
					.put(1_000L, thousands)
					.put(1_000_000L, millions)
					.put(1_000_000_000L, billions)
					.put(1_000_000_000_000L, trillions)
					.put(1_000_000_000_000_000L, quadrillions)
					.put(1_000_000_000_000_000_000L, sextillions)
					.build();

		positions = new ImmutableMapBuilder<Integer, Map<Integer, String>>()
					.put(2, hundreds)
					.put(1, tens)
					.put(0, units)
					.build();

	}
}
