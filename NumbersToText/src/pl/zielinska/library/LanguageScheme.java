package pl.zielinska.library;

import java.util.Map;

abstract class LanguageScheme {
	public static Map<Integer, String> units, tens, teens, hundreds;
	public static Map<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	public static Map<Long, Map<String, String>> cardinalNumbers;
	public static Map<Integer, Map<Integer, String>> positions;
}
