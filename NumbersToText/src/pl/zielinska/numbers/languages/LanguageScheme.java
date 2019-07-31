package pl.zielinska.numbers.languages;

import java.util.Map;

public abstract class LanguageScheme {
	protected Map<Integer, String> units, tens, teens, hundreds;
	protected Map<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	protected Map<Long, Map<String, String>> cardinalNumbers;
	protected Map<Integer, Map<Integer, String>> positions;
	protected static final String SINGULAR = "singular";
	protected static final String PLURAL = "plural";
	protected static final String GENITIVE_CASE = "genitiveCase";
	
	public static LanguageScheme getLanguage(Languages lingo) {
		switch (lingo) {
		case PL: 
			return Polish.INSTANCE;
		case US: 
			return American.INSTANCE;
		case GB:
			return British.INSTANCE;
		default:
			return null;
		}	
	}
	
	public String getTeens(int i) {
		return teens.get(i);
	}

	public String getCurrency(String s) {
		return currency.get(s);
	}
	
	public Map<Long, Map<String, String>> getCardinalNumbers() {
		return cardinalNumbers;
	}
	
	public String getCardinalNumbers(long i, String form) {
		return cardinalNumbers.get(i).get(form);
	}
	
	public String getDigit(int i, int digit) {
		return positions.get(i).get(digit);
	}
}
