package pl.zielinska.numbers.util;

import java.math.BigDecimal;


import pl.zielinska.numbers.languages.Languages;

public final class NumbersUtil  {
	
	private NumbersUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	
	public static String textValue(Languages lingo, long number) {
		return new TextBuilder(lingo)
				.append(number)
				.currency(number)
				.build();
	}
	
	public static String textValue(Languages lingo, BigDecimal number) {
		TextBuilder text = new TextBuilder(lingo)
				.append(number.longValue())
				.currency(number.longValue());
		if (!BigDecimal.ZERO.equals(decimal(number))) {
			final long decimal = decimal(number).longValue();
			
			if (lingo == Languages.PL)
				text.append(", ");
			else
				text.append(" and ");
			
			text.append(decimal)
				.coins(decimal);
		}
		return text.build();
	}
	
	private static BigDecimal decimal(BigDecimal number) {
		return (number.subtract(BigDecimal.valueOf(number.longValue())).multiply(BigDecimal.valueOf(100)));
	}
	
}
