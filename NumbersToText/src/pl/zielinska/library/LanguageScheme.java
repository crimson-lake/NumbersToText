package pl.zielinska.library;

import java.util.Map;

abstract class LanguageScheme {
	protected Map<Integer, String> units, tens, teens, hundreds;
	protected Map<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	protected Map<Long, Map<String, String>> cardinalNumbers;
	protected Map<Integer, Map<Integer, String>> positions;
	
}
