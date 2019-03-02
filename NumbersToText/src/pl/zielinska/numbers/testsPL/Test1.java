package pl.zielinska.numbers.testsPL;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test1 {

	@Test
	public void testTextValue() {
		assertEquals("jeden złoty", NumbersUtil.textValue(Languages.PL, 1L));
	}
}
