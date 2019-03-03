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
	

	public String getTeens(int i) {
		return teens.get(i);
	}

	public String getCurrency(String s) {
		return currency.get(s);
	}
	
	public Map<Long, Map<String, String>> getCardinalNumbers() {
		return cardinalNumbers;
	}
	
	public Map<String, String> getCardinalNumbers(long i) {
		return cardinalNumbers.get(i);
	}
	
	public Map<Integer, String> getPositions(int i) {
		return positions.get(i);
	}
}
