package pl.zielinska.library;

import java.util.Map;

abstract class LanguageScheme {
	public Map<Integer, String> units, tens, teens, hundreds;
	public Map<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	public Map<Long, Map<String, String>> cardinalNumbers;
	public Map<Integer, Map<Integer, String>> positions;
	
}
