package pl.zielinska.numbers.util;

import pl.zielinska.numbers.languages.American;
import pl.zielinska.numbers.languages.British;
import pl.zielinska.numbers.languages.LanguageScheme;
import pl.zielinska.numbers.languages.Languages;

public class TextBuilder {
	private StringBuilder text = new StringBuilder();
	private int digit;
	private int triple;
	private int positionWeight;
	private boolean teen = false;
	private final LanguageScheme language;
	
	public TextBuilder(Languages lingo) {
		language = LanguageScheme.getLanguage(lingo);
	}
	
	public TextBuilder append(String s) {
		text.append(s);
		return this;
	}
	
	public TextBuilder append(long number) {
		convertNumberToText(number);
		return this;
	}
	
	public TextBuilder currency(long number) {
		addCurrency(currencyForm(number));
		clean();
		return this;
	}
	
	public TextBuilder coins(long number) {
		addCoins(currencyForm(number));
		return this;
	}
	
	public String build() {
		return text.toString();
	}
	
	private void clean() {
		teen = false;
		resetTripleAndPositionWeight();
	}
	
	private void convertNumberToText(long number) {
		positionWeight = getFirstPosition(number);
		if(number == 0) {
			text.append("zero ");
		} else {
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
		}
		deleteSpareComma();
	}
	
	private long numberOfDigits(long number) {
		return (long) Math.log10(number);
	}
	
	private long firstSignificantDigit(long number) {
		return (long) Math.pow(10, numberOfDigits(number));
	}
	
	private long nextSignificantDigitPosition(long currentDigitPosition) {
		return currentDigitPosition/10;
	}
	
	private int getFirstPosition(long number) {
		long numberOfDigits = numberOfDigits(number)+1; 
		if (numberOfDigits%3 == 0)
			return 2;
		else if ((numberOfDigits + 1)%3 == 0)
			return 1;
		else 
			return 0;
		
	}
	
	private void getDigit(long number, long currentDigitPosition) {
		digit = (int) (number / currentDigitPosition);
	}
	
	private void addToTriple() {
		triple += digit * (int) Math.pow(10, positionWeight);
	}
	
	private boolean isTeen() {
		return positionWeight == 1 && digit == 1;
	}
	
	private void assignTextToTeen() {
		final int key = 10 + digit;
		text.append(language.getTeens(key));
	}

	private void assignTextToDigit() {
		handlingEnglishRules();
		if (teen)
			assignTextToTeen();
		else
			text.append(language.getDigit(positionWeight, digit));
	}
	
	private void handlingEnglishRules() {
		if (isEnglish()) {
			if (isDashNeeded()) {
				text.setLength(text.length() - 1);
				text.append("-");
			}
			if (isAndNotNeeded()) 
				text.setLength(text.length() - 4);
		}
	}
	
	private boolean isEnglish() {
		return (language instanceof British || language instanceof American );
	}
	
	private boolean isDashNeeded() {
		return positionWeight == 0 && triple%100 < 99 && triple%100 > 21 && text.length() !=0;
	}
	
	private boolean isAndNotNeeded() {
		return positionWeight == 0 && triple/100 >= 1 && triple%100 == 0 && text.length() !=0;
	}
	
	private void assignCardinalNumberText(long currentDigitPosition) {
		if (language.getCardinalNumbers().containsKey(currentDigitPosition)) {
			if (triple == 1) 
				addCardinal("singular", currentDigitPosition);
			else if (digit > 1 && digit < 5) 
				addCardinal("plural", currentDigitPosition);
			else if (triple != 0)
				addCardinal("genitiveCase", currentDigitPosition);
		}
	}
	
	private void addCardinal(String form, long currentDigitPosition) {
		text.append(language.getCardinalNumbers(currentDigitPosition, form));
	}
	
	private String currencyForm(long number) {
		if (number == 1) 
			return "singular";
		else if (digit > 1 && digit < 5 && !teen) 
			return "plural";
		else 
			return "genitiveCase";
	}
	
	private void addCurrency(String form) {
		text.append(language.getCurrency(form));
	}
	
	private void addCoins(String form) {
		text.append(language.getCoins(form));
	}
	
	private long moveToNextDigit(long number, long currentDigitPosition) {
		return number - digit*currentDigitPosition;
	}
	
	private void resetTripleAndPositionWeight() {
		if (positionWeight == 0) {
			triple = 0;
			positionWeight = 3;
		}
	}

	private void deleteSpareComma() {
		if (text.charAt(text.length() - 2) == ',')
			text.deleteCharAt(text.length() - 2);
	}
	
}
