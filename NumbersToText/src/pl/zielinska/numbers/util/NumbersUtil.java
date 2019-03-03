package pl.zielinska.numbers.util;

import pl.zielinska.numbers.languages.American;
import pl.zielinska.numbers.languages.British;
import pl.zielinska.numbers.languages.LanguageScheme;
import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.languages.Polish;

public abstract class NumbersUtil  {
	private static StringBuilder text = new StringBuilder();
	private static int digit;
	private static int triple;
	private static int positionCount = 2;
	private static boolean teen = false;
	private static boolean state = false;
	private static LanguageScheme language;
	
	private NumbersUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String textValue(Languages lingo, long number) {
		language = selectLanguage(lingo);
		convertNumberToText(number);
		return text.toString();
	}
	
	private static LanguageScheme selectLanguage(Languages lingo) {
		switch (lingo) {
			case PL: 
				return new Polish();
			case US: 
				return new American();
			case GB:
				return new British();
			default:
				return null;
		}	
	}
	
	private static void convertNumberToText(long number) {
		final long NUMBER = number;
		final long maxLongSignificantDigit = 1_000_000_000_000_000_000L;
		final long minLongSignificantDigit = 1L;
		long currentDigitPosition = maxLongSignificantDigit;
		while (currentDigitPosition >= minLongSignificantDigit) {
			positionCount++;
			getDigit(number, currentDigitPosition);
			addToTriple();
			if (isTeen())
				teen = true;
			else if (isDigitOfANumber()) {
				if (teen)
					assignTextToTeen();
				else
					assignTextToDigit();
				assignCardinalNumberText(currentDigitPosition);
				assignCurrencyText(number, currentDigitPosition, NUMBER);
				teen = false;
			}
			number = moveToNextDigit(number, currentDigitPosition);
			resetTriple();
			resetPositionCount();
			currentDigitPosition = nextSignificantDigitPosition(currentDigitPosition);
		}
	}
	
	private static long nextSignificantDigitPosition(long currentDigitPosition) {
		return currentDigitPosition/10;
	}
	
	private static void getDigit(long number, long currentDigitPosition) {
		digit = (int) (number / currentDigitPosition);
	}
	
	private static void addToTriple() {
		triple += digit * (int) Math.pow(10, 3 - positionCount);
	}
	
	private static boolean isTeen() {
		return positionCount == 2 && digit == 1L;
	}
	
	private static boolean isDigitOfANumber() {
		return !((digit == 0 && text.length() == 0) && !teen);
	}
	
	private static void assignTextToTeen() {
		final int key = 10 + digit;
		text.append(language.getTeens(key));
	}

	private static void assignTextToDigit() {
		text.append(language.getPositions(positionCount).get(digit));
	}
	
	private static void assignCardinalNumberText(long currentDigitPosition) {
		if (language.getCardinalNumbers().containsKey(currentDigitPosition)) {
			if (triple == 1) 
				addCardinal("singular", currentDigitPosition);
			else if (digit > 1 && digit < 5) 
				addCardinal("plural", currentDigitPosition);
			else if (triple != 0)
				addCardinal("genitiveCase", currentDigitPosition);
		}
	}
	
	private static void addCardinal(String form, long currentDigitPosition) {
		text.append(language.getCardinalNumbers(currentDigitPosition, form));
	}
		
	private static void assignCurrencyText(long number, long currentDigitPosition, long NUMBER) {
		if (isCurrencyNeeded(number, currentDigitPosition)) {
			if (NUMBER == 1) 
				addCurrency("singular");
			else if (digit > 1 && digit < 5 && !teen) 
				addCurrency("plural");
			else 
				addCurrency("genitiveCase");
		}
	}
	
	private static boolean isCurrencyNeeded(long number, long currentDigitPosition) {
		return  positionCount == 3 && !state && number % currentDigitPosition == 0;
	}
	
	private static void addCurrency(String form) {
		text.append(language.getCurrency(form));
		state = true;
	}
	
	private static long moveToNextDigit(long number, long currentDigitPosition) {
		return number - digit*currentDigitPosition;
	}
	
	private static void resetPositionCount() {
		if (positionCount == 3)
			positionCount = 0;
	}
	
	private static void resetTriple() {
		if (positionCount == 3)
			triple = 0;
	}
}
