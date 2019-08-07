package pl.zielinska.numbers.util;

import java.math.BigDecimal;


import pl.zielinska.numbers.languages.Languages;

public final class NumbersUtil  {
	
	private NumbersUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	
	public static String textValue(Languages lingo, long number) {
		TextBuilder text = new TextBuilder(lingo);
		if (number < 0) {
			text.append("minus ");
			number = -number;
		}
		return text.append(number)
				.currency(number)
				.build();
	}
	
	public static String textValue(Languages lingo, BigDecimal number) {
		
		TextBuilder text = new TextBuilder(lingo);
		
		if (number.compareTo(BigDecimal.ZERO) < 0) {
			text.append("minus ");
			number = number.negate();
		}
		
		text.append(number.longValue())
			.currency(number.longValue());
		
		if (BigDecimal.ZERO.compareTo(decimal(number)) != 0) {
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
