package pl.zielinska.library;

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
	
	private static boolean isTeen() {
		return positionCount == 2 && digit == 1L;

	}
	
	private static boolean isDigitOfANumber() {
		return !((digit == 0 && text.length() == 0) && !teen);
	}
	
	private static void assignTextToTeen() {
		final int key = 10 + digit;
		text.append(language.teens.get(key));
	}

	private static void assignTextToDigit() {
		text.append(language.positions.get(positionCount).get(digit));
	}
	
	private static void assignCardinalNumberText(long number, long i) {
		if (language.cardinalNumbers.containsKey(i)) {
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
		text.append(language.cardinalNumbers.get(i).get(form));
	}
	
	private static void setCurrency(String form) {
		text.append(language.currency.get(form));
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
	
	private static LanguageScheme selectLanguage(Languages lingo) {
		if (lingo.equals(Languages.PL))
			return new Polish();	
		else if (lingo.equals(Languages.US))
			return new American();
		else
			return null;
	}
	
	public static String textValue(Languages lingo, long number) {
		language = selectLanguage(lingo);
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
