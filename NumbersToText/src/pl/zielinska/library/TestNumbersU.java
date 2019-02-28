package pl.zielinska.library;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumbersU {

	@Test
	public void testTextValue() {
		String wynik = NumbersUtil.textValue(Languages.PL, 1L);
		assertEquals("jeden złoty", wynik);
	}

}
