package pl.zielinska.numbers.languages;

import java.util.Map;

public abstract class LanguageScheme {
	protected Map<Integer, String> units, tens, teens, hundreds;
	protected Map<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	protected Map<Long, Map<String, String>> cardinalNumbers;
	protected Map<Integer, Map<Integer, String>> positions;
	

	public Map<Integer, String> getTeens() {
		return teens;
	}

	public Map<String, String> getCurrency() {
		return currency;
	}
	
	public Map<Long, Map<String, String>> getCardinalNumbers() {
		return cardinalNumbers;
	}
	
	public Map<Integer, Map<Integer, String>> getPositions() {
		return positions;
	}
}
