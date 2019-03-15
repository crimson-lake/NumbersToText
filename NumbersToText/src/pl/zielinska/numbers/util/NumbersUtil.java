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
	private static int positionWeight;
	private static boolean teen = false;
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
		positionWeight = getFirstPosition(number);
		final long minLongSignificantDigit = 1L;
		long currentDigitPosition = firstSignificantDigit(number);
		while (currentDigitPosition >= minLongSignificantDigit) {
			getDigit(number, currentDigitPosition);
			addToTriple();
			if (isTeen())
				teen = true;
			else {
				assignTextToDigit();
				assignCardinalNumberText(currentDigitPosition);
				if (currentDigitPosition == minLongSignificantDigit)
					break;
				teen = false;
			}
			number = moveToNextDigit(number, currentDigitPosition);
			resetTripleAndPositionWeight();
			currentDigitPosition = nextSignificantDigitPosition(currentDigitPosition);
			positionWeight--;
		}
		deleteSpareComma();
		assignCurrencyText(NUMBER);
	}
	
	private static long numberOfDigits(long number) {
		return (long) Math.log10(number);
	}
	
	private static long firstSignificantDigit(long number) {
		return (long) Math.pow(10, numberOfDigits(number));
	}
	
	private static long nextSignificantDigitPosition(long currentDigitPosition) {
		return currentDigitPosition/10;
	}
	
	private static int getFirstPosition(long number) {
		long numberOfDigits = numberOfDigits(number)+1; 
		if (numberOfDigits%3 == 0)
			return 2;
		else if ((numberOfDigits + 1)%3 == 0)
			return 1;
		else 
			return 0;
		
	}
	
	private static void getDigit(long number, long currentDigitPosition) {
		digit = (int) (number / currentDigitPosition);
	}
	
	private static void addToTriple() {
		triple += digit * (int) Math.pow(10, positionWeight);
	}
	
	private static boolean isTeen() {
		return positionWeight == 1 && digit == 1;
	}
	
	private static void assignTextToTeen() {
		final int key = 10 + digit;
		text.append(language.getTeens(key));
	}

	private static void assignTextToDigit() {
		handlingEnglishRules();
		if (teen)
			assignTextToTeen();
		else
			text.append(language.getDigit(positionWeight, digit));
	}
	
	private static void handlingEnglishRules() {
		if (isEnglish()) {
			if (isDashNeeded()) {
				text.setLength(text.length() - 1);
				text.append("-");
			}
			if (isAndNotNeeded()) 
				text.setLength(text.length() - 4);
		}
	}
	
	private static boolean isEnglish() {
		return (language instanceof British || language instanceof American );
	}
	
	private static boolean isDashNeeded() {
		return positionWeight == 0 && triple%100 < 99 && triple%100 > 21;
	}
	
	private static boolean isAndNotNeeded() {
		return positionWeight == 0 && triple/100 >= 1 && triple%100 == 0;
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
		
	private static void assignCurrencyText(long NUMBER) {
		if (NUMBER == 1) 
			addCurrency("singular");
		else if (digit > 1 && digit < 5 && !teen) 
			addCurrency("plural");
		else 
			addCurrency("genitiveCase");
	}
	
	private static void addCurrency(String form) {
		text.append(language.getCurrency(form));
	}
	
	private static long moveToNextDigit(long number, long currentDigitPosition) {
		return number - digit*currentDigitPosition;
	}
	
	private static void resetTripleAndPositionWeight() {
		if (positionWeight == 0) {
			triple = 0;
			positionWeight = 3;
		}
	}

	private static void deleteSpareComma() {
		if (text.charAt(text.length() - 2) == ',')
			text.deleteCharAt(text.length() - 2);
	}
}
