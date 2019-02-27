package pl.zielinska.library;

import java.util.HashMap;

public abstract class NumbersUtil  {
	private static HashMap<Integer, String> units, tens, teens, hundreds;
	private static HashMap<String, String> thousands, millions, billions, trillions, quadrillions, sextillions, currency;
	private static HashMap<Long, HashMap<String, String>> cardinalNumbers;
	private static HashMap<Integer, HashMap<Integer, String>> positions;
	private static StringBuilder text = new StringBuilder();
	private static int digit;
	private static int triple;
	private static int positionCount = 2;
	private static boolean teen = false;
	private static boolean state = false;
	
	private NumbersUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	private static void setLanguage() {
		units = new HashMap<>();
		units.put(0, "");
		units.put(1, "jeden ");
		units.put(2, "dwa ");
		units.put(3, "trzy ");
		units.put(4, "cztery ");
		units.put(5, "pięć ");
		units.put(6, "sześć ");
		units.put(7, "siedem ");
		units.put(8, "osiem ");
		units.put(9, "dziewięć ");

		teens = new HashMap<>();
		teens.put(10, "dziesięć ");
		teens.put(11, "jedynaście ");
		teens.put(12, "dwanaście ");
		teens.put(13, "trzynaście ");
		teens.put(14, "czternaście ");
		teens.put(15, "piętnaście ");
		teens.put(16, "szesnaście ");
		teens.put(17, "siedemnaście ");
		teens.put(18, "osiemnaście ");
		teens.put(19, "dziewiętnaście ");

		tens = new HashMap<>();
		tens.put(0, "");
		tens.put(2, "dwadzieścia ");
		tens.put(3, "trzydzieści ");
		tens.put(4, "czterdzieści ");
		tens.put(5, "pięćdziesiąt ");
		tens.put(6, "sześćdziesiąt ");
		tens.put(7, "siedemdziesiąt ");
		tens.put(8, "osiemdziesiąt ");
		tens.put(9, "dziewięćdziesiąt ");

		hundreds = new HashMap<>();
		hundreds.put(0, "");
		hundreds.put(1, "sto ");
		hundreds.put(2, "dzwieście ");
		hundreds.put(3, "trzysta ");
		hundreds.put(4, "czterysta ");
		hundreds.put(5, "pięćset ");
		hundreds.put(6, "sześćset ");
		hundreds.put(7, "siedemset ");
		hundreds.put(8, "osiemset ");
		hundreds.put(9, "dziewięćset ");

		currency = new HashMap<>();
		currency.put("singular", "złoty");
		currency.put("plural", "złote");
		currency.put("genitiveCase", "złotych");

		thousands = new HashMap<>();
		thousands.put("singular", "tysiąc ");
		thousands.put("plural", "tysiące ");
		thousands.put("genitiveCase", "tysięcy ");

		millions = new HashMap<>();
		millions.put("singular", "milion ");
		millions.put("plural", "milliony ");
		millions.put("genitiveCase", "milionów ");

		billions = new HashMap<>();
		billions.put("singular", "miliard ");
		billions.put("plural", "miliardy ");
		billions.put("genitiveCase", "miliardów ");

		trillions = new HashMap<>();
		trillions.put("singular", "bilion ");
		trillions.put("plural", "biliony ");
		trillions.put("genitiveCase", "bilionów ");

		quadrillions = new HashMap<>();
		quadrillions.put("singular", "biliard ");
		quadrillions.put("plural", "biliardy ");
		quadrillions.put("genitiveCase", "biliardów ");

		sextillions = new HashMap<>();
		sextillions.put("singular", "trylion ");
		sextillions.put("plural", "tryliony ");
		sextillions.put("genitiveCase", "trylionów ");

		cardinalNumbers = new HashMap<>();
		cardinalNumbers.put(1L, currency);
		cardinalNumbers.put(1_000L, thousands);
		cardinalNumbers.put(1_000_000L, millions);
		cardinalNumbers.put(1_000_000_000L, billions);
		cardinalNumbers.put(1_000_000_000_000L, trillions);
		cardinalNumbers.put(1_000_000_000_000_000L, quadrillions);
		cardinalNumbers.put(1_000_000_000_000_000_000L, sextillions);

		positions = new HashMap<>();
		positions.put(1, hundreds);
		positions.put(2, tens);
		positions.put(3, units);

	}
	
	private static boolean isTeen() {
		return positionCount == 2 && digit == 1L;

	}
	
	private static boolean isDigitOfANumber() {
		return !((digit == 0 && text.length() == 0) && !teen);
	}
	
	private static void assignTextToTeen() {
		final int key = 10 + digit;
		text.append(teens.get(key));
	}

	private static void assignTextToDigit() {
		text.append(positions.get(positionCount).get(digit));
	}
	
	private static void assignCardinalNumberText(long number, long i) {
		if (cardinalNumbers.containsKey(i)) {
			if (triple == 1) 
				setCardinal("singular", i);
			else if (digit > 1 && digit < 5) 
				setCardinal("plural", i);
			else if (triple == 0) {}
			else 
				setCardinal("genitiveCase", i);
		}
	}
	
	private static void setCardinal(String form, long i) {
		text.append(cardinalNumbers.get(i).get(form));
	}
	
	private static void setCurrency(String form) {
		text.append(currency.get(form));
		state = true;
	}
	
	private static void assignCurrencyText(long number, long i) {
		if (isCurrencyNeeded(number, i)) {
			setCurrency("genitiveCase");
		}
	}
	
	private static boolean isCurrencyNeeded(long number, long i) {
		return  positionCount == 3 && !state && number % i == 0;
	}
	
	private static void getDigit(long number, long i) {
		digit = (int) (number / i);
	}
	
	private static long moveToNextDigit(long number, long i) {
		return number - digit * i;
	}
	
	private static void resetPositionCount() {
		if (positionCount == 3)
			positionCount = 0;
	}
	
	private static void addToTriple() {
		triple += digit * (int) Math.pow(10, 3-positionCount);
	}
	
	private static void resetTriple() {
		if (positionCount == 3)
			triple = 0;
	}
	
	public static String textValue(long number) {
		setLanguage();
		final long NUMBER = number;
		for (long i = 1_000_000_000_000_000_000L; i > 0; i = i / 10) {
			positionCount++;
			getDigit(number, i);
			addToTriple();
			if (isTeen())
				teen = true;
			else if (isDigitOfANumber()) {
				if (teen)
					assignTextToTeen();
				else
					assignTextToDigit();
				assignCardinalNumberText(number, i);
				if (NUMBER > 1000)
					assignCurrencyText(number, i);
				teen = false;
			}
			number = moveToNextDigit(number, i);
			resetTriple();
			resetPositionCount();
		}
		return text.toString();
	}
}
