package pl.zielinska.numbers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class TestNumbersU {

	@Test
	public void testTextValue() {
		String wynik = NumbersUtil.textValue(Languages.PL, 1L);
		assertEquals("jeden złoty", wynik);
	}

}
